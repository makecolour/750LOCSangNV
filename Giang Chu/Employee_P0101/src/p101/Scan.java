/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Employee management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package p101;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class provides methods for inputting data
 *
 * @author Chu Hoang Giang
 */
public class Scan {

    private final Scanner sc = new Scanner(System.in);
    private final Logger logger = Logger.getLogger(Scan.class.getName());

    /**
     * Get an integer value from user input
     *
     * @param inform The message ask user for inputting data
     * @return an integer value
     */
    public int nextInt(String inform) {
        System.out.print(inform);
        String data = null;
        int result = 0 ;
        do {
            Scanner sc = new Scanner(System.in);
            try {
                data = sc.nextLine();
                result = Integer.parseInt(data);
                if (data.isEmpty()) {
                    System.out.println("There is nothing.");
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Enter an integer number again: ");
            }
        } while (!true || data.isEmpty());
        return result;
    }
    /**
     * get an int value from user input in range of start to end
     * @param start 
     * @param end
     * @param inform The message ask user for inputting data
     * @return an integer value
     */
    public int checkLimit(int start, int end, String inform) {
        int result =0 ;
        String data = null;
        do {
            System.out.print(inform);
            Scanner sc = new Scanner(System.in);
            try {
                data = sc.nextLine();
                result = Integer.parseInt(data);
            } catch (Exception e) {
                System.out.println(e);
                System.out.print("Enter again: ");
            }
        } while (!true || result < start || result > end || data.isEmpty());
        return result;
    }
    

    /**
     * Get an String value from user input
     *
     * @param inform The message ask user for inputting data
     * @return an String value
     */
    public String nextLine(String inform) {
        String str;
        do {
            System.out.print(inform);
            str = sc.nextLine();
            if (str.isEmpty()) {
                logger.warning("Please enter something: ");
            }
        } while (str.isEmpty());
        return str.trim();
    }

    /**
     * Get an double value from user input
     *
     * @param inform The message ask user for inputting data
     * @return an double value
     */

    public double nextDouble(String inform) {
        System.out.print(inform);
        String data = null;
        double result = 0 ;
        do {
            Scanner sc = new Scanner(System.in);
            try {
                data = sc.nextLine();
                result = Integer.parseInt(data);
                if (data.isEmpty()) {
                    System.out.println("There is nothing.");
                }
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Enter an integer number again: ");
            }
        } while (!true || data.isEmpty());
        return result;
    }
    /**
     * 
     * @param inform to print
     * @return boolean value
     */
    public boolean checkApprove(String inform) {
        System.out.println(inform);
        String data = "null";
        do {            
            data = sc.nextLine().toLowerCase();
            if (data.equalsIgnoreCase("y")) {
                return true;
            }
            else if (data.equalsIgnoreCase("n")) {
                return false;
            }
            else {
                System.out.println("Enter 'y' or 'n'");
            }
        } while (!data.equalsIgnoreCase("y") || data.equalsIgnoreCase("n"));
        return true;
    }
}
