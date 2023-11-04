/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Student management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package student_p0021;

/**
 * This class contains the main method for implementing employee management
 * project
 *
 * @author Chu Hoang Giang
 */
public class Course {
    private String name;
    private int quantity;

    public Course(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
