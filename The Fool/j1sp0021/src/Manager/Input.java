/**				
 * Copyright(C) 2023,  <FPT University>.				
 * <Student management system> :				
 * <Create a Java console program to manage students.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <3.4>     <MinhLD>        <Write a program to manage information of student.>
 */
package Manager;

import Display.LoggerOut;
import Entity.Course;

import java.util.Scanner;

/**
 * This class contain methods to validate user's input and methods to get user input
 *
 * @author La Dieu Minh
 */
public class Input {

    private final Scanner sc = new Scanner(System.in);
    private final LoggerOut lo = new LoggerOut();
    private final String className = Input.class.getName();

    /**
     * Prompt the user for a string input with a specified message and return
     * the entered string. The method ensures that the input is not empty.
     *
     * @param msg The message to display when prompting for input
     * @return The user-entered string, trimmed of leading and trailing spaces
     */
    public String getString(String msg) {
        //loop until user input correct
        String text;
        do {
            System.out.print("Enter " + msg + ": ");
            try {
                text = sc.nextLine().trim();
                //check if input is empty
                if (!text.isEmpty()) {
                    return text.trim();
                } else {
                    System.err.println("Input can not be empty");
                }
            } catch (Exception e) {
                lo.Log(className, "Error " + msg + ", " + e);
            }
        } while (true);
    }

    /**
     * Prompt the user for an integer input within a specified range and return
     * the entered integer. The method ensures that the input is within the
     * valid range.
     *
     * @param msg The message to display when prompting for input
     * @param min The minimum allowed value for the input (inclusive)
     * @param max The maximum allowed value for the input (inclusive)
     * @return The user-entered integer within the specified range.
     */
    public int getInt(String msg, int min, int max) {
        int choice;
        //check user input string
        do {
            try {
                choice = Integer.parseInt(getString(msg));
                //check if input in valid range
                if (choice >= min && choice <= max) {
                    
                    return choice;
                } else {
                    lo.Log(className, "Out of range");
                }
            } catch (Exception e) {
                lo.Log(className, "Error " + msg + ", " + e);
            }
        } while (true);
    }

    /**
     * Prompt the user for a unique ID input that does not exist in the provided
     * list of students. The method ensures that the entered ID is not empty and
     * is not a duplicate in the list.
     *
     * @param msg The message to display when prompting for input
     * @return The user-entered unique ID, trimmed of leading and trailing spaces
     */
    public String getId(String msg) {
        StudentManagement sm = new StudentManagement();
        String id;
        do {
            try {
                id = getString(msg);
                //check if id is existed and not empty
                if (!sm.checkDuplicateId(id) && !id.isEmpty()) {
                    if (id.matches("^[a-zA-Z]{2}\\d{6}$"))
                    return id.trim().toUpperCase();
                }
            } catch (Exception e) {
                lo.Log(className, "Error " + msg + ", " + e);
            }
        } while (true);
    }

    /**
     * Allow user to select the semester
     *
     * @return a semester
     */
    public String getSemester() {
        String semester = null;
        int choice = getInt("Semester (1.Spring |2.Summer |3.Fall)", 1, 3);
        switch (choice) {
            case 1:
                semester = "Spring";
                break;
            case 2:
                semester = "Summer";
                break;
            case 3:
                semester = "Fall";
                break;
        }

        return semester;
    }

    /**
     * Allow the user to select and specify the number of courses from a
     * predefined list. The method creates an array of courses and initializes
     * it with course names and zeros for the number of courses. The user can
     * increment the number of each selected course. The method returns an array
     * of courses with the selected courses and their respective counts.
     *
     * @param courseList The list of course of a student
     * @return An array of courses with selected courses and their counts
     */
    public Course[] getCourse(Course[] courseList) {
        String confirm;
        int choice;
        Course[] cList = new Course[3];
        //create course list read to store user input course
        cList[0] = new Course("Java", 0);
        cList[1] = new Course(".Net", 0);
        cList[2] = new Course("C/C++", 0);
        do {
            //loop until user stop enter new course
            choice = getInt("course name (1.Java |2.Net |3.C/C++)", 1, 3);
            switch (choice) {
                //set number of each course of a student
                case 1:
                    cList[0].setCourseNumber(cList[0].getCourseNumber() + 1);
                    break;
                case 2:
                    cList[1].setCourseNumber(cList[1].getCourseNumber() + 1);
                    break;
                case 3:
                    cList[2].setCourseNumber(cList[2].getCourseNumber() + 1);
                    break;
            }
            System.out.println("Do you want to add more course");
            confirm = confirm("Y", "N");
        } while (!confirm.equalsIgnoreCase("N"));

        //Course[] courseList = new Course[3];
        //loop to put user input course to return 
        for (int i = 0; i < 3; i++) {
            if (cList[i].getCourseNumber() != 0) {
                cList[i].setCourseNumber(cList[i].getCourseNumber() + courseList[i].getCourseNumber());
                courseList[i] = cList[i];
            }
        }
        return courseList;
    }

    /**
     * Prompt the user for confirmation with two valid choices (a and b) and
     * return the selected choice. The method ensures that the user enters
     * either option "a" or "b" (case-insensitive).
     *
     * @param a The first valid choice for confirmation
     * @param b The second valid choice for confirmation
     * @return The user-selected confirmation choice ("a" or "b").
     */
    public String confirm(String a, String b) {
        Input ui = new Input();
        String confirm;
        do {
            confirm = ui.getString(a + "/" + b);
            //check valid choice
            if (confirm.equalsIgnoreCase(a) || confirm.equalsIgnoreCase(b)) {
                return confirm;
            } else {
                lo.Log(className, "Please enter Y/N:");
            }
        } while (true);
    }
}
