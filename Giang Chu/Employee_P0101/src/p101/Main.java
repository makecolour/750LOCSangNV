/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Employee management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package p101;

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
                    manager.addNewEmployee();
                    break;
                case 2:
                    manager.updateEmployee();
                    break;
                case 3:
                    manager.removeEmployee();
                    break;
                case 4:
                    manager.searchEmployee();
                    break;
                case 5:
                    manager.sortEmployeeBySalary();
                    break;
                case 6:
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
        System.out.println("1. Add employee");
        System.out.println("2. Update employee");
        System.out.println("3. Delete employee");
        System.out.println("4. Search employee");
        System.out.println("5. Sort employee");
        System.out.println("6. Exit");
        int choice = sc.nextInt("Enter your choice: ");
        return choice;
    }
}
