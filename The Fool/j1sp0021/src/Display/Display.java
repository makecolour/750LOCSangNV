/**				
 * Copyright(C) 2023,  <FPT University>.				
 * <Student management system> :				
 * <Create a Java console program to manage students.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-10-14>      <3.7>     <MinhLD>        <Write a program to manage information of student.>				
 */
package Display;

import Manager.*;
import Entity.Student;
import java.util.ArrayList;

/**
 * This class run program and show menu on screen, allow user to choose option
 * and manage student information
 *
 * @author La Dieu Minh
 */
public class Display {

    /**
     * The main method of the program that provides a menu-driven interface for
     * managing a list of students.
     *
     */
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();
        Input ui = new Input();
        int choice;
        //Loop until user stop program
        do {
            System.out.println("=================Student Management========================\n"
                    + "1.Create\n"
                    + "2.Find and Sort\n"
                    + "3.Update/Delete\n"
                    + "4.Report\n"
                    + "5.Exit");
            choice = ui.getInt("your choice", 1, 5);
            switch (choice) {
                case 1:
                    //allow user to createStudent new student and add to the list
                    sm.createStudent();
                    break;
                case 2:
                    //allow user to find student on database and sort student list 
                    sm.findAndSort();
                    break;
                case 3:
                    sm.updateAndDelete();//allow user to update student information and delete student list 
                    break;
                case 4:
                    sm.report();//show student name and course belong to that student
                    break;
                case 5:
                    System.exit(0);//stop program
            }
        } while (true);
    }

    /**
     * display list using the provided student list
     * @param sList the array list provided
     */
    public void listDisplay(ArrayList<Student> sList){
        StudentManagement sm = new StudentManagement();
        System.out.println("=================================================================");
        System.out.println("ID             Student name      Course - Total course");
        //show student
        for (Student s : sList) {
            String courseList = sm.toCourse(s.getCourseList());
            System.out.println(s.getID() + "      " + s.getStudentName()+ courseList);
        }
    }
    
    
}
