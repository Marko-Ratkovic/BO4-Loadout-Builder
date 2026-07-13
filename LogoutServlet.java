package com.bo4loadouts.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet that handles user logout
 * Invalidates the current session and redirects to the homepage
 * @author Marko
 */
public class LogoutServlet extends HttpServlet {
    
    /**
     * Default constructor
     */
    public LogoutServlet() {
        
    }
    
    /**
     * Invalidates the user's session and redirects to the homepage.
     * @param req the incoming HTTP request.
     * @param resp the outgoing HTTP response
     * @throws ServletException if a servlet error occurs.
     * @throws IOException if an I/O error occurs during redirect.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        resp.sendRedirect(req.getContextPath() + "/index");
    }
}
