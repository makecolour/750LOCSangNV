/*							
 * Copyright(C) 2023,  FPT University.							
 * Students management system							
 * Manage information of Students					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-25>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of Students using List>							
 */
package j1.l.p0021;

/**
 * This is the main class
 *
 * @author quyen
 */
public class J1LP0021 {

    /**
     * This is the main function
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        Input input = new Input();
        StudentsManagement sm = new StudentsManagement();
        do {
            menu.display();
            int choice = input.getInt("Please choose an option: ", 1, 5);
            switch (choice) {
                case 1:
                    sm.createStudent();
                    break;
                case 2:
                    sm.findNSort();
                    break;
                case 3:
                    sm.upNDel();
                    break;
                case 4:
                    sm.report();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }
}
