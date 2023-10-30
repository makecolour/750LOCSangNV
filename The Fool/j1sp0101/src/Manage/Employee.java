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
import java.util.Date;

/**
 * This class contain method that will be used to input and get value out for display
 *
 * @author MinhLD
 */
public class Employee {
    private int Id;
    private String FirstName;
    private String LastName;
    private String Phone;
    private String Email;
    private String Address;
    private Date DOB;
    private String Sex;
    private int Salary;
    private String Agency;

    /*
    default constructor
     */
    public Employee() {
    }

    /*
    initialization
     */
    public Employee(int Id, String FirstName, String LastName, String Phone, String Email, String Address, Date DOB, String Sex, int Salary, String Agency) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Phone = Phone;
        this.Email = Email;
        this.Address = Address;
        this.DOB = DOB;
        this.Sex = Sex;
        this.Salary = Salary;
        this.Agency = Agency;
    }

    /**
     * @return needed ID
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id current id needed for change
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return first name
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * @param FirstName first that needed to be change
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * @return last name
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * @param LastName last name needed to be change
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * @return phone num
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * @param Phone update phone number
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * @return getemail
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return get address
     */
    public String getAddress() {
        return Address;
    }


    /**
     * @param Address needed for change
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return date of birth
     */
    public Date getDOB() {
        return DOB;
    }

    /**
     * @param DOB needed for change
     */
    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    /**
     * @return sex
     */
    public String getSex() {
        return Sex;
    }

    /**
     * @param Sex needed for change
     */
    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    /**
     * @return salary
     */
    public int getSalary() {
        return Salary;
    }

    /**
     * @param Salary needed for change
     */
    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    /**
     * @return agency currently in
     */
    public String getAgency() {
        return Agency;
    }

    /**
     * @param Agency needed to be changed
     */
    public void setAgency(String Agency) {
        this.Agency = Agency;
    }


}