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

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class is for end user/tester to use the program without the needs to look
 * at method details This class allow user to input a base and a number in that
 * base Then user input another base, this is for output which is the number
 * that the user input before will get converted to this base.
 * <p>
 * Note: This class also user to add menu option if needed, but user must also
 * writing a function for that options in BaseNumberConverter Class
 *
 * @author Nguyen Hoang Manh
 */
public class BaseNumberSystem {

    /**
     * Covert number from the user's given base to the other user's given base
     * First, user must choose a base to input a number Second. user must choose
     * a base again but this time it is for the base that the number will get
     * converted to Then perform get number from user in the base that user has
     * given before for input base After that, the number will get converted to
     * the base that user chose
     *
     * @param args
     */
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.add("Base 2");
        menu.add("Base 10");
        menu.add("Base 16");

        BaseNumberConverter list = new BaseNumberConverter();

        System.out.println("Choose the base for input:");
        int inBase = menu.getInput(); 
        
        System.out.println("Choose the base for output:");
        int outBase = menu.getInput();
        
        String number = getValidNumber(inBase);

        System.out.print("Given number in base (" + outBase + ") is: ");

        System.out.println(list.convertNumber(number, inBase, outBase));

    }

    /**
     * Check valid number in the base, user will input number that corresponding
     * to the base that user chose before Method will return a String of number
     * if the condition for each base is met, ready to be convert to another
     * base
     *
     * @param baseIn base of number for input. It is a
     * <code>java.lang.Integer</code> object
     * @return a list String objects. It is a <code>java.lang.String</code>
     * object
     */
    static String getValidNumber(int baseIn) {
        Logger logger = Logger.getLogger(BaseNumberConverter.class.getName());
        Scanner scanner = new Scanner(System.in);
        String num;
        int input;
        boolean cond;

        System.out.print("Enter number in base (" + baseIn + "): ");
        switch (baseIn) {
            case 2:
                //loop until input the correct format number of base 2
                do {
                    num = scanner.nextLine();
                    if (num.matches("[01]+")) {
                        return num; // only allow 0 and 1 in the string
                    } else {
                        logger.log(Level.WARNING, "Invalid number for base ({0})", baseIn);
                        num = "Error";
                    }
                } while ("Error".equals(num));
                
            case 10:
                input = 0;
                cond = true;
                //loop until input integer number
                while (cond) {
                    Scanner intScanner = new Scanner(System.in);
                    try {
                        input = intScanner.nextInt();
                    } catch (InputMismatchException e) {
                        logger.log(Level.WARNING, "Invalid number for base ({0})", baseIn);
                        continue;
                    }
                    if (input < 0) {
                        logger.warning("Number should be positive");
                        continue;
                    }
                    return String.valueOf(input);
                }

            case 16:
                //loop until input number in base 16
                do {
                    num = scanner.nextLine();
                    if (num.matches("^[0-9a-fA-F]+$")) {
                        return num.toUpperCase(); // only allow 0 - 9 and A - D in base 16
                    } else {
                        logger.log(Level.WARNING, "Invalid number for base ({0})", baseIn);
                        num = "Error";
                    }
                } while ("Error".equals(num));
        }

        return "";
    }

}
