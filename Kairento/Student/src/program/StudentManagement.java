/*							
 * Copyright(C) 2023,  FPT University.							
 * Student Management							
 * Manage information of students					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage information of students using operation>							
 */
package program;

import java.util.ArrayList;
import operations.Menu;
import java.util.logging.Logger;
import objects.Student;
import operations.StudentList;

/**
 * This class is for user/tester to use the program without the need to look at
 * method details
 *
 *
 * <p>
 * Note: This class also user to add menu option if needed, but user must also
 * writing a function for that options in StudentList Class
 *
 * @author Nguyen Hoang Manh
 */
public class StudentManagement {

    private final static int MAX = 2;

    /**
     * Print out the menu that are available Get user choice and do the task
     * corresponding to the options in menu Options are create, find, update and
     * delete student from the existing list
     *
     * @param args
     */
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(StudentManagement.class.getName());

        Menu menu = new Menu();
        menu.add("Create");
        menu.add("Find and Sort");
        menu.add("Update/Delete");
        menu.add("Report");
        menu.add("Exit");

        StudentList operation = new StudentList();

        boolean valid = true;
        String choice;
        String stuName;
        int count;

        String message = "\nDo you want to continue (Y/N)? \nChoose Y to continue, N to return main screen.";

        int userChoice;

        ArrayList<Student> studentList = new ArrayList<>();

        do {
            System.out.println("WELCOME TO STUDENT MANAGEMENT");
            userChoice = menu.getUserChoice();

            switch (userChoice) {
                case 1: // Create a operation of students
                    count = 0;
                    do {
                        operation.addStudent(studentList);
                        count++;
                        if (count == MAX) {
                            do {
                                System.out.println(message);
                                choice = menu.getValidString().toUpperCase();
                                valid = choice.matches("^[YN]");
                            } while (!valid);
                            if (choice.startsWith("Y")) {
                                continue;
                            } else if (choice.startsWith("N")) {
                                break;
                            }
                        }
                    } while (true);
                    break;

                case 2: // Find student by name and display to screen
                    if (operation.isEmptyList(studentList)) {
                        break;
                    }

                    System.out.print("Input Student's Name: ");
                    stuName = menu.getValidString();
                    operation.findAndSort(studentList, stuName);
                    break;

                case 3: // Update or Delete a student by ID
                    if (! operation.isEmptyList(studentList)) {
                        operation.updateOrDeleteStudent(studentList);
                    }
                    break;

                case 4: // Get a report of all students
                    if (!operation.isEmptyList(studentList)) {
                        operation.report(studentList);
                    }
                    break;

            }
        } while (userChoice < menu.size());

    }
}
