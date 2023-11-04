/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Bank management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package student_p0021;

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
                    manager.addNewStu();
                    break;
                case 2:
                    manager.findAndSort();
                    break;
                case 3:
                   manager.updateOrDelete();
                    break;
                case 4:
                    manager.Report();
                    break;
                case 5 :
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
        System.out.println("1. Create ");
        System.out.println("2. Find and sort");
        System.out.println("3. Update or delete");
        System.out.println("4. Report ");
        System.out.println("5. Exit");
        int choice = sc.checkLimit(1,5,"Enter your choice: ");
        return choice;
    }
}
