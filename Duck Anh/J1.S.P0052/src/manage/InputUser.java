/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Geography management program> :				
 * <Create a Java console program to manage geography.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program to manage the geographic. >				
 */
package manage;

import entity.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The `InputUser` class provides methods for obtaining user input from the
 * console, performing input validation, and handling exceptions. It includes
 * methods for getting strings, floats, integers, and country-related inputs,
 * such as country names and codes.
 *
 * @author Trần Đức Anh
 */
public class InputUser {

    private static Scanner sc = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(InputUser.class.getName());

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
                //check empty string
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
     * Prompts the user to enter a floating-point number within a specified
     * range.
     *
     * @param msg The message to display as a prompt to the user.
     * @param min The minimum valid value.
     * @param max The maximum valid value.
     * @return A floating-point number within the specified range entered by the
     * user.
     */
    public static float getFloat(String msg, float min, float max) {
        float i = 0;
        //check user input string
        do {
            try {
                i = Float.parseFloat(getString(msg, ""));
                if (i >= min && i <= max) {
                    return i;
                } else {
                    System.err.println("Out of range");
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);//catch error if wrong input
            }
        } while (true);
    }

    /**
     * Prompts the user to enter an integer within a specified range.
     *
     * @param msg The message to display as a prompt to the user.
     * @param min The minimum valid value.
     * @param max The maximum valid value.
     * @return An integer within the specified range entered by the user.
     */
    public static int getInt(String msg, int min, int max) {
        int choice = 0;
        //check user input string
        do {
            try {
                choice = Integer.parseInt(getString(msg, ""));
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

    /**
     * Prompts the user to enter a country name and checks if it already exists
     * in a list.
     *
     * @param msg The message to display as a prompt to the user.
     * @param text The default text to be displayed in the input field.
     * @param list The list of countries to check for duplicates.
     * @return A unique country name entered by the user.
     */
    public static String getUniqueName(String msg, String text, ArrayList<EastAsiaCountries> list) {
        do {
            try {
                text = getString(msg, text);
                int flag = 0;
                for (EastAsiaCountries eastAsiaCountries : list) {
                    if (eastAsiaCountries.getCountryName().toLowerCase().equals(text.toLowerCase())) {
                        System.err.println("Country name existed");
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    return text;
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);
    }

    /**
     * Prompts the user to enter a country code and checks if it is unique and
     * not empty.
     *
     * @param msg The message to display as a prompt to the user.
     * @param list The list of countries to check for duplicate codes.
     * @return A unique non-empty country code entered by the user.
     */
    public static String getUniqueCode(String msg, ArrayList<EastAsiaCountries> list) {
        String code = null;
        do {
            try {
                code = getString(msg, "");
                //check if code is existed and not empty
                if (checkDuplicateCode(list, code) == false && code.isEmpty() == false) {
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
     * Checks if a given country code already exists in a list of countries.
     *
     * @param countryList The list of countries to check.
     * @param inputCode The country code to check for duplicates.
     * @return true if the code exists in the list; false otherwise.
     */
    private static boolean checkDuplicateCode(ArrayList<EastAsiaCountries> countryList, String inputCode) {
        //lood to check duplicated code
        for (EastAsiaCountries eastAsiaCountries : countryList) {
            if (inputCode.equalsIgnoreCase(eastAsiaCountries.getCountryCode())) {
                return true;
            }
        }
        return false;
    }
}
