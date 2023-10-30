/**
 * Copyright(C) 2023,  <La Dieu Minh HE180677>.
 * <ProjectCode/Short Name of Application> : p0071
 *  <Task Manager>
 *
 * Record of change:
 * DATE              Version             AUTHOR             DESCRIPTION
 * <2023-10-12>      <2.3>              <La Dieu Minh>      <Base version>
 */
package Program;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 * This class will check for input
 *
 * @author La Dieu Minh
 */
public class Input {
    
    private static final Scanner in = new Scanner(System.in);
    private static final MyLog log = new MyLog();
    private static final String className = Input.class.getName();

    /**
     * check if the user int input is in the correct range or not
     * 
     * @param min min value
     * @param max max value
     * @return int value
     */
    int checkIntLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                log.Log(className, "Re-input");
            }
        }
    }

    /**
     * check for user date input to see if correct or not
     * 
     * @return inputted date
     */
    public String checkInputDate(String msg) {
        while (true) {
            try {
                String result = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                // format date to Date type
                Date date = format.parse(result);
                // format back to String and compare
                LocalDate currentDate = LocalDate.now();
                System.out.println(currentDate);
                //get current time and format
                Date currentD = format.parse(currentDate.toString());
                System.out.println(currentD);
                if (result.equalsIgnoreCase(format.format(date))) {
                    if (currentD.before(date) || currentD.equals(date)){
                        return result;
                    } else {
                        log.Log(className, "Re-input");
                        System.out.print(msg);
                    }
                } else {
                    log.Log(className, "Re-input");
                    System.out.print(msg);
                }
                
            } catch (NumberFormatException | ParseException ex) {
                log.Log(className, "Re-input");
                System.out.print(msg);
            }
        }
    }

    /**
     * check if user string is valid or not
     * 
     * @return the string input
     */
    public String checkInputString(String msg) {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                log.Log(className, "Not-empty");
                System.out.print(msg);
            } else {
                return result;
            }
        }
    }
    
    /**
     * check for yes or no
     * 
     * @return boolean value T/F
     */
    public boolean checkInputYesNo(){
        while (true){
            System.out.println("Please enter Yes or No");
            String result = checkInputString("Please re-enter: ");
            if (result.equalsIgnoreCase("y")){
                return true;
            }
            else if (result.equalsIgnoreCase("n")) {
                return false;
            }
        }
    }

    /**
     * check if user int input is valid or not
     * @return int value inputted
     */
    public int checkInputInt(String msg) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine());
                return result;
            } catch (NumberFormatException ex) {
                log.Log(className, "Re-input");
                System.out.print(msg);
            }
        }
    }

    /**
     * check if user inputted the correct task id or error
     * @return the task ID
     */
    public String checkInputTaskTypeId() {
        while (true) {
            int n = checkIntLimit(1, 4);
            String result;
            switch(n){
                case 1: result = "Code"; break;
                case 2: result = "Test"; break;
                case 3: result = "Design"; break;
                case 4: result = "Review"; break;
                default: result = null; break;
            }
            return result;
        }
    }

    /**
     * check if the planning time input is valid or not
     * 
     * @param min min value
     * @param max max value
     * @return the value in string form
     */
    public String checkInputPlan(double min, double max, String msg) {
        while (true) {
            String result = checkInputString(msg);
            try {
                double number = Double.parseDouble(result);
                if (number % 0.5 != 0) {
                    log.Log(className, "Please input .5 or integer number.");
                    System.out.print(msg);
                    continue;
                }
                if (number < min || number > max) {
                    log.Log(className, "Please input between " + min + ", " + max + ": ");
                    System.out.print(msg);
                    continue;
                }
                return String.valueOf(number);
            } catch (Exception e) {
                log.Log(className, "Please input an double number");
                System.out.print(msg);
            }
        }
    }
}
