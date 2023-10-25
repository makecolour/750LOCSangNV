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

/**
 * This class contain main() method This class displays Menu and let user choose
 * language
 *
 * @author Nguyen Thuong Quyen
 */
public class J1SP0070 {

    /**
     * This is main() method case 1: choose Vietnamese as System's lang case 2:
     * choose English as System's lang case 3: Exit
     *
     * @author Nguyen Thuong Quyen
     * @param args
     */
    public static void main(String[] args) {
        EBank loginSystem = new EBank();
        Menu menu = new Menu();
        do {
            menu.displayMenu();
            int choice = menu.getChoice("Please choose an option/Hãy chọn một hành động: ", 1, 3);
            switch (choice) {
                
                case 1:
                    loginSystem.VietnameseSystem();
                    break;
                case 2:
                    loginSystem.EnglishSystem();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

}
