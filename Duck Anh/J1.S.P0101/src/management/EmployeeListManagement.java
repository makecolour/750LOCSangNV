/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Employee management system> :				
 * <program allow user manage employee information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program allow user manage employee information on screen.>				
 */
package management;

import java.util.ArrayList;
import java.util.logging.Logger;
import entity.Employee;
import java.util.Collections;

/**
 * The class contains method add, update, remove, search, Employee information
 * from Employee table in database. All data will be normalized (trim space)
 * before update/add into database The method will throw an object of
 * <code>java.lang.Exception</code> class if there is any error occurring when
 * searching, adding, or updating data
 *
 * @author Tran Duc Anh
 */
public class EmployeeListManagement {

    private Logger logger = Logger.getLogger(EmployeeListManagement.class.getName());
    private ArrayList<Employee> eList;

    public EmployeeListManagement() {
        this.eList = new ArrayList<Employee>();
        eList.add(new Employee("1", "Duc", "Huy", "113", "huyd@gmail.com", "a", "2001-2-19", "Male", 312, "a"));
        eList.add(new Employee("2", "Anh", "Minh", "0923 091 123", "AnhMinh@yahoo.com", "b", "2001-2-19", "Male", 66, "b"));
        eList.add(new Employee("3", "Anh", "Quan", "3232 342 234", "AnhQuan@fpt.edu.vn", "c", "2043-12-1", "Male", 970, "c"));
        eList.add(new Employee("4", "Minh", "Duc", "8731 018 229", "MinhDuc@gmail.com", "d", "2001-4-9", "Female", 4542, "d"));
    }

    public EmployeeListManagement(ArrayList<Employee> eList) {
        this.eList = eList;
    }

    /**
     * Add a new employee to the employee list. The method prompts the user to
     * input various employee details, such as ID, first name, last name, phone,
     * email, date of birth (DOB), agency, address, salary, and sex. After
     * collecting the details, the new employee is added to the list.
     *
     */
    public void addEmployee() {
        Employee newEmployee = new Employee();
        String text = null;
        //input attribute from user
        newEmployee.setId(GetUserInput.getId("Id", eList));
        newEmployee.setFirstName(GetUserInput.getString("First Name", text));
        newEmployee.setLastName(GetUserInput.getString("Last Name", text));
        newEmployee.setPhone(GetUserInput.getPhone("Phone", text));
        newEmployee.setEmail(GetUserInput.getEmail("Email", text));
        newEmployee.setDob(GetUserInput.getDate("DOB", text));
        newEmployee.setAgency(GetUserInput.getString("Agency", text));
        newEmployee.setAddress(GetUserInput.getString("Address", text));
        newEmployee.setSalary(GetUserInput.getDouble("Salary", 0, 100000));
        String sex = null;
        //sex
        if (GetUserInput.getSex("sex", sex).equalsIgnoreCase("m")) {
            sex = "Male";
        } else {
            sex = "Female";
        }
        newEmployee.setSex(sex);
        //add employee
        eList.add(newEmployee);
        System.err.println("Employee has been added");
    }

    /**
     * Update employee information based on the user's input. The method first
     * prompts the user to input an employee's ID to locate the employee to be
     * updated. After updating the chosen attributes, the user has the option to
     * continue updating or stop the update. The method ensures that the input
     * is within the valid range and handles potential errors.
     */
    public void updateEmployee() {
        Employee employee = new Employee();
        String inputId = null;
        String choose = null;
        String text = null;
        do {
            if (eList.isEmpty()) {
                System.err.println("There is no Employee");
                break;//break out from loop;
            }
            //find Employee base on Id input from user
            inputId = GetUserInput.getString("Id to update", inputId);
            employee = findId(inputId);
            //choose Employee'attribute to update
            if (employee != null) {
                do {
                    int choice = GetUserInput.getInt("\n1.ID\n2.First Name\n3.Last Name\n4.Phone\n5.Email\n6.Address\n7.Dob\n8.Sex\n9.Salary\n10.Agency\nEnter attribute", 1, 10);
                    switch (choice) {
                        case 1:
                            employee.setId(GetUserInput.getId("new Id", eList));
                            break;
                        case 2:
                            employee.setFirstName(GetUserInput.getString("new First Name", text));
                            break;
                        case 3:
                            employee.setLastName(GetUserInput.getString("new Last Name", text));
                            break;
                        case 4:
                            employee.setPhone(GetUserInput.getPhone("new Phone", text));
                            break;
                        case 5:
                            employee.setEmail(GetUserInput.getEmail("new Email", text));
                            break;
                        case 6:
                            employee.setAddress(GetUserInput.getString("new Address", text));
                            break;
                        case 7:
                            employee.setDob(GetUserInput.getDate("new DOB", text));
                            break;
                        case 8:
                            employee.setSalary(GetUserInput.getDouble("new Salary", 0, 1000));
                            break;
                        case 9:
                            employee.setAgency(GetUserInput.getString("new Agency", text));
                            break;
                        case 10:
                            employee.setSex(GetUserInput.getSex("new Sex", text));
                            break;
                    }
                    //allow user to continue/stop updating employee
                    System.out.println("Do you want to continue updating");
                    choose = confirmYesNo(choose);
                    //check if user input n/N to stop updating
                    if (choose.equalsIgnoreCase("n")) {
                        System.err.println("This employee has been updated ");
                        break;//if user enter n/N program will stop updating
                    }
                } while (choose.equalsIgnoreCase("y"));
                break;
            } else {
                System.err.println("Id not found");
            }
        } while (true);
    }

    /**
     * Remove an employee from the employee list based on the user's input of
     * the employee's ID. The method first verifies if the employee list is
     * empty and informs the user if there are no employees. It then prompts the
     * user to input the ID of the employee to be removed. If the employee is
     * found, the method asks for confirmation before removing the employee. If
     * confirmed, the employee is removed from the list; otherwise, the removal
     * process is stopped.
     */
    public void removeEmployee() {
        Employee employee = new Employee();
        String inputId = null;
        String confirm = null;
        //find Employee base on Id input from user
        do {
            if (eList.isEmpty()) {
                System.err.println("There is no Employee");//inform user that there is no available Employee
                break;
            }
            inputId = GetUserInput.getString("Id to remove", inputId);
            employee = findId(inputId);
            //if found employee confirm to remove
            if (employee != null) {
                //confirm to remove
                if (confirmYesNo(confirm).equalsIgnoreCase("Y")) {
                    eList.remove(employee);
                    System.out.println("This employee has been removed");
                    break;
                } else {
                    break;//stop remove 
                }
            } else {
                System.out.println("Id not found");
            }
        } while (true);

    }

    /**
     * Search for employees by name or part of a name provided by the user. If
     * matching employees are found, they are displayed on the screen. If the
     * employee list is empty, a message indicating no employees are present is
     * shown. If no matching employees are found, a warning message is logged.
     */
    public void searchEmployee() {
        String inputName = null;
        //check if list is empty
        if (eList.isEmpty()) {
            System.err.println("There is no Employee");
        } else {
            //find Employee base on name or part of name input from user
            inputName = GetUserInput.getString("name to search", inputName);
            ArrayList<Employee> employee = findByName(inputName);
            //if found employee print it to screen
            if (employee != null) {
                System.out.println("Employee found");
                show(employee);
            } else {
                logger.warning("name not found");
            }
        }
    }

    /**
     * Sort the list of employees by their salaries in descending order. If the
     * list is empty, a message is displayed indicating that there are no
     * employees.
     */
    public void sortEmployee() {
        if (eList.isEmpty()) {
            System.err.println("There is no employee");
        } else {
            //show list before sorting
            System.out.println("List before sorting");
            show(eList);
            Collections.sort(eList);
            //show list employee after sorting
            System.out.println("List after sorting");
            show(eList);
        }
    }

    /**
     * Find an employee by their ID.
     *
     * @param id The ID of the employee to search for. It is a
     * <code>java.lang.String</code> object.
     * @return The Employee object with the specified ID or null if no match is
     * found.
     */
    private Employee findId(String id) {
        for (Employee employee : eList) {
            if (id.equalsIgnoreCase(employee.getId())) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Prompt the user for a confirmation input (Y/N) and return the confirmed
     * choice.
     *
     * @param confirm The initial confirmation choice, if available. It is a
     * <code>java.lang.String</code> object.
     * @return The confirmed choice as a string, which will be either "Y" or
     * "N".
     */
    private String confirmYesNo(String confirm) {
        do {
            confirm = GetUserInput.getString("Y/N", confirm);
            if (confirm.equalsIgnoreCase("Y") || confirm.equalsIgnoreCase("N")) {
                return confirm;
            } else {
                System.out.println("Error");
            }
        } while (true);
    }

    /**
     * Find employees by their first name or last name that matches the
     * specified name (case-insensitive). Returns a list of Employee objects
     * matching the name criteria.
     *
     * @param name The name to search for. It is a <code>java.lang.String</code>
     * object.
     * @return A list of Employee objects matching the name criteria or null if
     * no matches are found.
     */
    private ArrayList<Employee> findByName(String name) {
        ArrayList<Employee> list = new ArrayList<Employee>();
        for (Employee employee : eList) {
            if (employee.getFirstName().toLowerCase().contains(name.toLowerCase()) || employee.getLastName().toLowerCase().contains(name.toLowerCase())) {
                list.add(employee);
            }
        }
        //check if employee list is empty
        if (list.isEmpty() == true) {
            return null;
        } else {
            return list;
        }
    }

    /**
     * Display a list of employee information in format below.
     *
     * @param list The ArrayList of Employee objects to display.
     */
    private void show(ArrayList<Employee> list) {
        System.out.println("| ID | FIRST NAME | LAST NAME |     PHONE    |         EMAIL        | ADDRESS |     DOB    |   SEX  |   SALARY   | AGENCY |");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}
