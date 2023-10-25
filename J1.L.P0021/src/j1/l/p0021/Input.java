/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author quyen
 */
public class Input {

    private Scanner sc = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(j1.l.p0021.Input.class.getName());

    /**
     * Get integer var
     *
     * @param msg
     * @param min
     * @param max
     * @return
     */
    int getInt(String msg, int min, int max) {
        int choice = 0;
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                logger.warning("Choice could not be empty. Please enter again!");
            } else {
                try {
                    choice = Integer.parseInt(input.trim());
                    //choice must be in range min to max
                    if (choice >= min && choice <= max) {
                        break;
                    } else {
                        logger.warning("Choice must be in range from " + min + " to " + max);
                    }
                } catch (Exception ex) {
                    logger.warning("Choice must be positive integer number");
                }
            }
        } while (true);
        return choice;
    }

    /**
     * Get not empty String and check if it matches validation
     *
     * @param msg
     * @param formatMsg
     * @param regex
     * @return
     */
    public String getString(String msg, String formatMsg, String regex) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                logger.warning("Input can not be empty");
                continue;
            } else {
                // check if there are no regex
                if (regex.isEmpty()) {
                    break;
                    //check if input matches regex
                } else if (!input.trim().matches(regex.trim())) {
                    logger.warning(formatMsg);
                    continue;
                } else {
                    break;
                }
            }
        } while (true);
        return input.trim();
    }
}
