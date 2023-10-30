/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Doctor management program> :				
 * <Create a Java console program to manage doctor.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program to manage information of Doctor.>				
 */
package manage;

import entity.Doctor;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * The `InputUser` class provides utility methods for validating user input
 and ensuring data integrity. It includes methods for getting and validating
 * strings and integers, as well as checking for duplicate codes. This class
 * also uses a logger for error reporting.
 *
 * @author Trần Đức Anh
 */
public class InputUser {

    private static Logger logger = Logger.getLogger(InputUser.class.getName());
    private static Scanner sc = new Scanner(System.in);

    /**
     * Gets a string input from the user and validates it for non-empty input.
     *
     * @param msg The message prompt for the input.
     * @param text The default text to be displayed in the input field.
     * @return A non-empty string entered by the user.
     */
    public static String getString(String msg, String text) {
        //loop until user input correct
        do {
            System.out.print("Enter " + msg + ": ");
            try {
                text = sc.nextLine().trim();
                //check if input is empty
                if (text.isEmpty() == false) {
                    return text.trim();
                } else {
                    System.err.println("Input can not be empty");
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);
    }

    /**
     * Gets an integer input from the user and validates it within a specified
     * range.
     *
     * @param msg The message prompt for the input.
     * @param min The minimum valid integer value.
     * @param max The maximum valid integer value.
     * @return An integer within the specified range entered by the user.
     */
    public static int getInt(String msg, int min, int max) {
        int choice = 0;
        //check user input string
        do {
            try {
                choice = Integer.parseInt(getString(msg, ""));
                //check if input in valcode range
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.err.println("Out of range");
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);
    }

    /**
     * Validates a code string to ensure it does not exist in a provided HashMap
     * and is not empty.
     *
     * @param msg The message prompt for the code input.
     * @param list The HashMap containing existing data to check for duplicates.
     * @return A unique and non-empty code entered by the user.
     */
    public static String getCode(String msg, HashMap list) {
        String code = null;
        do {
            try {
                code = getString(msg, "");
                //check if code is existed and not empty
                if (checkDuplicateId(list, code) == false && code.isEmpty() == false) {
                    return code.trim();
                } else if (code.isEmpty()) {
                    System.out.println("Data does not exist");
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);
    }

    /**
     * Checks for duplicate code in a HashMap of doctors.
     *
     * @param map The HashMap containing existing doctor data.
     * @param inputCode The code to be checked for duplication.
     * @return True if the code already exists in the HashMap, false otherwise.
     */
    private static boolean checkDuplicateId(HashMap<String, Doctor> map, String inputCode) {
        //lood to check duplicated code
        for (Map.Entry<String, Doctor> doctor : map.entrySet()) {
            if (inputCode.equalsIgnoreCase(doctor.getKey())) {
                System.err.println("Doctor code is duplicate");
                return true;
            }
        }
        return false;
    }

}
