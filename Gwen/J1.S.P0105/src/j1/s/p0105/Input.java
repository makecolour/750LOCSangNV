/*							
 * Copyright(C) 2023,  FPT University.							
 * Products management system							
 * Manage information of Products					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-24>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of Products using List>							
 */
package j1.s.p0105;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author quyen
 */
public class Input {

    private Scanner sc = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(j1.s.p0105.Input.class.getName());

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

    /**
     * Get double variable
     *
     * @param msg
     * @param min
     * @param max
     * @return
     */
    double getDouble(String msg) {
        double choice = 0;
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                logger.warning("Choice could not be empty. Please enter again!");
            } else {
                try {
                    choice = Double.parseDouble(input.trim());
                    //choice must be in range min to max
                    if (choice >= 0) {
                        break;
                    } else {
                        logger.warning("Please input a positive variable");
                    }
                } catch (Exception ex) {
                    logger.warning("Please input a double number");
                }
            }
        } while (true);
        return choice;
    }

    /**
     * Get and verify dd-MM-yyyy date
     *
     * @param msg
     * @return
     */
    Date getDate(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String result = sc.nextLine().trim();
                SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
                form.setLenient(false);
                Date date = form.parse(result.trim());
                if (result.trim().equals(form.format(date))) {
                    if(date.getYear()>=0)
                    {
                        if(date.getMonth()>=0)
                        {
                            if(date.getDate()>=1)
                            {
                                return date;
                            }
                            else{
                                logger.warning("Please input a date after 01-01-1900");
                            }
                        }
                        else{
                            logger.warning("Please input a date after 01-01-1900");
                        }
                    }
                    else{
                        logger.warning("Please input a date after 01-01-1900");
                    }
                } else {
                    logger.warning("Please input a date after 01-01-1900");
                }
            } catch (Exception ex) {
                logger.warning("Please input a valid date format");
            }
        }
    }
}
