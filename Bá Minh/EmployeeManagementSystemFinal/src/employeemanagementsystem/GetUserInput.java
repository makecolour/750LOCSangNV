/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Employee management system> :				
 * <program allow user manage employee information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <MinhNBD>        <Write a program allow user manage employee information on screen.>				
 */
package employeemanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class contains method to allow user to input information and check user
 * input
 *
 * @author Nguyen Ba Duc Minh
 */
public class GetUserInput {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user to input a string value, repeatedly validating and
     * prompting until a non-empty input is provided.
     *
     * @param msg The message to display when prompting the user for input.
     * @return A non-empty string entered by the user.
     */
    public static String getString(String msg) {
        String text;
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
                MyLog.getLogger().warning(String.format("Error " + msg + ", " + e.toString()));
            }
        } while (true);
    }

    /**
     * Prompts the user to input a double within a specified range, repeatedly
     * validating and prompting until a valid input is provided.
     *
     * @param msg The message to display when prompting the user for input.
     * @param min The minimum allowed value for the input (inclusive).
     * @param max The maximum allowed value for the input (inclusive).
     * @return A double value within the specified range [min, max] entered by
     * the user.
     */
    public static double getDouble(String msg, double min, double max) {
        double i = 0;
        //check user input string
        do {
            System.out.print("Enter " + msg + ": ");
            try {
                //user input double number
                i = Double.parseDouble(sc.nextLine().trim());
                if (i >= min && i <= max) {
                    return i;
                } else {
                    System.err.println("Out of range " + min + "->>" + max);
                }
            } catch (Exception e) {
                MyLog.getLogger().warning(String.format("Error " + msg + ", " + e.toString()));
            }
        } while (true);
    }

    /**
     * Prompts the user to input an integer within a specified range, repeatedly
     * validating and prompting until a valid input is provided.
     *
     * @param msg The message to display when prompting the user for input.
     * @param min The minimum allowed value for the input (inclusive).
     * @param max The maximum allowed value for the input (inclusive).
     * @return An integer value within the specified range [min, max] entered by
     * the user.
     */
    public static int getInt(String msg, int min, int max) {
        int choice;
        //check user input string
        do {
            try {
                System.out.print("Enter " + msg + ": ");
                choice = Integer.parseInt(sc.nextLine().trim());
                //check if input in valid range
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    MyLog.getLogger().warning("Out of range");
                }
            } catch (Exception e) {
                MyLog.getLogger().warning(String.format("Error " + msg + ", " + e.toString()));
            }
        } while (true);
    }

    /**
     * Check validate month of date of birth. String date of birth match valid
     * format date will be returned
     *
     * @param msg string represent
     * @return date of employee
     */
    public static String getDate(String msg) {
        String date;
        do {
            try {
                date = getString(msg + " with format (yyyy-mm-dd)");
                //check valid date form and check valid day,month,year
                if (date.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$") && isValidDate(date)) {
                    return utilizeDate(date.trim());
                } else {
                    System.err.println("Error " + msg);
                }
            } catch (Exception e) {
                MyLog.getLogger().warning(String.format("Error " + msg + ", " + e.toString()));
            }
        } while (true);
    }

    /**
     * Check validate month of date of birth. String date of birth match valid
     * format date along with month condition in if clause will be returned
     *
     * @param date of employee that needed to be checked.
     * @return true or false
     */
    private static boolean isValidDate(String date) {
        String[] dateAttribute = date.split("-");
        int year = Integer.parseInt(dateAttribute[0]);
        int month = Integer.parseInt(dateAttribute[1]);
        int day = Integer.parseInt(dateAttribute[2]);
        //check valid month
        if (isLeapYear(year)) {
            if ((month == 2) && (day >= 1 && day <= 29)) {
                return true;
            } else if (((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day >= 1 && day <= 31))
                    || ((month == 4 || month == 6 || month == 9 || month == 11) && (day >= 1 && day <= 30))) {
                return true;
            }
        } else if (!isLeapYear(year)) {
            if (((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day >= 1 && day <= 31))
                    || ((month == 4 || month == 6 || month == 9 || month == 11) && (day >= 1 && day <= 30))) {
                return true;
            } else if ((month == 2) && (day >= 1 && day <= 28)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if user's input year is leap year
     *
     * @param year the year on date of employee.
     * @return true or false depend on year is leap year or not
     */
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    /**
     * Check user input id string if is duplicated in parameter list and loop
     * until it satisfy condition
     *
     * @param list employee. It is a <code>java.util.ArrayList</code>
     * @param msg represent string
     * @return string id with no space if satisfy condition
     */
    public static String getId(String msg, ArrayList<Employee> list) {
        String id;
        //loop until get valid id
        do {
            try {
                id = getString(msg);
                //check if id is duplicated through method checkDuplicated
                if (checkDuplicateId(list, id) == false && id.isEmpty() == false) {
                    return id.trim();
                }
            } catch (Exception e) {
                MyLog.getLogger().warning(String.format("Error " + msg + ", " + e.toString()));
            }
        } while (true);
    }

    /**
     * Check user input id string if is duplicated in parameter list and loop
     * until it satisfy condition
     *
     * @param inputId the id input from user.
     * @param list of employee. It is a <code>java.util.ArrayList</code>
     * @return true or false.
     */
    private static boolean checkDuplicateId(ArrayList<Employee> list, String inputId) {
        for (Employee o : list) {
            //check if id is duplicated
            if (inputId.equalsIgnoreCase(o.getId())) {
                System.err.println("Id already existed");
                return true;
            }
        }
        return false;
    }

    /**
     * Validate string phone.Loop until parameter phone match phone format in if
     * condition This method use <code>java.util.logging.Logger</code> to catch
     * and print out error on console
     *
     * @param msg string represent phone.
     * @return phone of <code>Employee</code> objects.
     */
    public static String getPhone(String msg) {
        String phone;
        do {
            phone = getString("phone with format(xxxx xxx xxx)");
            try {
                //check phone format
                if (phone.matches("^([0-9]{3}|([0-9]{4}\\s[0-9]{3}\\s[0-9]{3}))$")) {
                    return phone.trim();
                } else {
                    MyLog.getLogger().warning(String.format("Error " + msg));
                }
            } catch (Exception e) {
                MyLog.getLogger().warning(String.format("Error " + msg + ", " + e.toString()));
            }
        } while (true);
    }

    /**
     * Validate string email.Loop until this parameter email match email format
     *
     * @param msg string represent.
     * @return an valid email.
     */
    public static String getEmail(String msg) {
        String email;
        do {
            email = getString("Email");
            try {
                //check email format
                if (email.matches("^[a-zA-Z0-9]+@(\\S+)$")) {
                    return email.trim();
                } else {
                    MyLog.getLogger().warning(String.format("Error " + msg));
                }
            } catch (Exception e) {
                MyLog.getLogger().warning(String.format("Error " + msg + ", " + e.toString()));
            }
        } while (true);
    }

    /**
     * Validate string sex method.Loop until parameter sex match M or FM ignore
     * case
     *
     * @param msg string represent.
     * @return sex for Employee objects.
     */
    public static String getSex(String msg) {
        String sex;
        do {
            System.out.println("Choose " + msg + "(Male: M|Female:FM)");
            try {
                sex = getString(msg);
                if (sex.equalsIgnoreCase("M") || sex.equalsIgnoreCase("fm")) {
                    return sex.trim();
                } else {
                    MyLog.getLogger().warning(String.format("Invalid " + msg));
                }
            } catch (Exception e) {
                MyLog.getLogger().warning(String.format("Error " + msg + ", " + e.toString()));
            }
        } while (true);
    }

    /**
     * Formats a date string to ensure it follows the "YYYY-MM-DD" format. Adds
     * leading zeros to month and day if necessary.
     *
     * @param date The input date string in the format "YYYY-MM-DD".
     * @return A formatted date string in the "YYYY-MM-DD" format.
     */
    private static String utilizeDate(String date) {
        String[] dateAttribute = date.split("-");
        String finalDate;
        int year = Integer.parseInt(dateAttribute[0]);
        int month = Integer.parseInt(dateAttribute[1]);
        int day = Integer.parseInt(dateAttribute[2]);
        String finalMonth;
        String finalDay;
        if (month < 10) {
            finalMonth = "0" + String.valueOf(month);
        } else {
            finalMonth = String.valueOf(month);
        }
        if (day < 10) {
            finalDay = "0" + String.valueOf(day);
        } else {
            finalDay = String.valueOf(day);
        }
        finalDate = String.valueOf(year) + "-" + finalMonth + "-" + finalDay;
        return finalDate;
    }
}
