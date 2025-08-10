package za.ac.tut.web.servlet;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.web.exception.*;
import za.ac.tut.web.service.ValidateAgentInterface;


@WebServlet("/initialize")
public class InitializeServlet extends HttpServlet {

    @EJB
    private ValidateAgentInterface validateAgent;  

    public InitializeServlet() {
        System.out.println("InitializeServlet constructor called. Instance: " + this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("doPost called. Instance: " + this);

        HttpSession session = request.getSession(true);
        String agentID = request.getParameter("agentID").trim();
        String agentName = request.getParameter("agentName").trim();

        try {
            validateAgent.validateAgentID(agentID);

            session.setAttribute("agentID", agentID);
            session.setAttribute("agentName", agentName);

            request.getRequestDispatcher("welcome_outcome.jsp").forward(request, response);

        } catch (NotRequiedLengthException ex) {
            session.setAttribute("error", "Length Error: " + ex.getMessage());
            request.getRequestDispatcher("error_length_outcom.jsp").forward(request, response);
        } catch (NotDigitException ex) {
            session.setAttribute("error", "Not Digit Error: " + ex.getMessage());
            request.getRequestDispatcher("error_not_digit_outcom.jsp").forward(request, response);
        } catch (UserExistException ex) {
            session.setAttribute("error", "User Exist Error: " + ex.getMessage());
            request.getRequestDispatcher("error_user_exist_outcom.jsp").forward(request, response);
        }
    }

}
