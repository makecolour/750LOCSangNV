/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Doctor management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0                           First implemention
 */
package doctormanagementsystem;

/**
 * This class contains the main method for implementing doctor management
 * project
 *
 * @author 
 */
public class DoctorMain {

    /**
     * Allow user for adding, updating, deleting, searching doctors
     *
     * @param args
     */
    public static void main(String[] args) {
        //loop until user want to exit
        DoctorManager manager = new DoctorManager();
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    manager.addDoctor();
                    break;
                case 2:
                    manager.updateDoctor();
                    break;
                case 3:
                    manager.deleteDoctor();
                    break;
                case 4:
                    manager.searchDoctor();
                    break;
                case 5:
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
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        int choice = UserInput.getInt("Enter your choice: ");
        return choice;
    }
}
