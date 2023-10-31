/*							
 * Copyright(C) 2023,  FPT University.							
 * Task Management							
 * Manage information of task					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-22>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of taks using List>							
 */
package j1.s.p0071;

/**
 * This is the main class for end-user
 *
 * @author quyen
 */
public class J1SP0071 {

    /**
     * This is what you're supposed to do in a main func
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        TaskManager manager = new TaskManager();
        do {
            menu.display();
            int choice = menu.getChoice();
            switch (choice) {
                case 1:
                    manager.addTask();
                    break;
                case 2:
                    manager.deleteTask();
                    break;
                case 3:
                    manager.displayTask();
                    break;
                case 4:
                    return;
            }

        } while (true);
    }
}
