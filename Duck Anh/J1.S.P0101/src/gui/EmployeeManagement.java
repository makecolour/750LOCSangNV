/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Employee management system> :				
 * <program allow user manage employee information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program allow user manage employee information on screen.>				
 */
package gui;

import management.EmployeeListManagement;
import management.GetUserInput;

/**
 * The class run program
 *
 * @author Tran Duc Anh
 */
public class EmployeeManagement {

    /**
     * The main method for managing employee information through a menu-driven
     * interface.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        EmployeeListManagement object = new EmployeeListManagement();
        int choice = 0;
        do {
            //show menu
            System.out.println("================================================================================================================"
                    + "\n1.Add employees "
                    + "\n2.Update employees"
                    + "\n3.Remove employees"
                    + "\n4.Search employees"
                    + "\n5.Sort employees by salary"
                    + "\n6.Exit");
            choice = GetUserInput.getInt("your choice", 1, 6);//allow user to enter choice
            switch (choice) {
                case 1:
                    object.addEmployee();//add employee 
                    break;
                case 2:
                    object.updateEmployee();//update employee
                    break;
                case 3:
                    object.removeEmployee();//remove employee
                    break;
                case 4:
                    object.searchEmployee();//search employee
                    break;
                case 5:
                    object.sortEmployee();//sort employee list
                    break;
                case 6:
                    System.exit(0);//stop program
            }
        } while (true);
    }
}
