/*							
 * Copyright(C) 2023,  FPT University.							
 * Geographic Management							
 * Manage information of east asia country				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-30>       <1.0>          <La Dieu Minh>     <Manage information of east asia country List>							
 */
package Main;

import Operation.Menu;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * Get input from user is run from this class
 * 
 * @author admin
 */
public class Input {
    
    private final Scanner scanner = new Scanner(System.in);
    private final Logger logger = Logger.getLogger(Menu.class.getName());
    
    /**
     * Check string input and return if conditions is met
     * @return a string
     */
    public String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                logger.warning("The string is empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * Check double input and return if conditions is met
     * @return a double
     */
    public double checkInputDouble() {
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (NumberFormatException e) {
                logger.warning("Please input number double");
                System.out.print("Enter again: ");
            }
        }
    }
}
