/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Matrices calculation
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
 */
package calculatingmatrices;

import java.util.Scanner;

/**
 * This class provides methods for inputting data
 *
 * @author Nguyen Ba Duc Minh
 */
public class UserInput {

    /**
     * Get user input for rows and columns
     *
     * @param mess The message ask user for inputting data
     * @param warn The warning if user input is invalid
     * @return an integer
     */
    public static int getInt(String mess, String warn) {
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            try {
                do {
                    System.out.print(mess);
                    number = Integer.parseInt(sc.nextLine());
                } while (number <= 0);
                return number;
            } catch (Exception e) {
                MyLog.getLogger().warning(String.format(warn + ", " + e.toString()));
            }
        }
    }

    /**
     * Get user input for matrix elements
     *
     * @param mess The message ask user for inputting data
     * @param warn The warning if user input is invalid
     * @return an double
     */
    public static double getDouble(String mess, String warn) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(mess);
                double number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (Exception e) {
                MyLog.getLogger().warning(String.format(warn + ", " + e.toString()));
            }
        }
    }
}
