/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Bank management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package bank_p0071;

/**
 * This class contains the main method for implementing employee management
 * project
 *
 * @author Chu Hoang Giang
 */
public class Main {

    /**
     * Allow user for adding, updating, deleting, searching, sort employee
     *
     * @param args
     */
    public static void main(String[] args) {
        Manager manager = new Manager();
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    manager.addNewTask();
                    break;
                case 2:
                    manager.removeTask();
                    break;
                case 3:
                    manager.displayTask();
                    break;
                case 4:
                    return;
            }
        }
    }

    /**
     * Displays the menu
     *
     * @return an integer
     */
    private static int menu() {
        Scan sc = new Scan();
        System.out.println("1. Add new task");
        System.out.println("2. Delete task");
        System.out.println("3. Display task");
        System.out.println("4. Exit");
        int choice = sc.checkLimit(1,4,"Enter your choice: ");
        return choice;
    }
}
