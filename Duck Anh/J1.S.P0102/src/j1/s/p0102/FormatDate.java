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

/**
 * The `FormatDate` class is a Java program that demonstrates obtaining a
 user-input date in the "DD/mm/YYYY" format and then displaying the
 corresponding day of the week for that date.
 *
 * @author Trần Đức Anh
 */
public class FormatDate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InputUser getInput = new InputUser();
        LocalDate date = getInput.getDate("Please enter date with format [dd/mm/yyyy]: ", null);
        System.out.println("Your day is " + date.getDayOfWeek());
    }

}
