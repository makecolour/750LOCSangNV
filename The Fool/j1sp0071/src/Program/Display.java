/**
 * Copyright(C) 2023,  <La Dieu Minh HE180677>.
 * <ProjectCode/Short Name of Application> : p0071
 *  <Task Manager>
 *
 * Record of change:
 * DATE              Version             AUTHOR             DESCRIPTION
 * <2023-10-12>      <2.3>              <La Dieu Minh>      <Base version>
 */
package Program;

import Manager.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class create display for the user to see the menu and make choices
 * depends on the menu outputted
 *
 * @author La Dieu Minh
 */
public class Display {

    /**
     * Main run time for the program
     *
     * @param args
     */
    public static void main(String[] args) {
        display();
    }
    
    /**
     * Main menu display
     */
    static void display() {
        ArrayList<Task> lt = new ArrayList<>();
        TaskManager tm = new TaskManager();
        Input input = new Input();
        while (true) {
            
            //Menu
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Display Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = checkIntLimit(1, 4);
            switch (choice) {
                case 1:
                    tm.addTask(lt);
                    break;
                case 2:
                    tm.deleteTask(lt);
                    break;
                case 3:
                    tm.print(lt);
                    break;
                case 4:
                    return;

            }
        }
    }
    
    private static int checkIntLimit(int min, int max){
        //check for user input
        Scanner sc = new Scanner(System.in);
        int result = sc.nextInt();
        //check for in the range
        if (result >= min && result <= max){
            return result;
        } else {
            System.out.println("Input not in range of " + min + "-" + max);
        }
        
        return 0;
    }
}
