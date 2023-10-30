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
 * The class contains attribute, constructor of Employee and method toString,
 * get, set to manage screen output string
 *
 * @author Nguyen Ba Duc Minh
 */
public class Employee implements Comparable<Employee> {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String dob;
    private String sex;
    private double salary;
    private String agency;

    /**
     * Default constructor to declare empty object
     */
    public Employee() {
    }

    /**
     * Parameterized constructor for the Employee class. Initializes an Employee
     * object with the provided attributes.
     *
     * @param id The unique identifier of the employee.
     * @param firstName The first name of the employee.
     * @param lastName The last name of the employee.
     * @param phone The phone number of the employee.
     * @param email The email address of the employee.
     * @param address The address of the employee.
     * @param dob The date of birth of the employee.
     * @param sex The gender of the employee.
     * @param salary The salary of the employee.
     * @param agency The agency to which the employee belongs.
     */
    public Employee(String id, String firstName, String lastName, String phone, String email, String address, String dob, String sex, double salary, String agency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = utilizeDate(dob);
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }

    /**
     * Gets the ID of the Course member.
     *
     * @return The ID of the Course member as a String.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the Course member.
     *
     * @param id The new ID for the Course member, provided as a String.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the first name of the Course member.
     *
     * @return The first name of the Course member as a String.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the Course member.
     *
     * @param firstName The new first name for the Course member, provided as a
     * String.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the Course member.
     *
     * @return The last name of the Course member as a String.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the Course member.
     *
     * @param lastName The new last name for the Course member, provided as a
     * String.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the phone number of the Course member.
     *
     * @return The phone number of the Course member as a String.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number of the Course member.
     *
     * @param phone The new phone number for the Course member, provided as a
     * String.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the email address of the Course member.
     *
     * @return The email address of the Course member as a String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the Course member.
     *
     * @param email The new email address for the Course member, provided as a
     * String.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the address of the Course member.
     *
     * @return The address of the Course member as a String.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the Course member.
     *
     * @param address The new address for the Course member, provided as a
     * String.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the date of birth of the Course member.
     *
     * @return The date of birth of the Course member as a String.
     */
    public String getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the Course member.
     *
     * @param dob The new date of birth for the Course member, provided as a
     * String.
     */
    public void setDob(String dob) {
        this.dob = utilizeDate(dob);
    }

    /**
     * Gets the sex of the Course member.
     *
     * @return The sex of the Course member as a String.
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the sex of the Course member.
     *
     * @param sex The new sex for the Course member, provided as a String.
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Gets the salary of the Course member.
     *
     * @return The salary of the Course member as a double.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the Course member.
     *
     * @param salary The new salary for the Course member, provided as a double.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Gets the agency of the Course member.
     *
     * @return The agency of the Course member as a String.
     */
    public String getAgency() {
        return agency;
    }

    /**
     * Sets the agency of the Course member.
     *
     * @param agency The new agency for the Course member, provided as a String.
     */
    public void setAgency(String agency) {
        this.agency = agency;
    }

    /**
     * Converts the Course object to a formatted string representation. This
     * method returns a formatted string containing various attributes of the
     * Course member, including ID, first name, last name, phone number, email,
     * address, date of birth, sex, salary, and agency.
     *
     * @return A formatted string representation of the Course object.
     */
    @Override
    public String toString() {
        return String.format("| %2s | %10s | %9s | %12s | %20s | %7s | %10s | %6s | %10.2f | %6s |", id, firstName, lastName, phone, email, address, dob, sex, salary, agency);

    }

    /**
     * Formats a date string to ensure it follows the "YYYY-MM-DD" format. Adds
     * leading zeros to month and day if necessary.
     *
     * @param date The input date string in the format "YYYY-MM-DD".
     * @return A formatted date string in the "YYYY-MM-DD" format.
     */
    private static String utilizeDate(String date) {
        String[] dateAttribute = date.split("-");
        String finalDate;
        int year = Integer.parseInt(dateAttribute[0]);
        int month = Integer.parseInt(dateAttribute[1]);
        int day = Integer.parseInt(dateAttribute[2]);
        String finalMonth;
        String finalDay;
        //check if month has 1 number
        if (month < 10) {
            finalMonth = "0" + String.valueOf(month);
        } else {
            finalMonth = String.valueOf(month);
        }
        //check if day has 1 number
        if (day < 10) {
            finalDay = "0" + String.valueOf(day);
        } else {
            finalDay = String.valueOf(day);
        }
        finalDate = String.valueOf(year) + "-" + finalMonth + "-" + finalDay;
        return finalDate;
    }

    /**
     * Compares this Employee object to another Employee based on their
     * salaries.
     *
     * This method overrides the compareTo method from the Comparable interface.
     * It compares this Employee's salary to another Employee's salary and
     * returns a negative value (-1) if this Employee's salary is greater, a
     * positive value (1) if it's smaller, or zero if they have equal salaries.
     *
     * @param o The Employee object to compare to.
     * @return -1 if this Employee's salary is greater, 1 if it's smaller, or 0
     * if they have equal salaries.
     */
    @Override
    public int compareTo(Employee o) {
        if (this.salary - o.getSalary() > 0) {
            return -1;
        } else if (this.salary - o.getSalary() < 0) {
            return 1;
        } else {
            return 0;
        }

    }

}
