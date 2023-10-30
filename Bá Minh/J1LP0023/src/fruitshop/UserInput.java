/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Fruit shop management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
*/
package fruitshop;

import java.util.Scanner;

/**
 * This class provides methods for inputting data
 * @author Dell
 */
public class UserInput {
    /**
     * Get an integer value from user input
     * 
     * @param mess The message ask user for inputting data
     * @return an integer value
     */
    public static int getInt(String mess) {
        System.out.print(mess);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    /**
     * Get an double value from user input
     * 
     * @param mess The message ask user for inputting data
     * @return an double value
     */
    public static double getDouble(String mess) {
        System.out.print(mess);
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
    
    /**
     * Get an String value from user input
     * 
     * @param mess The message ask user for inputting data
     * @return an String value
     */
    public static String getLine(String mess) {
        Scanner sc = new Scanner(System.in);
        String str;
        do {
            System.out.print(mess);
            str = sc.nextLine();
        } while(str.isBlank());
        return str.trim();
    }

}
