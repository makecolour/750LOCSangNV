/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Products management system> :				
 * <Program allow user manage employee information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-20>      <8.2>     <AnhTD>        <Write a program allow user to input and manage products information on screen.>				
 */
package management;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Product;
import entity.Storekeeper;
import java.time.LocalDate;

/**
 * The GetUserInput class provides methods for obtaining user input in various
 * formats such as strings, doubles, integers, and dates. It also includes
 * methods for validating input, checking for duplicate IDs, and ensuring the
 * uniqueness of storekeeper names. This class uses a Scanner object to interact
 * with the user and Logger for logging any errors or exceptions during input
 * collection.
 *
 * @author Tran Duc Anh
 */
public class GetUserInput {

    private static final Logger logger = Logger.getLogger(GetUserInput.class.getName());
    private static Scanner sc = new Scanner(System.in);

    /**
     * Get a string input from the user.
     *
     * @param msg The message to display to the user.
     * @param text The default text to display in the input field.
     * @return a string not empty.
     */
    public static String getString(String msg, String text) {
        do {
            System.out.print("Enter " + msg + ": ");
            try {
                text = sc.nextLine().trim();
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
     * Get a double input from the user within a specified range.
     *
     * @param msg The message to display to the user.
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return a double within the specified range.
     */
    public static double getDouble(String msg, double min, double max) {
        double i;

        do {
            System.out.print("Enter " + msg + ": ");
            try {
                i = Double.parseDouble(sc.nextLine().trim());
                if (i >= min && i <= max) {
                    return i;
                } else {
                    System.err.println("Out of range");
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);
    }

    /**
     * Get an integer input from the user within a specified range.
     *
     * @param msg The message to display to the user.
     * @param min The minimum allowed value.
     * @param max The maximum allowed value.
     * @return integer within the specified range.
     */
    public static int getInt(String msg, int min, int max) {
        int choice = 0;
        do {
            try {
                choice = Integer.parseInt(getString(msg, "").trim());
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
     * Prompts the user to enter a manufacturing date in the format
     * "YYYY-MM-DD," validates the input, and ensures that the date is not in
     * the future. Returns the valid manufacturing date as a LocalDate object.
     *
     * @param msg A descriptive message specifying the purpose of the date entry
     * (e.g., "Manufacturing Date").
     * @param date The user-provided date input as a string.
     * @return A LocalDate object representing the valid manufacturing date
     * entered by the user.
     */
    public static LocalDate getManufactureDate(String msg, String date) {
        do {
            try {
                date = getString(msg, date);
                if (LocalDate.parse(date).compareTo(LocalDate.now()) <= 0) {
                    return LocalDate.parse(date);
                } else {
                    System.err.println("Error " + msg);
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);
    }

    /**
     * Prompts the user to enter a date in the format "YYYY-MM-DD" for a
     * specified purpose, validates the input, and returns it as a LocalDate
     * object.
     *
     * @param msg A descriptive message specifying the purpose of the date entry
     * (e.g., "Expiry Date").
     * @param date The user-provided date input as a string.
     * @return A LocalDate object representing the valid date entered by the
     * user.
     */
    public static LocalDate getExpiryAndReceiptDate(String msg, String date) {
        do {
            try {
                date = getString(msg, date);
                if (LocalDate.parse(date).compareTo(LocalDate.now()) >= 0) {
                    return LocalDate.parse(date);
                } else {
                    System.err.println("Error " + msg);
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);
    }

    /**
     * Get a unique ID from the user for a product.
     *
     * @param msg The message to display to the user.
     * @param list The list of products to check for duplicate IDs.
     * @param situation The case to input Id
     * @return The user's input as a unique ID.
     */
    public static String getId(String msg, ArrayList list, int situation) {
        do {
            String id = null;
            try {
                id = getString(msg, id);
                if (vaildateDuplicateId(list, id, situation) == false && id.isEmpty() == false) {
                    return id.trim();
                }
            } catch (Exception e) {
                System.err.println("Error " + msg);
            }
        } while (true);
    }

    /**
     * Get a storekeeper 's name from the user.
     *
     * @param msg The message to display to the user.
     * @param list The list of storekeepers to check for existing names.
     * @return a storekeeper match user's input as name.
     */
    public static Storekeeper getStorekeeper(String msg, ArrayList<Storekeeper> list) {
        if (list.isEmpty()) {
            System.out.println("This list is empty");
        } else {
            for (Storekeeper storekeeper : list) {
                System.out.println(storekeeper);
            }
        }
        do {
            String name = null;
            String confirm = null;
            name = getString(msg, name);
            for (Storekeeper s : list) {
                if (name.equalsIgnoreCase(s.getName())) {
                    return s;
                }
            }
            System.err.println("Storekeeper name not existed in list\nDo you want to add this " + name + " to storekeeper list");
            confirm = confirmYesNo(confirm);
            if (confirm.equalsIgnoreCase("y")) {
                Storekeeper newStorekeeper = new Storekeeper(getId("storekeeper id for " + name, list, 1), name);
                list.add(newStorekeeper);
                System.err.println("This storekeeper has been added");
            }
        } while (true);
    }

    /**
     * Get a storekeeper 's name from the user and ensure it is unique.This
     * method support addProduct method
     *
     * @param name The default storekeeper 's name to display in the input
     * field.
     * @param list The list of storekeepers to check for duplicate names.
     * @return The user's input as a unique storekeeper 's name.
     */
    public static String getStorekeeperName(String name, ArrayList<Storekeeper> list) {
        do {
            int flag = 0;
            name = getString("storekeeper name", name);
            for (Storekeeper s : list) {
                if (name.equalsIgnoreCase(s.getName())) {
                    System.err.println("Storekeeper name existed");
                    flag = 1;
                }
            }
            if (flag == 0) {
                return name.trim();
            }
        } while (true);
    }

    /**
     * Prompts the user for a "Y" or "N" confirmation and keeps asking until a
     * valid response is received.
     *
     * @param confirm The user's initial confirmation input (can be null).
     * @return The validated confirmation response ("Y" or "N").
     */
    private static String confirmYesNo(String confirm) {
        do {
            confirm = getString("Y/N", confirm);
            if (confirm.equalsIgnoreCase("Y") || confirm.equalsIgnoreCase("N")) {
                return confirm;
            } else {
                System.err.println("Error");
            }
        } while (true);
    }

    /**
     * Validate if an input ID is unique among a list of products.
     *
     * @param list The list of products to check for duplicate IDs.
     * @param inputId The input ID to validate.
     * @param situation type of case
     * @return True if the input ID is unique, false if it already exists in the
     * list.
     */
    private static boolean vaildateDuplicateId(ArrayList list, String inputId, int situation) {
        ArrayList<Product> pList = list;
        ArrayList<Storekeeper> sList = list;
        if (situation == 1) {
            for (Storekeeper storekeeper : sList) {
                if (storekeeper.getId().equalsIgnoreCase(inputId)) {
                    System.err.println("Storekeeper id existed");
                    return true;
                }
            }
            return false;
        } else {
            for (Product product : pList) {
                if (product.getId().equalsIgnoreCase(inputId)) {
                    System.err.println("Product id existed");
                    return true;
                }
            }
            return false;
        }
    }

}
