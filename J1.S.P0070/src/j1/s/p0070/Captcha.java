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

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class is made to handle captcha's work
 *
 * @author quyen
 */
class Captcha {

    private static final Logger logger = Logger.getLogger(Captcha.class.getName());

    /**
     * Create a captcha
     *
     * @return
     */
    String createCaptcha() {
        String scope = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";//contains all of a valid captcha's chars
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        do {
            sb.delete(0, sb.length());//clear string builder
            //random all of 5 chars of captcha out of scope's char
            for (int i = 0; i < 5; i++) {
                sb.append(scope.charAt(rand.nextInt(scope.length() - 1)));
            }
        } while (checkCaptcha(sb.toString()) == false);
        return sb.toString();
    }

    /**
     * Check if generated captcha is valid
     *
     * @param captcha
     * @return
     */
    boolean checkCaptcha(String captcha) {
        int upper = 0, lower = 0, number = 0;
        //count number of lowercase, uppercase and digit chars
        for (int i = 0; i < captcha.length(); i++) {
            if (captcha.charAt(i) >= 'A' && captcha.charAt(i) <= 'Z') {
                upper++;
            } else if (captcha.charAt(i) >= 'a' && captcha.charAt(i) <= 'z') {
                lower++;
            } else if (captcha.charAt(i) >= '0' && captcha.charAt(i) <= '9') {
                number++;
            }
        }
        return !(upper == 0 || lower == 0 || number == 0);
    }

    /**
     * Check the input captcha ì it match generated captcha, loop until user
     * input right, reset captcha every loop
     *
     * @param captcha
     * @param captchaFail
     * @param inputCaptcha: user's input captcha
     */
    void handleCaptcha(String captcha, String captchaFail, String inputCaptcha) {
        do {
            String newCaptcha = createCaptcha();
            System.out.println(captcha + newCaptcha);
            String captchaInput = getCaptcha(inputCaptcha, captchaFail);
            if (newCaptcha.equals(captchaInput)) {
                return;
            } else {
                logger.warning(captchaFail);
            }
        } while (true);
    }

    /**
     * Get user's input captcha from keyboard
     *
     * @param msg
     * @param errorMsg
     * @return
     */
    String getCaptcha(String msg, String errorMsg) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.print(msg);
        try {
            input = sc.nextLine();
            if (input.isEmpty()) {
                throw new Exception();
            }
        } catch (Exception ex) {
            logger.warning(errorMsg);
        }
        return input;
    }
}
