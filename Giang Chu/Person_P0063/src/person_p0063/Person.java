/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Employee management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package person_p0063;

/**
 * This class provides methods for inputting data
 *
 * @author Chu Hoang Giang
 */
public class Person {
    private String name;
    private String address;
    private double salary;
    
    /**
     * defau constucter
     * @param name to set name
     * @param address to set address
     * @param salary to set salary
     */
    public Person(String name, String address, double salary) {
        this.name = name;
        this.address = address;
        this.salary = salary;
    }
    
    /**
     * get name
     * @return String value
     */
    public String getName() {
        return name;
    }

    /**
     * get address
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * get Salary
     * @return double
     */
    public double getSalary() {
        return salary;
    }

    /**
     * set name
     * @param name to set  
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set address
     * @param address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * set salary
     * @param salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
}
