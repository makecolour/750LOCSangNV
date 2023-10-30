/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Create a Java console program to manage a Fruit Shop (Product and Shopping).> :				
 * <program allow user manage fruit information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-30>      <8.2>     <AnhTD>        <Create a Java console program to manage a Fruit Shop (Product and Shopping).>				
 */
package management;

import entity.Fruit;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The `GetUserInput` class provides utility methods for obtaining and
 * validating user input from the console. It includes methods for fetching
 * strings, doubles, and integers with input validation. Additionally, this
 * class offers a method for checking the uniqueness of an ID within a list of
 * `Fruit` objects and handles input exceptions by logging them.
 *
 * Bugs: None known.
 *
 * @author Tran Duc Anh
 */
public class GetUserInput {

    private static Scanner sc = new Scanner(System.in);
    private static Logger logger = Logger.getLogger(GetUserInput.class.getName());

    /**
     * Prompts the user for a string input and ensures it is non-empty. If the
     * input is empty, an error message is displayed, and the user is prompted
     * again.
     *
     * @param msg The message to display as a prompt to the user.
     * @param text The user's input string.
     * @return A validated non-empty string input.
     */
    public static String getString(String msg, String text) {
        //loop until user input correct
        do {
            System.out.print(msg);
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
     * Prompts the user for a double input within the specified range
     * (inclusive). If the input is outside the range, an error message is
     * displayed, and the user is prompted again.
     *
     * @param msg The message to display as a prompt to the user.
     * @param min The minimum allowed value for the double input.
     * @param max The maximum allowed value for the double input.
     * @return A validated double input within the specified range.
     */
    public static double getDouble(String msg, double min, double max) {
        double i = 0;
        //check user input string
        do {
            try {
                i = Double.parseDouble(getString(msg, ""));
                if (i >= min && i <= max) {
                    return i;
                } else {
                    System.err.println("Out of range (" + min + "->" + max + ")");
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);//catch error if wrong input
            }
        } while (true);
    }

    /**
     * Prompts the user for an integer input within the specified range
     * (inclusive). If the input is outside the range, an error message is
     * displayed, and the user is prompted again.
     *
     * @param msg The message to display as a prompt to the user.
     * @param min The minimum allowed value for the integer input.
     * @param max The maximum allowed value for the integer input.
     * @return A validated integer input within the specified range.
     */
    public static int getInt(String msg, int min, int max) {
        int choice = 0;
        //check user input string until it valid
        do {
            try {
                choice = Integer.parseInt(getString(msg, ""));
                //check input range
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.err.println("Out of range(" + min + "->" + max + ")");
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);
    }

    /**
     * Prompts the user for an ID and checks for its uniqueness within a list of
     * Fruit objects. If the ID is empty or already exists in the list, an error
     * message is displayed, and the user is prompted again.
     *
     * @param msg The message to display as a prompt to the user.
     * @param list The list of Fruit objects used to check for duplicate IDs.
     * @return A validated and unique ID.
     */
    public static String getFruitName(String msg, ArrayList<Fruit> list) {
        String name = null;
        //loop until get valid id
        do {
            try {
                name = getString(msg, "");
                //check if id is duplicated through method checkDuplicated
                if (checkDuplicateName(list, name) == false && name.isEmpty() == false) {
                    return name.trim();
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);
    }

    /**
     * Checks whether a given name already exists in a list of Fruit objects.
     *
     * @param list The list of Fruit objects to check for duplicate name.
     * @param inputName The name to check for duplication.
     * @return `true` if the ID already exists in the list, otherwise `false`.
     */
    private static boolean checkDuplicateName(ArrayList<Fruit> list, String inputName) {
        for (Fruit o : list) {
            //check if id is duplicated
            if (inputName.equalsIgnoreCase(o.getFruitName())) {
                System.err.println("Name already existed");
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether a given ID already exists in a list of Fruit objects.
     *
     * @param list The list of Fruit objects to check for duplicate IDs.
     * @param msg The message to print out
     * @return string id if the ID not already exists in the list.
     */
    public static String getId(String msg, ArrayList<Fruit> list) {
        do {
            String id = getString(msg, "");
            if (checkDuplicatedId(list, id) == true) {
                return id;
            }
        } while (true);
    }

    /**
     * Checks whether a given ID already exists in a list of Fruit objects.
     *
     * @param list The list of Fruit objects to check for duplicate IDs.
     * @param id The ID to check for duplication.
     * @return `true` if the ID already exists in the list, otherwise `false`.
     */
    private static boolean checkDuplicatedId(ArrayList<Fruit> list, String id) {
        for (Fruit fruit : list) {
            if (fruit.getFruitId().equalsIgnoreCase(id)) {
                System.err.println("Id existed");
                return false;
            }
        }
        return true;
    }

}
