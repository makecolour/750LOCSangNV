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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

/**
 * Most important class, perform main features
 *
 * @author quyen
 */
public class EmployeeManagement {

    Input input = new Input();
    EmployeeList el = new EmployeeList();
    private static final Logger LOG = Logger.getLogger(EmployeeManagement.class.getName());

    /**
     * Convert sex from boolean to String
     *
     * @return
     */
    private boolean sexConverter() {
        int sex;
        System.out.println("Choose sex: ");
        System.out.println("1. Male");
        System.out.println("2. Female");
        sex = input.getInt("Choose employee's sex: ", 1, 2);
        if (sex == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Find employee by ID
     *
     * @param id
     * @return
     */
    private Employee findByID(String id) {
        for (Employee e : el.getList()) {
            if (e.getId().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Find employees shares the same or a part of name
     *
     * @param query
     * @return
     */
    private ArrayList<Employee> searchByName(String query) {
        ArrayList<Employee> found = new ArrayList();
        for (Employee e : el.getList()) {
            if (e.getFirstName().toLowerCase().contains(query.toLowerCase()) || e.getLastName().toLowerCase().contains(query.toLowerCase())) {
                found.add(e);
            }
        }
        return found;
    }

    /**
     * Display a list of employee
     *
     * @param emp
     */
    private void display(ArrayList<Employee> emp) {
        System.out.println("ID                  First Name          Last Name            Phone           Email            Address          Date of Birth         Sex         Salary                    Agency");
        for (Employee e : emp) {
            String sex;
            if (e.isSex()) {
                sex = "Male";
            } else {
                sex = "Female";
            }
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", e.getId(), e.getFirstName(), e.getLastName(), e.getPhone(), e.getEmail(), e.getAddress(), e.getDob(), sex, Double.toString(e.getSalary()), e.getAgency());
        }
    }

    /**
     * Enter all of an employee's info
     *
     * @param id
     * @return
     */
    private Employee enter(String id) {
        String firstName;
        String lastName;
        String phone;
        String email;
        String address;
        String dob;
        boolean sex;
        double salary;
        String agency;
        firstName = input.getString("First name: ", "", "");
        lastName = input.getString("Last name: ", "", "");
        phone = input.getString("Phone: ", "Please enter a valid phone number", "^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$");
        email = input.getString("Email: ", "Please enter a valid email", "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        address = input.getString("Address: ", "", "");
        dob = input.getDate("Dob (dd-MM-yyy): ");
        sex = sexConverter();
        salary = input.getDouble("Salary: ");
        agency = input.getString("Agency: ", "", "");
        return new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency);
    }

    /**
     * Add new employee to list, duplicate id checked
     */
    void addEmployee() {
        String id;
        Employee emp;
        do {
            id = input.getString("Employee ID: ", "", "");
            if (findByID(id) == null) {
                break;
            }
            LOG.warning("ID is already exist");
        } while (true);
        emp = enter(id);
        el.getList().add(emp);
    }

    /**
     * Find and update employee by ID
     */
    void updateEmployee() {
        String id;
        Employee update;
        id = input.getString("Employee ID: ", "", "");
        update = findByID(id);
        if (update == null) {
            LOG.warning("Employee not found");
            return;
        } else {
            el.getList().set(el.getList().indexOf(update), enter(id));
        }
    }

    /**
     * Find and remove employee by ID
     */
    void removeEmployee() {
        String id;
        Employee remove;
        String choice;
        id = input.getString("Employee ID: ", "", "");
        remove = findByID(id);
        if (remove == null) {
            LOG.warning("Employee not found");
        } else {
            while (true) {
                choice = input.getString("Confirm deletion " + id + " Y/N: ", "", "");
                if (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y') {
                    el.getList().remove(remove);
                    System.out.println("Successful");
                    return;
                } else if (choice.charAt(0) == 'n' || choice.charAt(0) == 'N') {
                    return;
                }
            }
        }
    }

    /**
     * Search employee by name or a part of name
     */
    void searchEmployee() {
        String query = input.getString("Search: ", "", "");
        ArrayList<Employee> found = searchByName(query);
        if (found.isEmpty()) {
            LOG.warning("Employee not found");
            return;
        } else {
            display(found);
        }
    }

    /**
     * Sort and display employee list by salary
     */
    void sortEmployee() {
        ArrayList<Employee> tmp = el.getList();
        Collections.sort(tmp, Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getId));
        display(tmp);
    }
}
