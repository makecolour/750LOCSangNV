/*							
 * Copyright(C) 2023,  FPT University.							
 * Task Management							
 * Manage information of taks					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage information of taks using List>							
 */
package program;

import java.util.ArrayList;
import java.util.List;
import objects.Task;
import operations.ManageTask;
import operations.Menu;

/**
 * This class is to manage task without the need to look at method details Allow
 * user to add, display or delete task from task list
 *
 * <p>
 * Note: This class also user to add menu option if needed but user must also
 * writing a function for that options in ManageTask Class
 *
 * @author Nguyen Hoang Manh
 */
public class TaskManagement {

    /**
     * Add menu and display menu Add, display and delete task
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.addMenuItem("Add task");
        menu.addMenuItem("Display tasks");
        menu.addMenuItem("Delete task");
        menu.addMenuItem("Quit");

        int userChoice;

        ManageTask operation = new ManageTask();
        List<Task> tasks = new ArrayList();

        while (true) {

            userChoice = menu.getUserChoice();
            //handing option
            switch (userChoice) {
                case 1:
                    operation.addTask(tasks);
                    break;
                case 2:
                    operation.display(tasks);
                    break;
                case 3:
                    operation.removeTask(tasks);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

}
