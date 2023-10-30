/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Employee management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package bank_p0071;

/**
 * This class provides methods for inputting data
 *
 * @author Chu Hoang Giang
 */
public class TypeOfTask {
    private int id;
    private String name;
    /**
     * defaut constucter
     */
    public TypeOfTask() {
    }
    /**
     * 
     * @param id
     * @param name 
     */
    public TypeOfTask(int id, String name) {
        this.id = id;
        this.name = name;
    }
    /**
     * Get id
     * @return String id
     */
    public int getId() {
        return id;
    }
    /**
     * Get name
     * @return String name
     */
    public String getName() {
        return name;
    }
    /**
     * Set id
     * @param id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Set name 
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
