/*							
 * Copyright(C) 2023,  FPT University.							
 * Doctor management program. 							
 * Manage information of Doctor					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-27>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of Doctor using List>							
 */
package j1.s.p0055;

/**
 * This class is for end-user
 *
 * @author quyen
 */
public class J1SP0055 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        Input input = new Input();
        DoctorsManagement dm = new DoctorsManagement();
        do {
            menu.display();
            int choice = input.getInt("Please choose an option: ", 1, menu.getMax());
            switch (choice) {
                case 1:
                    dm.addDoc();
                    break;
                case 2:
                    dm.updateDoc();
                    break;
                case 3:
                    dm.delDoc();
                    break;
                case 4:
                    dm.searchDoc();
                    break;
                case 5:
                    dm.printDoc();
                    break;
                case 6:
                    return;
            }
        } while (true);
    }

}
