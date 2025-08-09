/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.ejb.bl.EncryptedmesaagesFacadeLocal;

/**
 *
 * @author nkamb
 */
public class ViewBestPerformingFieldAgentServlet extends HttpServlet {

    @EJB private EncryptedmesaagesFacadeLocal emfl;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        String bestPerformingAgent = emfl.ViewBestPerformingFieldAgent();
        
        session.setAttribute("bestPerformingAgent", bestPerformingAgent);
        
        request.getRequestDispatcher("best_performing_agent_outcome.jsp").forward(request, response);
    }
}
