/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Doctor management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0                           First implemention
 */
package doctormanagementsystem;

import java.util.Scanner;

/**
 * This class contains method for user to input value
 *
 * @author 
 */
public class UserInput {

    /**
     * Input a String
     *
     * @param mess ask user to input
     * @return a String
     */
    public static String getString(String mess) {
        Scanner sc = new Scanner(System.in);
        String str;
        do {
            System.out.print(mess);
            str = sc.nextLine();
        } while (str.isBlank());
        return str.trim();
    }

    /**
     * Input an Integer
     *
     * @param mess ask user to in put value
     * @return an Integer
     */
    public static int getInt(String mess) {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(getString(mess));
                return number;
            } catch (Exception e) {
                MyLog.getLogger().warning(String.format("You must input a integer value!" + ", " + e.toString()));
            }

        }
    }
}
