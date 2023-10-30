/*							
 * Copyright(C) 2023,  FPT University.							
 * Ebank System							
 * Manage login process					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-21>       <1.0>          <Nguyen Thuong Quyen>     <Manage login process and display in language>							
 */
package j1.s.p0070;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This is what you're supposed to do in a Menu
 * @author quyen
 */
public class Menu {
    private static final Logger logger = Logger.getLogger(Menu.class.getName());
    /**
     * Display choose language menu
     */
    void displayMenu() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese/Tiếng Việt");
        System.out.println("2. English/Tiếng Anh");
        System.out.println("3. Exit/Thoát");
    }
    /**
     * Check user's choice
     * @param msg: msg to user
     * @param min: num of 1st func
     * @param max: num of last func
     * @return user's choice
     */
    int getChoice(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                logger.warning("Choice could not be empty. Please enter again!");
            } else {
                try {
                    choice = Integer.parseInt(input);
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

}
