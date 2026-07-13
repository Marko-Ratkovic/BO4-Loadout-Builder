package com.bo4loadouts.model;

/**
 * Represents a registered user of the BO4 Loadouts website.
 * Maps to the users table in the bo4_loadouts database.
 * @author Marko
 */
public class User {
    
    /**
     * Default constructor.
     */
    public User() {
        
    }
    
    /**
     * Unique identifier for the user, maps to users.id
     */
    private int id;
    
    /**
     * The user's chosen display name.
     */
    private String username;
    
    /**
     * The user's email address used for login.
     */
    private String email;
    
    /**
     * BCrypt hashed password, never stored in plain text.
     */
    private String passwordHash;
    
    /**
     * Timestamp of when the account was created.
     */
    private String createdAt;
    
    /**
     * Timestamp of the user's most recent login. 
     */
    private String lastLogin;
    
    /**
     * Gets the unique identifier for this user.
     * @return the user ID from the database as an int. 
     */
    public int getId() {
        return id;
    }
    
    /**
     * Sets the unique identifier for this user.
     * @param id the user ID from the database.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Gets the username of this user.
     * @return the user's display name.
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Sets the username of this user.
     * @param username the user's display name.
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Gets the email address of this user.
     * @return the user's email address.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the email address of this user.
     * @param email the user's email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Gets the BCrypt hashed password of this user.
     * @return the hashed password string.
     */
    public String getPasswordHash() {
        return passwordHash;
    }
    
    /**
     * Sets the BCrypt hashed password of this user.
     * @param passwordHash the hashed password string.
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    /**
     * Gets the account creation timestamp. 
     * @return the date the account was created.
     */
    public String getCreatedAt() {
        return createdAt;
    }
    
    /**
     * Sets the account creation timestamp.
     * @param createdAt the date the account was created.
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    /**
     * Gets the last login timestamp.
     * @return the date of the user's most recent login.
     */
    public String getLastLogin() {
        return lastLogin;
    }
    
    /**
     * Sets the last login timestamp.
     * @param lastLogin the date of the user's most recent login.
     */
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
}
