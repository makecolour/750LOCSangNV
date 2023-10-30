/*							
 * Copyright(C) 2023,  FPT University.							
 * Ebank System							
 * Manage login process					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage login process and display in language>							
 */
package operations;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * This class is to manage the login process of an user Set the display language
 * to the language of user choice Required account number, password and CAPTCHA.
 * All things must met conditions
 *
 * @author Nguyen Hoang Manh
 */
public class ManageLogin {

    private static final Scanner scanner = new Scanner(System.in);
    private static Locale language;
    private Menu menu = new Menu();

    /**
     * Set language to the given parameter
     *
     * @param language language.
     */
    public void setLocale(Locale language) {
        ManageLogin.language = language;
    }

    /**
     * This method will check the account input to see if it is valid or not
     *
     * @return the result of the input
     */
    private String inputAccountNumber() {
        while (true) {
            //Input account number
            menu.displayWordInLanguage(language, "accountNumber");
            String result = scanner.nextLine();     
            if (result.matches("\\d{10}")) {
                return result;
            }
            //Error found
            menu.displayWordInLanguage(language, "accountError");
            System.out.println();

        }
    }

    /**
     * This method will check the password input to see if it is valid or not
     *
     * @return the result of the input
     */
    private String inputPassword() {
        String result;
        while (true) {
            // Input password
            menu.displayWordInLanguage(language, "password");
            result = scanner.nextLine();

            if (isValidPassword(result)) {
                return result;
            }
        }
    }

    /**
     * This method will check to see if password is fitting the requirements or
     * not
     *
     * @param password the inputed password from user
     * @return the result of the input
     */
    private boolean isValidPassword(String password) {
        int lengthPassword = password.length();

        //Check if password is too small or too long
        if (lengthPassword < 8 || lengthPassword > 31) {
            menu.displayWordInLanguage(language, "passwordError");
            System.out.println();
            return false;
        } else {
            int countDigit = 0;
            int countLetter = 0;

            //Check if password is fitting to the requirements
            for (int i = 0; i < lengthPassword; i++) {
                if (Character.isDigit(password.charAt(i))) {
                    countDigit++;
                } else if (Character.isLetter(password.charAt(i))) {
                    countLetter++;
                }
            }
            //Requirements missing
            if (countDigit < 1 || countLetter < 1) {
                menu.displayWordInLanguage(language, "passwordError");
                System.out.println();
                return false;
            }
        }
        return true;
    }

    /**
     * Generate a randomized CAPTCHA for user to solve
     *
     * @return the result of the generated CAPTCHA
     */
    private String generateCaptchaText() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        int captchaLength = 5;
        //Generating random string for captcha
        for (int i = 0; i < captchaLength; i++) {
            int index = random.nextInt(characters.length());
            stringBuilder.append(characters.charAt(index));
        }

        return stringBuilder.toString();
    }

    /**
     * This method will check if the user has entered the correct CAPTCHA or not
     *
     * @param captchaGenerated the CAPTCHA generated from LoginModule.java
     * @return the result of the input
     */
    private boolean checkCaptcha(String captchaGenerated) {
        //Printing radomised captcha
        menu.displayWordInLanguage(language, "generatedCaptcha");
        System.out.print(captchaGenerated + "\n");

        boolean correctCaptcha;
        int limitCaptchaTimes = 3;
        int count = 0;

        while (true) {
            correctCaptcha = true;
            menu.displayWordInLanguage(language, "captchaInput");
            //Input check
            String captchaInput = scanner.nextLine();

            for (int i = 0; i < captchaGenerated.length(); i++) {
                // Check for each letter in captcha if input is the same as captcha generated
                if (captchaInput.length() != captchaGenerated.length() || captchaGenerated.charAt(i) != captchaInput.charAt(i)) {
                    menu.displayWordInLanguage(language, "captchaInputError");
                    System.out.println("");
                    correctCaptcha = false;
                    count += 1;
                    break;
                }
            }
            // If the captcha is correct, return
            if (correctCaptcha) {
                return true;
            } else if (count == limitCaptchaTimes) {
                menu.displayWordInLanguage(language, "loginFail");
                System.out.println();
                return false;
            }
        }

    }

    /**
     * This method is the base for getting user information and check for
     * CAPTCHA, deciding if the user is valid for login or not
     *
     */
    public void login() {
        //Getting the basic information
        String accountNumber = inputAccountNumber();
        String passString = inputPassword();

        String captchaGenerated;
        //Generating the captcha
        do {
            captchaGenerated = generateCaptchaText();
        } while (!checkCaptcha(captchaGenerated));

        menu.displayWordInLanguage(language, "loginSuccess");
        System.out.println();
    }
}
