/*
 * Copyright(C) 2005,  <FPTU>.
 * <0102> :
 *  <Week day analyzer>
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * <26/10/2023>                <1>              <la Minh>                       <base>
 */
package Main;

import java.util.Date;
import java.util.logging.Logger;
import java.util.Scanner;
import java.text.SimpleDateFormat;

/**
 * A simple date analyzer and return the day of the week it is associated with
 *
 * @author La Minh
 */
public class Main {

    /**
     * Main run-time
     */
    public static void main(String[] args) {
        
        //Get date
        Date date = getDate("Date: ");
        int dateDay = date.getDay();
        //print result
        System.out.print("Today is: ");
        switch (dateDay){
            case 1:
                System.out.println("Monday"); break;
            case 2:
                System.out.println("Tuesday"); break;
            case 3:
                System.out.println("Wednesday"); break;
            case 4:
                System.out.println("Thursday"); break;
            case 5:
                System.out.println("Friday"); break;
            case 6:
                System.out.println("Saturday"); break;
            case 0:
                System.out.println("Sunday"); break;
        }
    }

    /**
     * Date input
     * @param msg the displayed message
     * @return the date in formatted format
     */
    private static Date getDate(String msg) {
        Logger logger = Logger.getLogger(Main.class.getName());
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(msg);
                String result = sc.nextLine().trim();
                SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
                Date date = form.parse(result.trim());
                if (result.trim().equals(form.format(date))) {
                    return date;
                } else {
                    logger.warning("Please input a valid date format");
                }
            } catch (Exception e) {
                logger.warning("Please input a valid date format");
            }
        }
    }
}
