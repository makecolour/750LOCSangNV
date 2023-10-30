/*							
 * Copyright(C) 2023,  FPT University.							
 * Ebank System							
 * Manage login process					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage login process and display in language>							
 */
package program;

import java.util.Locale;
import operations.ManageLogin;
import operations.Menu;

/**
 * This class allow user to choose a language for display And bring user to
 * login process
 *
 * @author Nguyen Hoang Manh
 */
public class EBankSystem {

    /**
     * Allow user to choose an available language Display the login process in
     * that language
     *
     */
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.addMenuItem("Vietnamese");
        menu.addMenuItem("English");
        menu.addMenuItem("Exit");

        System.out.println("----Login Program----");
        int userChoice = menu.getUserChoice();

        ManageLogin mlg = new ManageLogin();
        
        Locale language = new Locale(menu.get(userChoice));

        mlg.setLocale(language);

        mlg.login();
    }
}
