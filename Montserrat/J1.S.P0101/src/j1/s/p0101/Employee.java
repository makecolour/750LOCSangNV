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
 * This class represent Employee object 
 * @author quyen
 */
public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String dob;
    private boolean sex;//true is Male, false is Female
    private double salary;
    private String agency;

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName, String phone, String email, String address, String dob, boolean sex, double salary, String agency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public boolean isSex() {
        return sex;
    }

    public double getSalary() {
        return salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

}
