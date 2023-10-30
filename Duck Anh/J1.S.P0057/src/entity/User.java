/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <User management system.> :				
 * <Create a Java console program to manage User.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-10-09>      <8.2>     <AnhTD>        <Write a program to manage information of User.>				
 */
package entity;

/**
 * The User class represents a user entity in the system. It stores the
 * user's username and password.
 *
 * @author Trần Đức Anh
 */
public class User {

    private String password;
    private String username;

    /**
     * Default constructor for creating an empty User object.
     */
    public User() {
    }

    /**
     * Constructor for creating a User object with a specified username and
     * password.
     *
     * @param username The username for the user.
     * @param password The password for the user.
     */
    public User(String username, String password) {
        this.password = password;
        this.username = username;
    }

    /**
     * Retrieves the password associated with this user.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for this user.
     *
     * @param password The new password for the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retrieves the username associated with this user.
     *
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for this user.
     *
     * @param username The new username for the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns a string representation of the User object.
     *
     * @return A string containing the username and password of the user.
     */
    @Override
    public String toString() {
        return username + " " + password;
    }

}
