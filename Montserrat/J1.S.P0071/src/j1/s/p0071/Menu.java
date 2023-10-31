/*							
 * Copyright(C) 2023,  FPT University.							
 * Task Management							
 * Manage information of task					
 *							
 * Record of change:							
 * DATE              Version                AUTHOR                       DESCRIPTION							
 * <2023-10-22>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of taks using List>							
 */
package j1.s.p0071;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class generate the menu and perform its features
 *
 * @author quyen
 */
public class Menu {

    private static final Logger logger = Logger.getLogger(Menu.class.getName());
    private ArrayList<String> functions = new ArrayList<>();

    /**
     * This method add new features to menu
     *
     * @param fName
     */
    void addFunction(String fName) {
        functions.add(fName);
    }

    /**
     * Display available tasks
     */
    void display() {
        System.out.println("========== Task program ==========");
        for (String s : functions) {
            System.out.println("(" + (functions.indexOf(s) + 1) + ") " + s);
        }
    }

    /**
     * Consructor for menu and add available features
     */
    public Menu() {
        addFunction("Add Task");
        addFunction("Delete Task");
        addFunction("Display Task");
        addFunction("Exit");
    }

    /**
     * Get user's choice of features
     *
     * @return
     */
    int getChoice() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        String input;
        do {
            System.out.print("Please choose an option: ");
            input = sc.nextLine();
            if (input.isEmpty()) {
                logger.warning("Choice could not be empty. Please enter again!");
            } else {
                try {
                    choice = Integer.parseInt(input);
                    //choice must be in range min to max
                    if (choice >= 1 && choice <= functions.size()) {
                        break;
                    } else {
                        logger.warning("Choice must be in range from 1 to " + functions.size());
                    }
                } catch (Exception ex) {
                    logger.warning("Choice must be positive integer number");
                }
            }
        } while (true);
        return choice;
    }
}
