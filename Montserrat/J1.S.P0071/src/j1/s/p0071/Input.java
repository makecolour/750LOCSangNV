/*							
 * Copyright(C) 2023,  FPT University.							
 * Task Management							
 * Manage information of task					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-22>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of taks using List>							
 */
package j1.s.p0071;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author quyen
 */
public class Input {

    Scanner sc = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(Input.class.getName());

    /**
     * Get int between min and max
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
     * Get not empty String
     *
     * @param msg
     * @return
     */
    String getString(String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                logger.warning("Input can not be empty");
                continue;
            } else {
                break;
            }
        } while (true);
        return input.trim();
    }

    /**
     * Get Double (.0 and .5) number between min and max
     *
     * @param msg
     * @param min
     * @param max
     * @return
     */
    double getDouble(String msg, double min, double max) {
        String input;
        double result;
        do {
            input = getString(msg);
            if (input.trim().isEmpty()) {
                logger.warning("Input can not be empty");
                continue;
            } // Input double value must matches pattern x.5 or x.0 
            // \d+ matches one or more digit from 0-9
            // \. matches character '.'
            // ([5]|[0]) only allows number 5 or 0 after the dot
            else if (!input.trim().matches("^\\d+\\.([5]|[0])$")) {
                logger.warning("Please input a double number");
                continue;
            }
            try {
                result = Double.parseDouble(input.trim());
                if (result >= min && result <= max) {
                    break;
                } else {
                    logger.warning("Please input a number from 8.0 to 17.5");
                    continue;
                }
            } catch (Exception ex) {
                logger.warning("Please input a double number");
            }
        } while (true);
        return result;
    }

    /**
     * Get and verify dd-MM-yyyy date
     *
     * @param msg
     * @return
     */
    String getDate(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String result = sc.nextLine().trim();
                SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
                Date date = form.parse(result.trim());

                if (result.trim().equals(form.format(date))) {
                    Date now = new Date();
                    if (date.getYear() >= now.getYear()) {
                        if (date.getMonth() >= now.getMonth()) {
                            if (date.getDate() >= now.getDate()) {
                                return result.trim();
                            } else {
                                logger.warning("Date can not be in the past");
                            }
                        } else {
                            logger.warning("Date can not be in the past");
                        }
                    } else {
                        logger.warning("Date can not be in the past");
                    }
                } else {
                    logger.warning("Please input a valid date format");
                }
            } catch (Exception ex) {
                logger.warning("Please input a valid date format");
            }
        }
    }
}
