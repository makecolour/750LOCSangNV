/*							
 * Copyright(C) 2023,  FPT University.							
 * Matrices Caculation							
 * Add, substract and mutiply two matrices				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Add, substract and mutiply two matrices>							
 */
package program;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * The class is to manage Menu and User's Choice. Add, print Menu and get input
 * from User.
 *
 * @author Nguyen Hoang Manh
 */
public class Menu extends Vector<String> {

    private static final Logger logger = Logger.getLogger(Menu.class.getName());

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
    public void addMenuItem(String s) {
        this.add(s);
    }

    /**
     * Print out Menu that has been add from class GeographicManagment Get and
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

}
