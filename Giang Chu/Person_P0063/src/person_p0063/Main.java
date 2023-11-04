/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Bank management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package person_p0063;

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
                    manager.addNewPer();
                    break;
                case 2:
                    manager.display();
                    break;
                case 3 :
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
        System.out.println("1. Create Person");
        System.out.println("2. Display");
        System.out.println("3. Exit");
        int choice = sc.checkLimit(1,3,"Enter your choice: ");
        return choice;
    }
}
