/*							
 * Copyright(C) 2023,  FPT University.							
 * Ebank System							
 * Manage login process					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-21>       <1.0>          <Nguyen Thuong Quyen>     <Manage login process and display in language>							
 */
package j1.s.p0070;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class represent Account object and contains methods that perform
 * checking user's input account
 *
 * @author quyen
 */
class Account {

    private static final Logger logger = Logger.getLogger(Account.class.getName());
    private String acount;
    private String passwords;
    Scanner sc = new Scanner(System.in);

    /**
     * Constructors and getters, setters
     */
    public Account() {
    }

    public Account(String acount, String passwords) {
        this.acount = acount;
        this.passwords = passwords;
    }

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    /**
     * Let user input account number, loop until input is valid
     *
     * @param msg: msg to let user enter acc num
     * @param formatMsg: warning msg when acc num is invalid
     * @return user's input acc num
     */
    String getAcountNumber(String msg, String formatMsg) {
        String input = null;
        boolean check = false;
        do {
            System.out.print(msg);
            try {
                check = true;
                input = sc.nextLine();
                //check if input acc num contains 10 digits
                if (input.matches("^[0-9]{10}$") == false) {
                    check = false;
                    logger.warning(formatMsg);
                }
            } catch (Exception ex) {
                check = false;
                logger.warning(formatMsg);
            }
        } while (check == false);
        return input;
    }

    /**
     * Let user input account password
     *
     * @param msg: msg to let user enter acc pass
     * @param formatMsg: warning msg when acc pass is invalid
     * @return user's input acc pass
     */
    String getPassword(String msg, String formatMsg) {
        String input = null;
        boolean check = false;
        do {
            System.out.print(msg);
            try {
                check = true;
                input = sc.nextLine();
                if (input.length() >= 8 && input.length() <= 31) {
                    //check if input acc pas is valid
                    if (input.matches("^[a-zA-Z0-9]*(([a-zA-Z]+[0-9]+)|[0-9]+[a-zA-Z]+)[a-zA-Z0-9]*$") == false) {
                        check = false;
                    }
                } else {
                    check = false;
                }
            } catch (Exception ex) {
                check = false;
                logger.warning(formatMsg);
            }
        } while (check == false);

        return input;
    }

}
