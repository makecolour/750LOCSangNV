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

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * This class handles most of functions that related to lang system
 *
 * @author quyen
 */
public class EBank {

    private static final Logger logger = Logger.getLogger(EBank.class.getName());

    /**
     * These methods set Locale to vi or en
     */
    void VietnameseSystem() {
        Locale Vietnam = new Locale("vi", "VN");
        loginSystem(Vietnam);
    }

    void EnglishSystem() {
        Locale America = new Locale("en", "US");
        loginSystem(America);
    }

    /**
     * This is the most important function Let user input account number, pass
     * and captcha then check them and return them i
     *
     * @param locale
     */
    private void loginSystem(Locale locale) {
        Account acc = new Account();
        ResourceBundle getMsg = ResourceBundle.getBundle("language", locale);
        Captcha capt = new Captcha();

        String account = acc.getAcountNumber(getMsg.getString("accountNumber"), getMsg.getString("inputAcountError"));
        String password = acc.getPassword(getMsg.getString("Password"), getMsg.getString("inputPasswordError"));
        capt.handleCaptcha(getMsg.getString("Captcha"), getMsg.getString("CaptchaError"), getMsg.getString("inputCaptcha"));

        boolean checkAcount = checkAccount(account, password);
        if (checkAcount) {
            System.out.println(getMsg.getString("loginSuccess"));
        } else {
            logger.warning(getMsg.getString("loginFail"));
        }
    }

    /**
     * Check if account is exist in Bank's Database
     *
     * @param account
     * @param password
     * @return
     */
    private boolean checkAccount(String account, String password) {
        AccountList list = new AccountList();
        if (list.accList.isEmpty()) {
            return false;
        } else {
            for (Account acc : list.accList) {
                if (acc.getAcount().equals(account) && acc.getPasswords().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

}
