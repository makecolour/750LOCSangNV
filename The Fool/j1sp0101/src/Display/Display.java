/*
 * Copyright(C) 2005,  FPTU.
 * EM :
 *  Employee Manager
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2023-10-18                 1.5                 MinhLD                       <General fixes>
 */
package Display;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import Manage.Employee;

/**
 * This class will be used for displaying out
 *
 * @author MinhLD
 */
public class Display {

    /**
     * Display the menu out for user to choose
     */
    public void DisplayMenu() {
        System.out.println("Main menu:");
        System.out.println("\t1. Add employees");
        System.out.println("\t2. Update employees");
        System.out.println("\t3. Remove employees");
        System.out.println("\t4. Search employees");
        System.out.println("\t5. Sort employees by salary");
        System.out.println("\t6. Display all");
        System.out.println("\t7. Exit");
    }

    /**
     * Display a certain employee
     *
     * @param EmployeeList the array list of employee that contains their details
     * @param index the employee number current on
     */
    public void DisplayElementOfList(ArrayList<Employee> EmployeeList, int index) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String DayOfBirth = dateFormat.format(EmployeeList.get(index).getDOB());
        System.out.format("%3d%10s%10s%15s%30s%20s%12s%5s%10d%10s\n",
                EmployeeList.get(index).getId(), EmployeeList.get(index).getFirstName(), EmployeeList.get(index).getLastName(),
                EmployeeList.get(index).getPhone(), EmployeeList.get(index).getEmail(), EmployeeList.get(index).getAddress(), DayOfBirth,
                EmployeeList.get(index).getSex(), EmployeeList.get(index).getSalary(), EmployeeList.get(index).getAgency());
    }

    /**
     * Display all employees
     *
     * @param EmployeeList the array containing employee details
     */
    public void DisplayAllList(ArrayList<Employee> EmployeeList) {
        System.out.println("The Employees List: ");
        System.out.format("%3s%10s%10s%15s%30s%20s%12s%5s%10s%10s\n", "Id", "First Name",
                "Last Name", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Agency");
        //loop use to access each element of arraylist from beginning to the end
        for (int i = 0; i < EmployeeList.size(); i++) {
            DisplayElementOfList(EmployeeList, i);
        }
    }
}