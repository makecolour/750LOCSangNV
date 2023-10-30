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

import java.util.ArrayList;
import java.util.Collections;

/**
 * The class contains method add, update, remove, search, Employee information
 * from Employee table in database.
 *
 * @author Nguyen Ba Duc Minh
 */
public class EmployeeListManagement {

    private final ArrayList<Employee> employeeList;

    /**
     * Default constructor
     */
    public EmployeeListManagement() {
        this.employeeList = new ArrayList<>();
        employeeList.add(new Employee("1", "Duc", "Minh", "113", "minhd@gmail.com", "a", "2001-2-19", "Male", 312, "a"));
        employeeList.add(new Employee("2", "Lam", "Anh", "0923 091 123", "lama@gmail.com", "b", "2001-2-19", "Male", 66, "b"));
    }

    /**
     * Parameter constructor
     *
     * @param employeeList the list to set value
     */
    public EmployeeListManagement(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
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
        //input attribute from user
        newEmployee.setId(GetUserInput.getId("Id", employeeList));
        newEmployee.setFirstName(checkNormalize(GetUserInput.getString("First Name")));
        newEmployee.setLastName(checkNormalize(GetUserInput.getString("Last Name")));
        newEmployee.setPhone(GetUserInput.getPhone("Phone"));
        newEmployee.setEmail(GetUserInput.getEmail("Email"));
        newEmployee.setDob(GetUserInput.getDate("DOB"));
        newEmployee.setAgency(GetUserInput.getString("Agency"));
        newEmployee.setAddress(GetUserInput.getString("Address"));
        newEmployee.setSalary(GetUserInput.getDouble("Salary", 0, 100000));
        String sex;
        //sex
        if (GetUserInput.getSex("sex").equalsIgnoreCase("m")) {
            sex = "Male";
        } else {
            sex = "Female";
        }
        newEmployee.setSex(sex);
        //add employee
        employeeList.add(newEmployee);
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
        Employee employee;
        String inputId;
        String choose;
        do {
            if (employeeList.isEmpty()) {
                System.err.println("There is no Employee");
                break;//break out from loop;
            }
            //find Employee base on Id input from user
            inputId = GetUserInput.getString("Id to update");
            employee = findId(inputId);
            //choose Employee'attribute to update
            if (employee != null) {
                do {
                    int choice = GetUserInput.getInt("\n1.ID\n2.First Name\n3.Last Name\n4.Phone\n5.Email\n6.Address\n7.Dob\n8.Sex\n9.Salary\n10.Agency\nEnter attribute", 1, 10);
                    switch (choice) {
                        case 1:
                            employee.setId(GetUserInput.getId("new Id", employeeList));
                            break;
                        case 2:
                            employee.setFirstName(checkNormalize(GetUserInput.getString("new First Name")));
                            break;
                        case 3:
                            employee.setLastName(checkNormalize(GetUserInput.getString("new Last Name")));
                            break;
                        case 4:
                            employee.setPhone(GetUserInput.getPhone("new Phone"));
                            break;
                        case 5:
                            employee.setEmail(GetUserInput.getEmail("new Email"));
                            break;
                        case 6:
                            employee.setAddress(GetUserInput.getString("new Address"));
                            break;
                        case 7:
                            employee.setDob(GetUserInput.getDate("new DOB"));
                            break;
                        case 8:
                            employee.setSalary(GetUserInput.getDouble("new Salary", 0, 1000));
                            break;
                        case 9:
                            employee.setAgency(GetUserInput.getString("new Agency"));
                            break;
                        case 10:
                            employee.setSex(GetUserInput.getSex("new Sex"));
                            break;
                    }
                    //allow user to continue/stop updating employee
                    System.out.println("Do you want to continue updating");
                    choose = confirmYesNo();
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
        Employee employee;
        String inputId;
        //find Employee base on Id input from user
        do {
            if (employeeList.isEmpty()) {
                System.err.println("There is no Employee");//inform user that there is no available Employee
                break;
            }
            inputId = GetUserInput.getString("Id to remove");
            employee = findId(inputId);
            //if found employee confirm to remove
            if (employee != null) {
                //confirm to remove
                if (confirmYesNo().equalsIgnoreCase("Y")) {
                    employeeList.remove(employee);
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
        String inputName;
        //check if list is empty
        if (employeeList.isEmpty()) {
            System.err.println("There is no Employee");
        } else {
            //find Employee base on name or part of name input from user
            inputName = GetUserInput.getString("name to search");
            ArrayList<Employee> employee = findByName(inputName);
            //if found employee print it to screen
            if (employee != null) {
                System.out.println("Employee found");
                show(employee);
            } else {
                MyLog.getLogger().warning("name not found");
            }
        }
    }

    /**
     * Sort the list of employees by their salaries in descending order. If the
     * list is empty, a message is displayed indicating that there are no
     * employees.
     */
    public void sortEmployee() {
        if (employeeList.isEmpty()) {
            System.err.println("There is no employee");
        } else {
            //show list before sorting
            System.out.println("List before sorting");
            show(employeeList);
            Collections.sort(employeeList);
            //show list employee after sorting
            System.out.println("List after sorting");
            show(employeeList);
        }
    }

    /**
     * Find an employee by their ID.
     *
     * @param id The ID of the employee to search for.
     */
    private Employee findId(String id) {
        for (Employee employee : employeeList) {
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
     * @param confirm The initial confirmation choice, if available.
     * @return confirm
     */
    private String confirmYesNo() {
        do {
            String confirm = GetUserInput.getString("Y/N");
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
     * @param name The name to search for.
     * @return A list of Employee objects matching the name criteria or null if
     * no matches are found.
     */
    private ArrayList<Employee> findByName(String name) {
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee employee : employeeList) {
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

    /**
     * Normalize the doctor name
     *
     * @param name value to normalize
     * @return normalized name
     */
    private String checkNormalize(String name) {
        String[] Split = name.trim().split("[\\s]+");
        name = "";
        for (String a : Split) {
            name += a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase() + " ";
        }
        name = name.trim();
        return name;
    }
}
