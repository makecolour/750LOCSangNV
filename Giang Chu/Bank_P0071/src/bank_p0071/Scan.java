/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Employee management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package bank_p0071;

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
        int result =0 ;
        do {
            Scanner sc = new Scanner(System.in);
            try {
                String data = sc.nextLine();
                result = Integer.parseInt(data);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Enter an integer number again: ");
            }
        } while (!true);
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
        do {
            System.out.print(inform);
            Scanner sc = new Scanner(System.in);
            try {
                String data = sc.nextLine();
                result = Integer.parseInt(data);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Enter again: ");
            }
        } while (!true || result < start || result > end);
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
        boolean valid = true;
        do {
            System.out.print(inform);
            str = sc.nextLine();
            if (str.isEmpty()) {
                logger.warning("Please enter something: ");
                valid = false;
            }
            valid = true;
        } while (valid != true);
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
        double result =0 ;
        do {
            Scanner sc = new Scanner(System.in);
            try {
                String data = sc.nextLine();
                result = Double.parseDouble(data);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Enter an double number again: ");
            }
        } while (!true);
        return result;
    }
}
