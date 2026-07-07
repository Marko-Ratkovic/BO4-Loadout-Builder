package com.bo4loadouts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for establishing a connection to the bo4_loadouts MySQL database.
 * Uses the MySQL Connector/J JDBC driver with XAMPP default credentials.
 * 
 * @author Marko
 */
public class DBConnection {
    
    /**
     * JDBC connection URL pointing to the bo4_loadouts database on localhost.
     * SSL is disabled and the server timezone is set to UTC for compatibility.
     */
    private static final String URL = "jdbc:mysql://localhost:3306/bo4_loadouts?useSSL=false&serverTimezone=UTC";
    
    /**
     * Database username. Defaults to the XAMPP root user.
     */
    private static final String USER = "root";
 
    /**
     * Database password. Empty by default for XAMPP local development.
     * Change this if a password has been set on the root account.
     */
    private static final String PASSWORD = "";
 
    /**
     * Opens and returns a new connection to the bo4_loadouts database.
     * Loads the MySQL JDBC driver class before connecting.
     *
     * @return a live {@link Connection} to the database.
     * @throws SQLException if the driver is not found or the connection fails.
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC driver not found. Add mysql-connector-j to your classpath.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
