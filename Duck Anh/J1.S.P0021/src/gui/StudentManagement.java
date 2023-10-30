/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Student management system> :				
 * <Create a Java console program to manage students.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program to manage information of student.>				
 */
package gui;

import management.StudentList;
import management.GetUserInput;

/**
 * This class run program and show menu on screen, allow user to choose option
 * and manage student information
 *
 * @author Duc Anh
 */
public class StudentManagement {

    /**
     * The main method of the program that provides a menu-driven interface for
     * managing a list of students.
     *
     * @param args The command-line arguments. It is a
     * <code>java.lang.String</code> array.
     */
    public static void main(String[] args) {
        StudentList s = new StudentList();
        int choice = 0;
        //loop until user stop program
        do {
            System.out.println("======================================================\n"
                    + "1.Create\n"
                    + "2.Find and Sort\n"
                    + "3.Update/Delete\n"
                    + "4.Report\n"
                    + "5.Exit");
            choice = GetUserInput.getInt("your choice", 1, 5);
            switch (choice) {
                case 1:
                    s.createStudent();//allow user to createStudent new student and add to the list
                    break;
                case 2:
                    s.findAndSort();//allow user to find student on database and sort student list 
                    break;
                case 3:
                    s.updateAndDelete();//allow user to update student information and delete student list 
                    break;
                case 4:
                    s.report();//show student name and course belong to that student
                    break;
                case 5:
                    System.exit(0);//stop program
            }
        } while (true);
    }

}
