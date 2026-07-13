package com.bo4loadouts.servlet;

import com.bo4loadouts.dao.UserDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet that handles user registration.
 * GET requests serve the register form.
 * POST requests validate input and create a new account.
 * @author Marko
 */
public class RegisterServlet extends HttpServlet {
    
    /**
     * Default constructor
     */
    public RegisterServlet() {
        
    }
    
    /**
     * Data Access Object used for user operations.
     */
    private static final UserDAO userdao = new UserDAO();
    
    /**
     * Serves the registration form page.
     * @param req the incoming HTTP request.
     * @param resp the outgoing HTTP response.
     * @throws ServletException if the request dispatcher fails.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }
    
    /**
     * Processes the registration form submission.
     * Validates that all fields are present, passwords match, and the
     * email and username are not already taken before creating the account.
     * @param req the incoming HTTP request containing parameters.
     * @param resp the outgoing HTTP response.
     * @throws ServletException if the request dispatcher fails.
     * @throws IOException if an I/O error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username").trim();
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirmPassword");
        
        // Basic validation.
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            req.setAttribute("error", "All fields are required.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        
        if (!password.equals(confirm)) {
            req.setAttribute("error", "Passwords do not match.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        
        if (password.length() < 8) {
            req.setAttribute("error", "Password must be at least 8 characters.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        
        try {
            boolean success = userdao.register(username, email, password);
            if (success) {
                req.setAttribute("success", "Account created! You can now login and create your loadouts.");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            } else {
                req.setAttribute("error", "Email or username is already taken.");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        } catch(SQLException e) {
            getServletContext().log("DB error during registration.", e);
            req.setAttribute("error", "A server error occured. Please try again.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
