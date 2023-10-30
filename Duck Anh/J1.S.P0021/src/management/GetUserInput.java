/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Student management system> :				
 * <Create a Java console program to manage students.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program to manage information of student.>				
 */
package management;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Course;
import entity.Student;

/**
 * This class contain methods to validate user's input such as
 * validateString.... and methods to get input's
 * user.<code>java.lang.Exception</code> class if there is any error occurring
 * when receive wrong input from user
 *
 * @author Duc Anh
 */
public class GetUserInput {

    private static Scanner sc = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(GetUserInput.class.getName());

    /**
     * Prompt the user for a string input with a specified message and return
     * the entered string. The method ensures that the input is not empty.
     *
     * @param msg The message to display when prompting for input. It is a
     * <code>java.lang.String</code> object.
     * @param text The initial text input, if available. It is a
     * <code>java.lang.String</code> object.
     * @return The user-entered string, trimmed of leading and trailing spaces.
     * It is a <code>java.lang.String</code> object.
     */
    public static String getString(String msg, String text) {
        //loop until user input correct
        do {
            System.out.print("Enter " + msg + ": ");
            try {
                text = sc.nextLine().trim();
                //check if input is empty
                if (text.isEmpty() == false) {
                    return text.trim();
                } else {
                    System.err.println("Input can not be empty");
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);
    }

    /**
     * Prompt the user for an integer input within a specified range and return
     * the entered integer. The method ensures that the input is within the
     * valid range.
     *
     * @param msg The message to display when prompting for input. It is a
     * <code>java.lang.String</code> object.
     * @param min The minimum allowed value for the input (inclusive). It is an
     * <code>int</code>.
     * @param max The maximum allowed value for the input (inclusive). It is an
     * <code>int</code>.
     * @return The user-entered integer within the specified range.
     */
    public static int getInt(String msg, int min, int max) {
        int choice = 0;
        //check user input string
        do {
            try {
                System.out.print("Enter " + msg + ": ");
                choice = Integer.parseInt(sc.nextLine().trim());
                //check if input in valid range
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.err.println("Out of range");
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);
    }

    /**
     * Prompt the user for a unique ID input that does not exist in the provided
     * list of students. The method ensures that the entered ID is not empty and
     * is not a duplicate in the list.
     *
     * @param msg The message to display when prompting for input. It is a
     * <code>java.lang.String</code> object.
     * @param list The list of students to check for duplicate IDs. It is an
     * <code>java.util.ArrayList</code> of <code>vn.co.fu.bean.Student</code>
     * objects.
     * @return The user-entered unique ID, trimmed of leading and trailing
     * spaces. It is a <code>java.lang.String</code> object.
     */
    public static String getId(String msg, ArrayList<Student> list) {
        String id = null;
        do {
            try {
                id = getString(msg, "");
                //check if id is existed and not empty
                if (checkDuplicateId(list, id) == false && id.isEmpty() == false) {
                    return id.trim();
                }
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error " + msg, e);
            }
        } while (true);
    }

    /**
     * Check if a given ID already exists in the list of students.
     *
     * @param list The list of students to check for duplicate IDs. It is an
     * <code>java.util.ArrayList</code> of <code>vn.co.fu.bean.Student</code>
     * objects.
     * @param inputId The ID to check for duplication. It is a
     * <code>java.lang.String</code> object.
     * @return <code>true</code> if the ID is found in the list, indicating
     * duplication; <code>false</code> otherwise.
     */
    private static boolean checkDuplicateId(ArrayList<Student> list, String inputId) {
        //lood to check duplicated id
        for (Student o : list) {
            //check if id input from user existed
            if (inputId.equalsIgnoreCase(o.getId())) {
                System.err.println("Id already existed");
                return true;
            }
        }
        return false;
    }

    /**
     * Allow the user to select and specify the number of courses from a
     * predefined list. The method creates an array of courses and initializes
     * it with course names and zeros for the number of courses. The user can
     * increment the number of each selected course. The method returns an array
     * of courses with the selected courses and their respective counts.
     *
     * @param courseList The array of course objects to populate with
     * user-selected courses and counts. It is a
     * <code>vn.co.fu.bean.Course[]</code> array.
     * @return An array of courses with selected courses and their counts. It is
     * a <code>vn.co.fu.bean.Course[]</code> array.
     */
    public static Course[] getCourse(Course[] courseList) {
        String confirm = null;
        int choice = 0;
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
            confirm = confirmYesNo(confirm, "Y", "N");
            if (confirm.equalsIgnoreCase("N")) {
                break;
            }
        } while (true);

        courseList = new Course[3];
        //loop to put user input course to return 
        for (int i = 0; i < 3; i++) {
            if (cList[i].getCourseNumber() != 0) {
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
     * @param confirm The confirmation choice entered by the user. It is a
     * <code>java.lang.String</code> object.
     * @param a The first valid choice for confirmation. It is a
     * <code>java.lang.String</code> object.
     * @param b The second valid choice for confirmation. It is a
     * <code>java.lang.String</code> object.
     * @return The user-selected confirmation choice ("a" or "b").
     */
    public static String confirmYesNo(String confirm, String a, String b) {
        do {
            confirm = GetUserInput.getString(a + "/" + b, confirm);
            //check valid choice
            if (confirm.equalsIgnoreCase(a) || confirm.equalsIgnoreCase(b)) {
                return confirm;
            } else {
                System.err.println("Error " + confirm);
            }
        } while (true);
    }
}
