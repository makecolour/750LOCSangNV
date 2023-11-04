/*
 * Copyright(C) 2005,  <FPTU>.
 * <0023> :
 *  <Fruit Shop Management System>
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * <26/10/2023>                <1>              <la Minh>                       <base>
 */
package Manage;

import java.util.Scanner;
import java.util.ArrayList;

import Display.ErrorLog;
import Entity.*;

/**
 * Main input for program to check from int to string and even validate data
 *
 * @author La Minh
 */
public class Input {
    
    private final Scanner sc = new Scanner(System.in);
    private final String className = Input.class.getName();
    private final ErrorLog log = new ErrorLog();
    
    /**
     * check the limit of the logic
     * @param min value
     * @param max value
     * @return int
     */
    public int checkLimit(int min, int max) {
        //Todo - check limit logic
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                log.Log(className, "Re-input");
            }
        }
    }
    
    /**
     * input and return an int value
     * @param msg the display message
     * @return the int
     */
    public int checkInt(String msg){
        System.out.print(msg);
        // check int
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                log.Log(className,"Please input number integer");
                System.out.print("Enter again: ");
            }
        }
    }
    
    /**
     * input and return string
     * @param msg displayed message
     * @return the string
     */
    public String checkString(String msg){
        System.out.print(msg);
        //Todo check string logic
        while (true) {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                log.Log(className,"Input is empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
    
    /**
     * check if user want to choose y/n
     * @return t/f dependant on user
     */
    public boolean checkYN(){
        //check YN logic
        while (true) {
            String result = checkString("Please enter Y/N: ");
            //return true if user input y/Y
            try {
                if (result.equalsIgnoreCase("Y")) {
                    return true;
                }
                //return false if user input n/N
                if (result.equalsIgnoreCase("N")) {
                    return false;
                }
            } catch (Exception e) {
                log.Log(className, "Please input Y/N.");
                System.out.print("Enter again: ");
            }
        }
    }
    
    /**
     * check if the order have existing item or nah
     * @param oT the order table
     * @param id the fruit id
     * @return t/f dependant on the logic
     */
    public boolean exisitingItem(ArrayList<Order> oT, int id){
        // check if item exist
        for (Order o : oT){
            if(o.getFruitId() == id){
                return false;
            }
        }
        return true;
    }
}
