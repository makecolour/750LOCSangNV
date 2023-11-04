/*
 * Copyright(C) 2005,  <FPTU>.
 * <0103> :
 *  <Date comparator>
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * <26/10/2023>                <1>              <la Minh>                       <base>
 */
package Main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * A simple date comparator that will return if the date is before after or the same day
 *
 * @author La Minh
 */
public class Main {

    /**
     * Main run-time
     */
    public static void main(String[] args) {
        // Get date1 and date2
        Date date1 = getDate("Please enter first date: ");
        Date date2 = getDate("Please enter second date: ");
        
        //compare
        
        //is after
        if (date1.after(date2)) {
            System.out.println("Date1 (" + date1 +") is after date2 (" + date2 + ")");
        //is before
        } else if (date1.before(date2)){
            System.out.println("Date1 (" + date1 +") is before date2 (" + date2 + ")");
        //is same day
        } else if (date1.equals(date2)){
            System.out.println("Date1 (" + date1 +") is the same date as date2 (" + date2 + ")");
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
