/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0103;

import java.time.LocalDate;

/**
 *
 * @author Duc Anh
 */
public class J1SP0103 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GetUserInput getInput = new GetUserInput();
        LocalDate firstDate = getInput.getDate("Please enter the first date: ", null);
        LocalDate secondDate = getInput.getDate("Please enter the second date: ", null);

        if (firstDate.isAfter(secondDate)) {
            System.out.println("Date1 is after Date2");
        } else if (firstDate.isBefore(secondDate)) {
            System.out.println("Date1 is before Date2");
        } else {
            System.out.println("Date1 is Date2");
        }
    }

}
