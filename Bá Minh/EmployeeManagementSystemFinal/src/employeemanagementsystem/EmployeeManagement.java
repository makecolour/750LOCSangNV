/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Employee management system> :				
 * <program allow user manage employee information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <MinhNBD>        <Write a program allow user manage employee information on screen.>				
 */
package employeemanagementsystem;

/**
 * The class run program
 *
 * @author Nguyen Ba Duc Minh
 */
public class EmployeeManagement {

    /**
     * The main method for managing employee information through a menu-driven
     * interface.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        EmployeeListManagement employeeListManagement = new EmployeeListManagement();
        int choice;
        do {
            //show menu
            System.out.println("================================================================================================================"
                    + "\n1.Add employees "
                    + "\n2.Update employees"
                    + "\n3.Remove employees"
                    + "\n4.Search employees"
                    + "\n5.Sort employees by salary"
                    + "\n6.Exit");
            choice = GetUserInput.getInt("your choice", 1, 6);
            switch (choice) {
                case 1:
                    employeeListManagement.addEmployee();
                    break;
                case 2:
                    employeeListManagement.updateEmployee();
                    break;
                case 3:
                    employeeListManagement.removeEmployee();
                    break;
                case 4:
                    employeeListManagement.searchEmployee();
                    break;
                case 5:
                    employeeListManagement.sortEmployee();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }
}
