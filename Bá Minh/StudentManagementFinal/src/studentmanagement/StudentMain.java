/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Student management system> :				
 * <Create a Java console program to manage students.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <>        <Write a program to manage information of student.>				
 */
package studentmanagement;

/**
 * This class run program and show menu on screen, allow user to choose option
 * and manage student information
 *
 * @author 
 */
public class StudentMain {

    /**
     * The main method of the program that provides a menu-driven interface for
     * managing a list of students.
     *
     * @param args The command-line arguments. It is a
     * <code>java.lang.String</code> array.
     */
    public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        int choice;
        //Loop until user stop program
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
                    studentManagement.createStudent();//allow user to createStudent new student and add to the list
                    break;
                case 2:
                    studentManagement.findAndSort();//allow user to find student on database and sort student list 
                    break;
                case 3:
                    studentManagement.updateAndDelete();//allow user to update student information and delete student list 
                    break;
                case 4:
                    studentManagement.report();//show student name and course belong to that student
                    break;
                case 5:
                    System.exit(0);//stop program
            }
        } while (true);
    }

}
