/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0103;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Duc Anh
 */
public class GetUserInput {

    private Scanner sc = new Scanner(System.in);
    private Logger logger = Logger.getLogger(GetUserInput.class.getName());

    public LocalDate getDate(String msg, LocalDate date) {
        do {
            try {
                System.out.print(msg);
                String finalDate = sc.nextLine();
                if (finalDate.matches("^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$")) {
                    date = LocalDate.parse(checkDate(finalDate), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    return date;
                } else {
                    System.err.println("Error date");
                }

            } catch (Exception e) {
                logger.log(Level.SEVERE, "Error date", e);
            }
        } while (true);
    }

    private String checkDate(String date) {
        String finalDate = "";
        String[] dateAttribute = date.split("/");
        for (String string : dateAttribute) {
            System.out.println(string);
        }
        if (Integer.parseInt(dateAttribute[0]) < 10) {
            finalDate = "0" + String.valueOf(Integer.parseInt(dateAttribute[0])) + "/";
        } else {
            finalDate = String.valueOf(Integer.parseInt(dateAttribute[0])) + "/";
        }
        if (Integer.parseInt(dateAttribute[1]) < 10) {
            finalDate += "0" + String.valueOf(Integer.parseInt(dateAttribute[1])) + "/" + String.valueOf(Integer.parseInt(dateAttribute[2]));
        } else {
            finalDate += String.valueOf(Integer.parseInt(dateAttribute[1]) + "/" + String.valueOf(Integer.parseInt(dateAttribute[2])));
        }

        return finalDate;
    }
}
