/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <User management system.> :				
 * <Create a Java console program to manage User.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-10-09>      <8.2>     <AnhTD>        <Write a program to manage information of User.>				
 */
package manage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.User;

/**
 * The InputUser class provides methods for user input validation and retrieval.
 *
 * @author Trần Đức Anh
 */
public class InputUser {

    private static final Scanner sc = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(InputUser.class.getName());

    /**
     * Get a valid username input from the user.
     *
     * @param list The ArrayList of User objects to check for username
     * duplicates.
     * @param msg The message to display to the user for input.
     * @param text A temporary string variable for input.
     * @param i case check
     * @return A valid username input.
     */
    public static String getUsername(ArrayList<User> list, String msg, String text, int i) {

        //loop until user input correct
        do {
            System.out.print("Enter " + msg + ": ");
            try {
                text = sc.nextLine().trim();
                //check empty string
                if (text.isEmpty()) {
                    System.err.println("Input can not be empty");
                } else if (text.length() < 5) {
                    System.err.println("You must enter least at 5 character, and no space!");
                } else if (text.matches("^[a-zA-Z0-9]{5,}$") == false) {
                    System.err.println("Invalid username");
                } else if (i == 1) {
                    if (checkDuplicatedName(list, text) == false) {
                        System.err.println("User name existed");
                    } else {
                        return text.trim();
                    }
                } else if (i != 1) {
                    if (checkDuplicatedName(list, text) == true) {
                        System.err.println("Username not found");
                    } else {
                        return text.trim();
                    }
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);

    }

    /**
     * Get a valid password input from the user.
     *
     * @param list The ArrayList of User objects to check for password
     * duplicates.
     * @param msg The message to display to the user for input.
     * @param text A temporary string variable for input.
     * @param i case check
     * @return A valid password input.
     */
    public static String getPassword(ArrayList<User> list, String msg, String text, int i) {

        //loop until user input correct
        do {
            System.out.print("Enter " + msg + ": ");
            try {
                text = sc.nextLine().trim();
                //check empty string
                if (text.isEmpty()) {
                    System.err.println("Input can not be empty");
                } else if (text.length() < 6) {
                    System.err.println("You must enter least at 6 character, and no space!");
                } else if (text.matches("^[a-zA-Z0-9]{6,}$") == false) {
                    System.err.println("Invalid password");
                } else if (i == 1) {
                    return text.trim();
                } else if (i != 1) {
                    if (checkDuplicatedPassword(list, text) == true) {
                        System.err.println("Incorrect password");
                    } else {
                        return text.trim();
                    }
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);

    }

    /**
     * Check for duplicated usernames in the user list.
     *
     * @param list The ArrayList of User objects to check against.
     * @param text The username to check for duplicates.
     * @return True if the username is not found in the list (no duplicates),
     * false otherwise.
     */
    private static boolean checkDuplicatedName(ArrayList<User> list, String text) {
        for (User user : list) {
            if (user.getUsername().toLowerCase().equals(text.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check for duplicated passwords in the user list.
     *
     * @param list The ArrayList of User objects to check against.
     * @param text The password to check for duplicates.
     * @return True if the password is not found in the list (no duplicates),
     * false otherwise.
     */
    private static boolean checkDuplicatedPassword(ArrayList<User> list, String text) {
        for (User user : list) {
            if (user.getPassword().equals(text)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get an integer input from the user within a specified range.
     *
     * @param msg The message to display to the user for input.
     * @param min The minimum value allowed for input.
     * @param max The maximum value allowed for input.
     * @return A valid integer input within the specified range.
     */
    public static int getInt(String msg, int min, int max) {
        int choice = 0;
        //check user input string
        do {
            System.out.print(">Choose: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                //check if input in valid range
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.err.println("Out of range");
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg);
            }
        } while (true);
    }

}
