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
import za.ac.tut.web.service.ValidateAgent;  // Updated import

@WebServlet("/initialize")
public class InitializeServlet extends HttpServlet {

    @EJB
    private ValidateAgent validateAgent;  // Now properly references the service package

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        String agentID = request.getParameter("agentID");
        String agentName = request.getParameter("agentName");
        
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
    /*
    private void handleError(HttpSession session, HttpServletRequest request,
                           HttpServletResponse response, String prefix,
                           Exception ex, String errorPage) 
            throws ServletException, IOException {
        session.setAttribute("error", prefix + ex.getMessage());
        request.getRequestDispatcher(errorPage).forward(request, response);
    }*/
}