/*							
 * Copyright(C) 2023,  FPT University.							
 * Base Number Converter :							
 * Convert Number from a base to another base.								
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-23>       <2.0>          <Nguyen Hoang Manh>   <Convert number from given input base to given output base>							
 */
package basenumbersystem;

import java.util.Vector;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * The class is to manage Menu and User's Choice Add, print Menu and get input
 * from User
 *
 * @author Nguyen Hoang Manh
 */
public class Menu extends Vector<String> {

    /**
     * Constructor allow this class to be called
     */
    public Menu() {
        
    }

    /**
     * Add menu options to vector
     *
     * @param s is option's string. It is a <code>java.lang.String</code> object
     */
    void addMenuItem(String s) {
        this.add(s);
    }

    /**
     * Print out Menu that has been add from class BaseNumberSystem Get and
     * check valid available options that user chose
     *
     * @return an integer. It is a <code>java.lang.Integer</code> object
     */
    public int getInput() {
        Logger logger = Logger.getLogger(Menu.class.getName());

        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "-" + elementAt(i));
        }

        boolean cond = true;
        int input = 0;

        // loop until choose the valid choice that exist in the menu
        while (cond) {
            System.out.print("Select 1.." + this.size() + ": ");

            Scanner scn = new Scanner(System.in);

            try {
                input = scn.nextInt();

                if (input > 0 && input <= this.size()) {
                    //Return the base correspoding to the option that user chose
                    switch (input) {
                        case 1:
                            return 2;

                        case 2:
                            return 10;

                        case 3:
                            return 16;
                    }
                }
            } catch (InputMismatchException e) {
                logger.warning("INTEGER-type INPUT, please try again");
                continue;
            }
        }

        return input;
    }

}
