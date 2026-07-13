package com.bo4loadouts.servlet;

import com.bo4loadouts.dao.UserDAO;
import com.bo4loadouts.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet that handles user login.
 * GET requests serve the login form.
 * POST requests validate credentials and create a session on success.
 * @author Marko
 */
public class LoginServlet extends HttpServlet {
    
    /**
     * Default constructor
     */
    public LoginServlet() {
        
    }
    
    /**
     * Data access object for user operations.
     */
    private static final UserDAO userDAO = new UserDAO();
    
    /**
     * Serves the login form page.
     * @param req the incoming HTTP request.
     * @param resp the outgoing HTTP response.
     * @throws ServletException if the request dispatcher fails.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
    
    /**
     * Processes the login form submission.
     * Validates credentials against the database and creates a session
     * storing the logged-in user if successful.
     * Redirects to the homepage on success or returns an error on failure.
     * @param req the incoming HTTP request containing form parameters.
     * @param resp the outgoing HTTP response.
     * @throws ServletException if the request dispatcher fails.
     * @throws IOException if an I/O error occurs.
     */
    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
 
        String email    = req.getParameter("email").trim();
        String password = req.getParameter("password");
 
        if (email.isEmpty() || password.isEmpty()) {
            req.setAttribute("error", "Email and password are required.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
 
        try {
            User user = userDAO.login(email, password);
            if (user != null) {
                // Create session and store user
                HttpSession session = req.getSession();
                session.setAttribute("loggedInUser", user);
                session.setMaxInactiveInterval(60 * 60); // 1 hour
                resp.sendRedirect(req.getContextPath() + "/index");
            } else {
                req.setAttribute("error", "Invalid email or password.");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            getServletContext().log("DB error during login", e);
            req.setAttribute("error", "A server error occurred. Please try again.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
