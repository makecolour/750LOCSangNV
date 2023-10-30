/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Geographic management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
 */
package managegeographic;

import java.util.Scanner;

/**
 * This class contains methods for user input data
 *
 * @author Nguyen Ba Duc Minh
 */
public class UserInput {

    /**
     * Input a String value
     *
     * @param mess The message ask user for inputting data
     * @return String value
     */
    public static String getLine(String mess) {
        Scanner sc = new Scanner(System.in);
        String str;
        do {
            System.out.print(mess);
            str = sc.nextLine();
        } while (str.isBlank());
        return str.trim();
    }

    /**
     * Input a float value
     *
     * @param mess The message ask user for inputting data
     * @return float value
     */
    public static float getFloat(String mess) {
        while (true) {
            try {
                float number = Float.parseFloat(getLine(mess));
                return number;
            } catch (Exception e) {
                MyLog.getLogger().warning(String.format("You must input a float value!" + ", " + e.toString()));
            }
        }
    }
}
