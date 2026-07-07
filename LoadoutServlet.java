package com.bo4loadouts.servlet;

import com.bo4loadouts.dao.LoadoutDAO;
import com.bo4loadouts.model.Loadout;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet that handles HTTP GET requests for the homepage.
 * Fetches featured loadouts from the database via {@link LoadoutDAO}
 * and forwards the data to index.jsp for rendering.
 * Mapped to "/" and "/index" so the homepage always hits this servlet.
 * 
 * @author Marko
 */
public class LoadoutServlet extends HttpServlet {
    
    /**
     * Default Constructor
     */
    public LoadoutServlet() {
        
    }
    
    /**
     * Data access object used to retrieve loadout data from the database.
     */
    private static final LoadoutDAO dao = new LoadoutDAO();
    
    /**
     * Handles HTTP GET requests for the homepage.
     * Retrieves all featured public loadouts and sets them as a request
     * attribute before forwarding to index.jsp.
     * If the database query fails, an empty list and an error message
     * are passed to the JSP so the page still renders.
     * 
     * @param req the incoming HTTP request.
     * @param resp the outgoing HTTP response.
     * @throws ServletException if the request dispatcher fails.
     * @throws IOException if an I/O error occurs during forwarding.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("DEBUG: doGet called, fetching loadouts...");
        try {
            List<Loadout> featured = dao.getFeaturedLoadouts();
            System.out.println("DEBUG: loadouts count = " + featured.size());
            req.setAttribute("featuredLoadouts", featured);
        } catch(SQLException ex) {
            // Log the error and pass an empty list so the page still renders.
            getServletContext().log("DB error loading featured loadouts", ex);
            req.setAttribute("featuredLoadouts", java.util.Collections.emptyList());
            req.setAttribute("dbError", "Could not load loadouts: " + ex.getMessage());
        }
        
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
