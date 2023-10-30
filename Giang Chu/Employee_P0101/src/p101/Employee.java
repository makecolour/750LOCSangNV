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

/**
 * This class contains all the attribute of a employee
 *
 * @author Chu Hoang Giang
 */
public class Employee {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String sex;
    private String agency;
    private String phone;
    private String dob;
    private double salary;

    /**
     * Default constructor
     */
    public Employee() {
    }

    /**
     * Parameter constructor
     *
     * @param id for code attribute
     * @param firstName for firstName attribute
     * @param lastName for lastName attribute
     * @param email for email attribute
     * @param address for address attribute
     * @param sex for sex attribute
     * @param agency for agency attribute
     * @param phone for phone attribute
     * @param dob for date attribute
     * @param salary for salary attribute
     */
    public Employee(String id, String firstName, String lastName, String email, String address, String sex, String agency, String phone, String dob, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.sex = sex;
        this.agency = agency;
        this.phone = phone;
        this.dob = dob;
        this.salary = salary;
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return lastName
     */
    public String getLastName() {
        return (lastName + " ");
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @return agency
     */
    public String getAgency() {
        return agency;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @return dob
     */
    public String getDOB() {
        return dob;
    }

    /**
     * @return salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * @return name
     */
    public String getName() {
        return (getFirstName() + " " + getLastName());
    }

    /**
     * Print employee information
     */
    public void getEmployee() {
        System.out.printf("%-10s%-15s%-25s%-20s%-20s%-20s%-20s%-20s%-20s%n", getId(), getName(), getEmail(), getAddress(), getSex(), getAgency(), getPhone(), getDOB(), getSalary());
    }

    /**
     * Set id
     *
     * @param id value to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set firstName
     *
     * @param firstName value to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set lastName
     *
     * @param lastName value to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set email
     *
     * @param email value to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set address
     *
     * @param address value to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Set sex
     *
     * @param sex value to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * Set agency
     *
     * @param agency value to set
     */
    public void setAgency(String agency) {
        this.agency = agency;
    }

    /**
     * Set phone
     *
     * @param phone value to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set salary
     *
     * @param salary value to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Set dob
     *
     * @param dob value to set
     */
    public void setDOB(String dob) {
        this.dob = dob;
    }
}
