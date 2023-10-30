/*							
 * Copyright(C) 2023,  FPT University.							
 * Task Management							
 * Manage information of taks					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage information of taks using List>							
 */
package operations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * The class is to check input for everything that the user type in
 *
 * @author Nguyen Hoang Manh
 */
public class Validation {

    private static Scanner scanner = new Scanner(System.in);
    private final static Logger logger = Logger.getLogger(Validation.class.getName());

    /**
     * Check integer input from user within min and max value
     *
     * @param mess message to print to screen. It is a
     * <code>java.lang.String</code> object
     * @param min min value. It is a <code>java.lang.Integer</code> object
     * @param max max value. It is a <code>java.lang.Integer</code> object
     * @return an integer after all conditions are met. It is a
     * <code>java.lang.Integer</code> object
     */
    public int inputInt(String mess, int min, int max) {
        while (true) {
            System.out.print(mess);
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                //check range of number
                if (number < min || number > max) {
                    logger.warning("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (NumberFormatException e) {
                logger.warning("Please input an integer number");
            }
        }
    }

    /**
     * Check double input from user within min and max value. It is a
     * <code>java.lang.Double</code> object
     *
     * @param mess message to print to screen. It is a
     * <code>java.lang.String</code> object
     * @param min min value. It is a <code>java.lang.Double</code> object
     * @param max max value. It is a <code>java.lang.Double</code> object
     * @return a double after conditions are met. It is a
     * <code>java.lang.Double</code> object
     */
    public double inputDouble(String mess, double min, double max) {

        while (true) {
            System.out.print(mess);
            String input = scanner.nextLine();
            try {
                double number = Double.parseDouble(input);
                if (number % 0.5 != 0) {
                    logger.warning("Please input .5 or integer number");
                    continue;
                }
                if (number < min || number > max) {
                    logger.warning("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                logger.warning("Please input an double number: ");
            }
        }
    }

    /**
     * Check string that user input
     *
     * @param mess message to print to screen. It is a
     * <code>java.lang.String</code> object
     * @param regex string regex. It is a <code>java.lang.String</code> object
     * @return a string if met the regex. It is a <code>java.lang.String</code>
     * object
     */
    public String inputString(String mess, String regex) {
        System.out.print(mess);
        while (true) {
            String input = scanner.nextLine();
            if (!input.matches(regex)) {
                logger.warning("Please input match regex: " + regex);
                continue;
            }
            if (input.trim().isEmpty()) {
                logger.warning("Please input a non-empty string!");
                continue;
            }
            return input;
        }
    }

    /**
     * Check date in the right format
     *
     * @param mess message to print to screen. It is a
     * <code>java.lang.String</code> object
     * @return input date in the right format. It is a
     * <code>java.lang.String</code> object
     */
    public String inputDate(String mess) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //set lenient to false so the date format strictly match my own format
        dateFormat.setLenient(false);

        while (true) {
            System.out.print(mess);
            String input = scanner.nextLine();
            try {
                Date date = dateFormat.parse(input);
                Date curDate = Calendar.getInstance().getTime();
                if (curDate.compareTo(date) < 0) {
                    logger.warning("Please input date that before current date!");
                    continue;
                }
                dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                return dateFormat.format(date);
            } catch (Exception e) {
                logger.warning("Please input valid date (dd-MM-yyyy)!");
            }
        }
    }
    
    /**
     * Check input for Yes or No
     *
     * @return true if user choose Yes, false otherwise. It is a
     * <code>java.lang.Boolean</code> object
     */
    public static boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            logger.warning("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    
     /**
     * Check user input for string
     *
     * @return a string if the condition is met. It is a
     * <code>java.lang.String</code> object
     */
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                logger.warning("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
}
