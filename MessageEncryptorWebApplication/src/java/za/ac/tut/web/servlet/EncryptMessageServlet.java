package za.ac.tut.web.servlet;

import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.ejb.bl.*;
import za.ac.tut.ejb.model.*;
import za.ac.tut.web.exception.NotEmptyException;
import za.ac.tut.web.service.ValidateAgentInterface;

@WebServlet("/encrypt")
public class EncryptMessageServlet extends HttpServlet {

    @EJB
    private UsersFacadeLocal ufl;

    @EJB
    private EncryptedmessagesFacadeLocal emfl;
    
    private ValidateAgentInterface validateAgent = new za.ac.tut.web.service.ValidateAgents();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        try {
            String agentID = (String) session.getAttribute("agentID");
            String plaintext = request.getParameter("plaintext").trim().toLowerCase();
            
            validateAgent.validateMessage(plaintext);
            String cyphertext = encryptMessage(plaintext);
            Date datecreated = new Date();
            
            Users user = ufl.find(agentID);
            if (user == null) {
                user = new Users(agentID);
                ufl.create(user);
            }


            Encryptedmessages message = new Encryptedmessages(cyphertext, datecreated, user);
            emfl.create(message);
            
            session.setAttribute("agentID", agentID);
            session.setAttribute("cyphertext", cyphertext);
            
            request.getRequestDispatcher("encrypted_message_outcome.jsp").forward(request, response);
            
        } catch (NotEmptyException ex) {
            session.setAttribute("error", "Textarea Not Empty Error: " + ex.getMessage());
            request.getRequestDispatcher("error_not_empty_outcome.jsp").forward(request, response);
        }
    }

    private String encryptMessage(String plaintext) {
        StringBuilder cyphertext = new StringBuilder();
        char[] tempText = plaintext.toLowerCase().toCharArray();

        for (char currentChar : tempText) {
            if (Character.isLetter(currentChar)) {
                char encryptedChar = (char) (((currentChar - 'a' + 3) % 26) + 'a');
                cyphertext.append(encryptedChar);
            } else if (Character.isWhitespace(currentChar)) {
                cyphertext.append('#');  
            } else if (Character.isDigit(currentChar)) {
                cyphertext.append(currentChar);
            } else {
                cyphertext.append(currentChar);
            }
        }

        return cyphertext.toString();
    }
}