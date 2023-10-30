/*							
 * Copyright(C) 2023,  FPT University.							
 * Geographic Management							
 * Manage information of east asia country				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-30>       <1.0>          <La Dieu Minh>     <Manage information of east asia country List>							
 */
package Operation;

import java.util.Vector;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * The class is to manage Menu and User's Choice.
 * Add, print Menu
 *
 * @author La Dieu Minh
 */
public class Menu extends Vector<String> {
    
    private static final Logger logger = Logger.getLogger(Menu.class.getName());

    /**
     * Constructor allow this class to be called
     */
    public Menu() {
        
    }

    /**
     * Print out Menu that has been add from class GeographicManagment Get and
     * check valid available options that user chose
     *
     * @return an integer
     */
    public int getUserChoice() {
        for (int i = 0; i < this.size(); i++) {
            System.out.print((i + 1) + "-" + elementAt(i) +"\n");
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
