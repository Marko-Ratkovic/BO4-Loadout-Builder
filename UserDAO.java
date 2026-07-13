package com.bo4loadouts.dao;

import com.bo4loadouts.model.User;
import com.bo4loadouts.util.DBConnection;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.*;

/**
 * Data Access Object for user account operations.
 * Handles registration, login validation, and user lookups
 * against the users table in the bo4_loadouts database.
 * @author Marko
 */
public class UserDAO {
    
    /**
     * Default constructor.
     */
    public UserDAO() {
        
    }
    
    /**
     * Registers a new user by inserting their details into the users table.
     * The password is hashed with BCrypt before storage.
     * @param username the desired username.
     * @param email the user's email address.
     * @param password the plain-text password to hash and store.
     * @return true if registration succeeded, false if the email or username already exists.
     * @throws SQLException if a database error occurs.
     */
    public boolean register(String username, String email, String password) throws SQLException {
        if (emailExists(email) || usernameExists(username)) {
            return false;
        }
        
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        String sql =  "INSERT INTO users (username, email, password_hash) VALUES (?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, hashed);
            ps.executeUpdate();
            return true;
        }
    }
    
    /**
     * Validates login credentials and returns the matching User if correct.
     * Also updates the last_login timestamp on successful login.
     * @param email the email address entered by the user.
     * @param password the plain-text password entered by the user.
     * @return the matching {@link User} object, or null if credentials are invalid.
     * @throws SQLException if a database error occurs.
     */
    public User login (String email, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("password_hash");
                    if (BCrypt.checkpw(password, storedHash)) {
                        User user = mapRow(rs);
                        updateLastLogin(user.getId());
                        return user;
                    }
                }
            }
        }
        return null;
    }
    
    /**
     * Checks whether an email address is already registered.
     * @param email the email address to check.
     * @return true if the email address exists in the database. 
     * @throws SQLException if a database error occurs.
     */
    public boolean emailExists(String email) throws SQLException {
        String sql = "SELECT id FROM users WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    
    /**
     * Checks whether a username is already taken.
     * @param username the username to check.
     * @return true if the username exists in the database.
     * @throws SQLException if a database error occurs.
     */
    public boolean usernameExists(String username) throws SQLException {
        String sql = "SELECT id FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    
    /**
     * Updates the last_login timestamp for a user to the current time.
     * @param userId the ID of the user to update.
     * @throws SQLException if a database error occurs.
     */
    private void updateLastLogin(int userId) throws SQLException {
        String sql = "UPDATE users SET last_login = NOW() WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.executeUpdate();
        }
    }
    
    /**
     * Maps a single ResultSet row to a User object.
     * @param rs the current row of the ResultSet.
     * @return a populated {@link User} object.
     * @throws SQLException if any column cannot be read.
     */
    private User mapRow(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPasswordHash(rs.getString("password_hash"));
        Timestamp created = rs.getTimestamp("created_at");
        user.setCreatedAt(created != null ? created.toString().substring(0, 10) : "");
        Timestamp last = rs.getTimestamp("last_login");
        user.setLastLogin(last != null ? last.toString().substring(0, 10) : "");
        return user;
    } 
}
