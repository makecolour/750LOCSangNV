/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Products management system>:				
 * <Program allow user manage employee information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-20>      <8.2>     <AnhTD>        <Write a program allow user to input and manage products information on screen.>				
 */
package entity;

/**
 * The Storekeeper class represents a storekeeper with attributes such as ID and
 * name. It includes methods for getting and setting these attributes and
 * formatting the object as a string for display.
 *
 * @author Tran Duc Anh
 */
public class Storekeeper {

    private String id;
    private String name;

    /**
     * Constructs a new Storekeeper with default values.
     */
    public Storekeeper() {
    }

    /**
     * Constructs a new Storekeeper with the specified ID and name.
     *
     * @param id The unique identifier for the Storekeeper.
     * @param name The name of the Storekeeper.
     */
    public Storekeeper(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Get the ID of the object.
     *
     * @return The ID as a string.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of the object.
     *
     * @param id The new ID as a string.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the name of the object.
     *
     * @return The name as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the object.
     *
     * @param name The new name as a string.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Convert the object to a string representation.
     *
     * @return A string representing the object.
     */
    @Override
    public String toString() {
        return name;
    }

}
