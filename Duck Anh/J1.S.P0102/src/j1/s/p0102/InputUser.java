/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Format Date> :				
 * <Create a Java console program to compare date.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-10-12>      <8.2>     <AnhTD>      <Write a program to takes input date as [dd/mm/yyyy] format and find out the day of entered date.>				
 */
package j1.s.p0102;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The `InputUser` class take user input, specifically for retrieving dates
 in a specific format. It utilizes a
 *
 * @author Tran Duc Anh
 */
public class InputUser {

    private Scanner sc = new Scanner(System.in);
    private Logger logger = Logger.getLogger(InputUser.class.getName());

    /**
     * The method attempts to parse the input as a date in the format
     * "DD/MM/YYYY" and convert it to a `LocalDate` object. If the input is not
     * in the correct format, an error message is printed, and the user is
     * prompted to enter a valid date again.
     *
     * @param msg The message displayed to prompt the user for input.
     * @param date The default LocalDate value to use if input is invalid.
     * @return A LocalDate representing the parsed user input date.
     */
    public LocalDate getDate(String msg, LocalDate date) {
        do {
            try {
                System.out.print(msg);
                String finalDate = sc.nextLine();
                date = LocalDate.parse(finalDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                System.out.println(date);
                String[] attribute = finalDate.split("/");
                if (Integer.parseInt(attribute[0]) >= 1 && Integer.parseInt(attribute[0]) <= date.lengthOfMonth()) {
                    return date;
                } else {
                    System.out.println("Error date");
                }

            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error date", e);
            }
        } while (true);
    }

}
