/*
 * Copyright(C) 2005,  FPTU.
 * EM :
 *  Employee Manager
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2023-10-18                 1.5                 MinhLD                       <General fixes>
 */
package Manage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

import Main.Input;
import Display.Display;
import Display.ErrorLogger;

/**
 * This class is the main management method that will not only change or edit an employee
 *
 * @author MinhLD
 */
public class EmployeeManagement {

    private final Input input = new Input();
    private final Display display = new Display();
    private final ErrorLogger erl = new ErrorLogger();
    private final String className = EmployeeManagement.class.getName();

    /**
     * check for id duplication
     *
     * @param Id the id that is being currently being checked
     * @param EmployeeList the employee list that contains details (currently checking for ID)
     * @return boolean T/F depending on the cases of duplication or not
     */
    private boolean checkIdExist(int Id, ArrayList<Employee> EmployeeList) {
        if (EmployeeList.isEmpty()) {
            return false;
        } else {
            //loop use to access each element of arraylist from beginning to the end
            for (Employee employee : EmployeeList) {
                //Compare ID input and each id of employee has in list
                if (employee.getId() == Id) {
                    System.out.println("Id has been existed!!!");
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * add the employee to the arraylist
     *
     * @param EmployeeList The employee list currently being used to add more in
     */
    public void addEmployee(ArrayList<Employee> EmployeeList) {
        int Id;
        if (EmployeeList.isEmpty()) {
            erl.Log(className, "List is Empty!!");
        } else {
            display.DisplayAllList(EmployeeList);
        }
        do {
            Id = input.getInteger("Enter employee's id: ", 1, Integer.MAX_VALUE);
            //check value of variable isExist
            if (!checkIdExist(Id, EmployeeList)) {
                break;
            }
        } while (true);
        String FirstName = input.getString("Enter employee's first name: ", "");
        String LastName = input.getString("Enter employee's last name: ", "");
        /*
        ^0: 0 must be is the first digit of phone number
        [9843]{1}: choose 1 number in [9843]
        \d{8}: a string need 9 number
        $: point the end of the line
         */
        String Phone = input.getString("Enter employee's phone number: ", "^0[9843]{1}\\d{8}$");
        /*
        ^: access position start of line
        [a-zA-Z0-9]: match all character begin lower case to uppercase form a to z and digit in 0 to 9
        +: check unlimited times impossible
        @: a string must have character @
        \.:match character .
        [a-zA-Z]{2,6}:match character in set from 2 to 6 times
        |: Boolean OR for 2 case email
        *: check all previous token unlimited times
        $: point the end of line
         */
        String Email = input.getString("Enter employee's email: ",
                "^[a-zA-Z0-9]+@([a-z]{2,6}\\.[a-z]{2,6}|[a-z]{2,6}\\.[a-z]{2,6}\\.[a-z]{2,6})*$");
        String Address = input.getString("Enter employee's address: ", "");
        Date DOB;
        do {
            DOB = input.getDate("Enter employee birthday[dd/MM/yyyy]: ");
            Date now = new Date();
            if (DOB.before(now)) {
                break;
            } else {
                System.out.println("Birthday must before today!");
                continue;
            }
        } while (true);
        //[FM]: allow input is F or M
        String sex = input.getString("Enter employee's gender[F: female; M: male]: ", "[FM]|[fm]");
        int Salary = input.getInteger("Enter employee salary: ", 0, Integer.MAX_VALUE);
        String Agency = input.getString("Enter employee agency: ", "");
        Employee employee = new Employee(Id, FirstName, LastName, Phone, Email, Address, DOB, sex, Salary, Agency);
        EmployeeList.add(employee);
    }

    /**
     * search for an employee using ID
     *
     * @param EmployeeList list of employee
     * @param id id being used for searching
     * @return person currently being searched
     */
    public int SearchbyID(ArrayList<Employee> EmployeeList, int id) {
        int pos = -1;
        if (EmployeeList.isEmpty()) {
            erl.Log(className, "List is Empty!!");
        } else {
            //loop use to access each element of arraylist from beginning to the end
            for (Employee employee : EmployeeList) {
                //Compare id input and each id of employee has in list
                if (id == employee.getId()) {
                    pos = EmployeeList.indexOf(employee);
                    break;
                }
            }
        }
        return pos;
    }

    /**
     * update the current employee
     *
     * @param EmployeeList current employee list
     */
    public void updateEmployee(ArrayList<Employee> EmployeeList) {
        int id;
        int pos;
        do {
            display.DisplayAllList(EmployeeList);
            id = input.getInteger("Enter id employee: ", 0, Integer.MAX_VALUE);
            pos = SearchbyID(EmployeeList, id);
            //compare pos with -1
            if (pos == -1) {
                erl.Log(className, "Can't not find employee please enter again!");
                continue;
            } else {
                break;
            }
        } while (true);

        do {
            System.out.println("Choose update option:");
            System.out.println("1: Update first name of employee.");
            System.out.println("2: Update lastname of employee.");
            System.out.println("3: Update phone number of employee.");
            System.out.println("4: Update email of employee.");
            System.out.println("5: Update address of employee.");
            System.out.println("6: Update birthday of employee.");
            System.out.println("7: Udate gender of employee.");
            System.out.println("8: Update salary of employee.");
            System.out.println("9: Update agency of employee.");
            System.out.println("10: Update Id of emloyee.");
            int choice = input.getInteger("Let's select option: ", 1, 10);
            switch (choice) {
                case 1:
                    
                    EmployeeList.get(pos).setFirstName(input.getString("Enter employee's first name: ", ""));
                    break;
                case 2:
                    
                    EmployeeList.get(pos).setLastName(input.getString("Enter employee's last name: ", ""));
                    break;
                case 3:
                    /*
                    ^0: 0 must be is the first digit of phone number
                    [9843]{1}: choose 1 number in [9843]
                    \d{8}: a string need 9 number
                    $: point the end of the line
                     */
                    
                    EmployeeList.get(pos).setPhone(input.getString("Enter employee's phone number: ", "^0[9843]{1}\\d{8}$"));
                    break;
                case 4:
                    /*
                    ^: access position start of line
                    [a-zA-Z0-9]: match all character begin lower case to uppercase form a to z and digit in 0 to 9
                    +: check unlimited times impossible
                    @: a string must have character @
                    \.:match character .
                    [a-zA-Z]{2,6}:match character in set from 2 to 6 times
                    |: Boolean OR for 2 case email
                    *: check all previous token unlimited times
                    $: point the end of line
                    */
                    
                    EmployeeList.get(pos).setEmail(input.getString("Enter employee's email: ",
                            "^[a-zA-Z0-9]+@([a-z]{2,6}\\.[a-z]{2,6}|[a-z]{2,6}\\.[a-z]{2,6}\\.[a-z]{2,6})*$"));
                    break;
                case 5:
                    
                    EmployeeList.get(pos).setAddress(input.getString("Enter employee's address: ", ""));
                    break;
                case 6:
                    Date DOB;
                    do {
                        DOB = input.getDate("Enter employee birthday[dd/MM/yyyy]: ");
                        Date now = new Date();
                        if (DOB.before(now)) {
                            break;
                        } else {
                            System.out.println("Birthday must before today!");
                            continue;
                        }
                    } while (true);
                    EmployeeList.get(pos).setDOB(DOB);
                    break;
                case 7:
                    //[FM]: accept input is F or M
                    
                    EmployeeList.get(pos).setSex(input.getString("Enter employee's gender[F: female; M: male]: ", "[FM]|[fm]"));
                    break;
                case 8:
                    
                    EmployeeList.get(pos).setSalary(input.getInteger("Enter employee salary: ", 0, Integer.MAX_VALUE));
                    break;
                case 9:
                    
                    EmployeeList.get(pos).setAgency(input.getString("Enter employee agency: ", ""));
                    break;
                case 10:
                    int Id;
                    do {
                        Id = input.getInteger("Enter employee's id: ", 1, Integer.MAX_VALUE);
                        boolean isExist = checkIdExist(Id, EmployeeList);
                        //check value of variable isExist
                        if (!isExist){
                            break;
                        }
                    } while (true);
                    EmployeeList.get(pos).setId(Id);
                    break;
            }
            display.DisplayAllList(EmployeeList);
            //[yn]: accept input must be y or n
            String answer = input.getString("Do you want to continue? y|n: ", "[yn]");
            //compare value of answer with string "n"
            if (answer.equals("n")) {
                break;
            } else {
                continue;
            }
        } while (true);
    }

    /**
     * remove the employee from list
     *
     * @param EmployeeList the current employee list
     */
    public void removedEmployee(ArrayList<Employee> EmployeeList) {
        display.DisplayAllList(EmployeeList);
        int id;
        int pos;
        do {
            id = input.getInteger("Enter id employee: ", 0, Integer.MAX_VALUE);
            pos = SearchbyID(EmployeeList, id);
            //compare pos with -1
            if (pos == -1) {
                erl.Log(className, "Can't not find employee please enter again!");
                continue;
            } else {
                break;
            }
        } while (true);
        EmployeeList.remove(pos);
        display.DisplayAllList(EmployeeList);
    }

    /**
     * search for an employee
     *
     * @param EmployeeList the current employee list
     */
    public void Search(ArrayList<Employee> EmployeeList) {
        String NameforSearch = input.getString("Enter employee name to find: ", "");
        int pos = -1;
        int count = 0;
        System.out.println("Result of Search: ");
        //loop use to access each element of arraylist from beginning to the end
        for (int i = 0; i < EmployeeList.size(); i++) {
            String fullname = EmployeeList.get(i).getFirstName() + " " + EmployeeList.get(i).getLastName();
            //check string full name contains or not input name from user
            if (fullname.contains(NameforSearch)) {
                pos = i;
                //compare variable pos with -1
                if (pos != -1) {
                    count++;
                }
            }
        }

        //check value of variable count
        if (count == 0) {
            erl.Log(className, "Can't not find employee please enter again!");
        } else {
            System.out.format("%3s%10s%10s%15s%30s%20s%12s%5s%10s%10s\n", "Id", "First Name",
                    "Last Name", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Agency");
        }
        for (int i = 0; i < EmployeeList.size(); i++) {
            String fullname = EmployeeList.get(i).getFirstName() + " " + EmployeeList.get(i).getLastName();
            //check string fullname contains or not input name from user
            if (fullname.contains(NameforSearch)) {
                pos = i;
                //compare variable pos with -1
                if (pos != -1) {
                    display.DisplayElementOfList(EmployeeList, pos);
                }
            }
        }
    }

    /**
     * sort the list by the amount of salary a person has
     *
     * @param EmployeeList the current employee list
     */
    public void SortBySalary(ArrayList<Employee> EmployeeList) {
        EmployeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                // Salary is equal - sort using ID
                if (o2.getSalary() == o1.getSalary()) {
                    return o1.getId() - o2.getId();
                }
                //Salaray is differents - sort using salary
                return o1.getSalary() - o2.getSalary();
            }
        });
        display.DisplayAllList(EmployeeList);
    }
}
