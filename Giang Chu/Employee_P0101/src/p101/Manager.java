/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Employee management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package p101;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author macbook
 */
public class Manager {

    private final static ArrayList<Employee> empList = new ArrayList<>();
    private final static Scan sc = new Scan();
    private final static Logger logger = Logger.getLogger(Manager.class.getName());

    /**
     * add new employee
     */
    public void addNewEmployee() {
        String id = addID();
        String firstName = sc.nextLine("Enter firstname: ");
        String lastName = sc.nextLine("Enter lastname: ");
        String email = addEmail();
        String address = sc.nextLine("Enter address: ");
        String sex = sc.nextLine("Enter sex: ");
        String agency = sc.nextLine("Enter agency: ");
        String phone = addPhone();
        String date = addDate();
        double salary = addSalary();
        empList.add(new Employee(id, checkNormalize(firstName), checkNormalize(lastName), email, address, sex, agency, phone, date, salary));
        System.err.println("Add successful");
    }
    /**
     * 
     * @return 
     */
    public double addSalary() {
        double salary;
        do {
            salary = sc.nextDouble("Enter salary: ");
            if (salary < 0) {
                System.out.println("Salary must bigger than 0!");
            }
        } while (salary < 0);
        return salary;
    }

    /**
     * check is day of birth is right format
     *
     * @param date
     * @return boolean if dob is valid
     */
    public boolean checkDate(String date) {
        Calendar c = Calendar.getInstance();
        String temp[] = date.split("-");
        int yearLimit = c.get(Calendar.YEAR);
        int day = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int year = Integer.parseInt(temp[2]);

        if (checkLeapYear(year)) {
            if (year > yearLimit) {
                return false;
            } else if (month > 12) {
                return false;
            } else {
                if (month == 2 && (day < 1 || day > 29)) {
                    return false;
                } else {
                    if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day < 1 || day > 31)) {
                        return false;
                    } else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {
                        return false;
                    } else if (!checkAge(date)) {
                        return false;
                    }
                }
            }
        } else if (!checkLeapYear(year)) {
            if (year > yearLimit) {
                return false;
            } else if (month > 12) {
                return false;
            } else {
                if (month == 2 && (day < 1 || day > 28)) {
                    return false;
                } else {
                    if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day < 1 || day > 31)) {
                        return false;
                    } else if ((month == 4 || month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)) {
                        return false;
                    } else if (!checkAge(date)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * check 18 year old or not
     *
     * @param date
     * @return
     */
    public boolean checkAge(String date) {
        Calendar c = Calendar.getInstance();
        String temp[] = date.split("-");
        int dayLimit = c.get(Calendar.DAY_OF_MONTH);
        int monthLimit = c.get(Calendar.MONTH) + 1;
        int yearLimit = c.get(Calendar.YEAR);
        int day = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int year = Integer.parseInt(temp[2]);

        if (yearLimit - year < 18) {
            return false;
        } else if (yearLimit - year == 18) {
            if (month > monthLimit) {
                return false;
            } else if (month == monthLimit) {
                if (day > dayLimit) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check leap year
     *
     * @param year
     * @return boolean value
     */
    public boolean checkLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }

    /**
     * check phone length
     *
     * @param phone
     * @return boolean value
     */
    public boolean checkPhoneLenght(String phone) {
        if (phone.length() == 10) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param id
     * @return indext of the employee in the list
     */
    public int findEmployeeByID(String id) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param inform
     * @return String inform after normalize
     */
    public String checkNormalize(String inform) {
        String[] word = inform.split(" ");
        String result = "";
        for (String data : word) {
            result += data.substring(0, 1).toUpperCase() + data.substring(1).toLowerCase() +" ";
        }
        return result;
    }

    /**
     * Allow user to update a employee
     */
    public void updateEmployee() {
        String id = getEmpID();
        int index = findEmployeeByID(id);
        empList.get(index).setAddress(id);
        empList.get(index).setLastName(sc.nextLine("Enter first name: "));
        empList.get(index).setFirstName(sc.nextLine("Enter last name: "));
        empList.get(index).setAddress(sc.nextLine("Enter address: "));
        empList.get(index).setAgency(sc.nextLine("Enter agency: "));
        empList.get(index).setSex(sc.nextLine("Enter sex: "));
        empList.get(index).setEmail(addEmail());
        empList.get(index).setPhone(addPhone());
        empList.get(index).setDOB(addDate());
        empList.get(index).setSalary(sc.nextDouble("Enter salary: "));
        System.err.println("Update successful");
    }

    /**
     * Allow user to delete a doctor
     */
    public void removeEmployee() {
        String id;
        do {
            id = getEmpID();
            int index = findEmployeeByID(id);
            empList.remove(index);
        } while (!sc.checkApprove("Do you want to delete " + id + " (Y or N): "));
        System.err.println("Remove successful");
    }

    /**
     * search employee by name
     */
    public void searchEmployee() {
        int choice = sc.checkLimit(1, 2, "1. Search by first name: " + "\n" + "2. Search by last name: \n" + "Enter your choice: ");
        String name;
        ArrayList<Employee> temp = new ArrayList<>();
        if (choice == 1) {
            name = sc.nextLine("Enter firstname: ");
            temp = findEmployeeByFirstName(name);
            System.out.printf("%-10s%-15s%-25s%-20s%-20s%-20s%-20s%-20s%-20s%n", "Id", "Name", "Email", "Address", "Sex", "Agency", "Phone", "DOB", "Salary");
            for (Employee data : temp) {
                data.getEmployee();
            }
            System.err.println("Search successful");
        } else {
            name = sc.nextLine("Enter lastname: ");
            temp = findEmployeeByLastName(name);
            System.out.printf("%-10s%-15s%-25s%-20s%-20s%-20s%-20s%-20s%-20s%n", "Id", "Name", "Email", "Address", "Sex", "Agency", "Phone", "DOB", "Salary");
            for (Employee data : temp) {
                data.getEmployee();
            }
            System.err.println("Search successful");
        }
    }

    /**
     * sort employee by salary
     */
    public void sortEmployeeBySalary() {
        for (int i = 0; i < empList.size(); i++) {
            for (int j = i; j < empList.size() - 1; j++) {
                if (empList.get(j).getSalary() > empList.get(j + 1).getSalary()) {
                    Employee temp = empList.get(j);
                    empList.set(j, empList.get(j + 1));
                    empList.set(j + 1, temp);
                }
            }
        }
        System.out.println("\nEMPLOYEE LIST");
        System.out.println("----------------");// +"   ");
        System.out.printf("%-10s%-15s%-25s%-20s%-20s%-20s%-20s%-20s%-20s%n", "Id", "Name", "Email", "Address", "Sex", "Agency", "Phone", "DOB", "Salary");
        for (Employee data : empList) {
            data.getEmployee();
        }
        System.err.println("Sort successful");
    }

    /**
     * find the doctor by name
     *
     * @param firstName value to find
     * @return an integer value
     */
    public ArrayList<Employee> findEmployeeByFirstName(String firstName) {
        ArrayList<Employee> temp = new ArrayList<>();

        for (int i = 0; i < empList.size(); i++) {
            if ((empList.get(i).getLastName().toLowerCase()).contains(firstName.toLowerCase())) {
                temp.add(empList.get(i));
            }
        }
        return temp;
    }

    /**
     * find the doctor by name
     *
     * @param lastName value to find
     * @return an integer value
     */
    public ArrayList<Employee> findEmployeeByLastName(String lastName) {
        ArrayList<Employee> temp = new ArrayList<>();

        for (int i = 0; i < empList.size(); i++) {
            if ((empList.get(i).getLastName().toLowerCase()).contains(lastName.toLowerCase())) {
                temp.add(empList.get(i));
            }
        }
        return temp;
    }

    /**
     * check is id duplicate or not
     *
     * @param id to compare
     * @return boolean valid
     */
    public boolean checkDuplicate(String id) {
        for (int i = 0; i < empList.size(); i++) {
            if (id.equalsIgnoreCase(empList.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * add new email to the emp list
     *
     * @return string
     */
    public String addEmail() {
        String email;
        do {
            email = sc.nextLine("Enter email: ");
            if (!email.matches("^[A-Za-z0-9]+@+[A-Za-z0-9]+.com$")) {
                System.out.println("Wrong email format ");
            }
        } while (!email.matches("^[A-Za-z0-9]+@+[A-Za-z0-9]+.com$"));
        return email;
    }

    /**
     * add new phone number to the list
     *
     * @return string
     */
    public String addPhone() {
        String phone;
        do {
            phone = sc.nextLine("Enter phone number: ");
            if (!checkPhoneLenght(phone)) {
                System.out.println("Phone format is not right");
            }
        } while (!checkPhoneLenght(phone));
        return phone;
    }

    /**
     * add new day of birth to emplist
     *
     * @return string value
     */
    public String addDate() {
        String date;
        do {
            date = sc.nextLine("Enter day of birth(dd-MM-yyyy): ");
            if (!date.matches("^(\\d)+(-)+(\\d)+(-)+(\\d)+$")) {
                System.out.println("Wrong format! ");
            } else {
                if (!checkDate(date)) {
                    System.out.println("Date is not valid");
                }
            }
        } while (!date.matches("^(\\d)+(-)+(\\d)+(-)+(\\d)+$") || !checkDate(date));
        return date;
    }

    /**
     * add new id to the emplist
     *
     * @return String value
     */
    public String addID() {
        String id;
        do {
            id = sc.nextLine("Enter ID: ");
            if (checkDuplicate(id)) {
                System.out.println("Id duplicate! ");
            }
        } while (checkDuplicate(id));
        return id;
    }

    /**
     * get id that exist at the emplist
     *
     * @return String value
     */
    public String getEmpID() {
        String id;
        do {
            id = sc.nextLine("Enter ID: ");
            if (!checkDuplicate(id)) {
                System.out.println("Id not exsit! ");
            }
        } while (!checkDuplicate(id));
        return id;
    }

}
