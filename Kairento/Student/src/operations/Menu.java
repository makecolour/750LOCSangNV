/*							
 * Copyright(C) 2023,  FPT University.							
 * Student Management							
 * Manage information of students					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage information of students using List>							
 */
package operations;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * The class is to manage Menu and User's Choice Add, print Menu and get input
 * from User
 *
 * @author Nguyen Hoang Manh
 */
public class Menu extends Vector<String> {

    private static final Logger logger = Logger.getLogger(Menu.class.getName());

    public Menu() {
        super();
    }

    /**
     * Add options to the menu
     *
     * @param s options name.
     */
    void addMenu(String s) {
        this.add(s);
    }

    /**
     * Print out Menu that has been add from class StudentManagment Get and
     * check valid available options that user chose
     *
     * @return an integer. It is a <code>java.lang.Integer</code> object
     */
    public int getUserChoice() {
        for (int i = 0; i < this.size(); i++) {
            System.out.print((i + 1) + "-" + elementAt(i) + "\n");
        }

        boolean cond = true;
        int input = 0;

        while (cond) {
            System.out.print("Select 1.." + this.size() + ": ");
            Scanner scn = new Scanner(System.in);
            try {
                input = scn.nextInt();

                if ((input > 0 && input <= this.size() && input == (int) input)) {
                    return input;
                }
            } catch (InputMismatchException e) {
                logger.warning("INTEGER-type INPUT, please try again");
                continue;
            }
        }

        return 0;
    }

    /**
     * Get a string from user and scan for empty string
     *
     * @return a string. Is is a <code>java.lang.String</code> object
     */
    public String getValidString() {
        Scanner scn = new Scanner(System.in);
        boolean cond = true;
        String input = "";

        while (cond) {
            try {
                input = scn.nextLine();
                if (input.length() > 0) {
                    return input;
                }
            } catch (InputMismatchException e) {
                logger.warning("Please input a string");
                continue;
            }
        }

        return input;
    }

    /**
     * Get an integer from user, only allow positive integer
     *
     * @return an integer. Is is a <code>java.lang.Integer</code> object
     */
    public int getValidInteger() {
        boolean cond = true;
        int input = 0;

        while (cond) {
            Scanner scn = new Scanner(System.in);
            try {
                input = scn.nextInt();
                if ((input > 0 && input == (int) input)) {
                    return input;
                }
            } catch (InputMismatchException e) {
                logger.warning("Please input a positive integer");
                continue;
            }
        }

        return input;
    }

}
