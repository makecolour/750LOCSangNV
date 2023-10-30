/*
 * Copyright(C) 2005,  FPTU.
 * EM :
 *  Employee Manager
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2023-10-18                 1.5                 MinhLD                       <General fixes>
 */
package Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;

import Display.ErrorLogger;

/**
 * This class will be used for general input
 *
 * @author MinhLD
 */
public class Input {
    
    private final Scanner sc = new Scanner(System.in);
    private final ErrorLogger erl = new ErrorLogger();
    private final String className = Input.class.getName();

    /**
     * integer input
     *
     * @param msg the message that will be outputted
     * @param min the minimum value
     * @param max the maximum value
     * @return the int
     */
    public int getInteger(String msg, int min, int max) {
        String input;
        int IntNumber = -1;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                erl.Log(className, "Input could not be empty!!!");
                continue;
            }
            try {
                IntNumber = Integer.parseInt(input);
                //check choice in range min and max
                if (IntNumber >= min && IntNumber <= max) {
                    break;
                } else {
                    System.err.println("Input must be in range " + min + " to " + max);
                    continue;
                }
            } catch (NumberFormatException ex) {
                erl.Log(className, "Input must be integer");
            }
        } while (true);
        return IntNumber;
    }

    /**
     * String input
     *
     * @param msg the message that will be displayed
     * @param regex the regular expression used for controlling what needed to be inputted
     * @return the string
     */
    public String getString(String msg, String regex) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.isEmpty()) {
                erl.Log(className, "Input could not be empty!!!");
                continue;
            } else {
                if (regex.isEmpty()) {
                    break;
                } else if (input.matches(regex)) {
                    break;
                } else {
                    erl.Log(className, "Input not match format require");
                    continue;
                }
            }
        } while (true);
        return input;
    }

    /**
     * date input
     *
     * @param msg the message that will be used to display out
     * @return the date
     */
    public Date getDate(String msg) {
        String input;
        Date date = null;
        do {
            System.out.print(msg);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            input = sc.nextLine();
            if (input.isEmpty()) {
                erl.Log(className, "Input could not be empty!!!");
                continue;
            }
            /*
            * \d{1,2}: the number have 1 or 2 digits number
            * [/]: contain character /
            * \d{4}: the number must have 4 digit
            */
            else if (!input.matches("\\d{1,2}[/]\\d{1,2}[/]\\d{4}")) {
                erl.Log(className, "Input is wrong format");
                continue;
            }
            try {
                date = dateFormat.parse(input);
            } catch (ParseException exception) {
                erl.Log(className, "Date doesn't existed!!");
            }

            Date curDate = Calendar.getInstance().getTime();

            if (curDate.getYear() - date.getYear() > 18) {
                return date;
            } else {
                if (date.getMonth() < curDate.getMonth()) {
                    return date;
                } else if (date.getDate() <= curDate.getDate()) {
                    return date;
                }
            }
            erl.Log(className, "Employee must at least 18 year-old");
        } while (true);
    }
}