/*							
 * Copyright(C) 2023,  FPT University.							
 * Employee management system							
 * Manage information of Employees					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-23>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of employee using List>							
 */
package j1.s.p0101;

/**
 * Main class
 *
 * @author quyen
 */
public class J1SP0101 {

    /**
     * This is main function
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Menu menu = new Menu();
        Input input = new Input();
        EmployeeManagement em = new EmployeeManagement();
        do {
            menu.display();
            int choice = input.getInt("Please choose an option", 1, 6);
            switch (choice) {
                case 1:
                    em.addEmployee();
                    break;
                case 2:
                    em.updateEmployee();
                    break;
                case 3:
                    em.removeEmployee();
                    break;
                case 4:
                    em.searchEmployee();
                    break;
                case 5:
                    em.sortEmployee();
                    break;
                case 6:
                    return;
            }
        } while (true);
    }

}
