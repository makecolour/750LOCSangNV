/*							
 * Copyright(C) 2023,  FPT University.							
 * Ebank System							
 * Manage login process					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage login process and display in language>							
 */
package operations;

import java.util.Vector;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
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
            System.out.print("Please choose one option: ");
            Scanner scn = new Scanner(System.in);
            try {
                input = scn.nextInt();

                if ((input > 0 && input <= this.size() && input == (int) input)) {
                    return input - 1;
                }
            } catch (InputMismatchException e) {
                logger.warning("INTEGER-type INPUT, please try again");
                continue;
            }
        }

        return Integer.MIN_VALUE;
    }

    /**
     * This method print out the message corresponding to the language chosen
     *
     * @param curLocate the choosen language by user
     * @param key the key for the message that will be translated to
     */
    public void displayWordInLanguage(Locale curLocate, String key) {
        // Use resourceBundle to retrieve the language bundle in the .properties files
        ResourceBundle words
                = ResourceBundle.getBundle("languages/" + curLocate.toString(), curLocate);

        //Get message in the given language
        String value = words.getString(key);
        System.out.printf(value);
    }

}
