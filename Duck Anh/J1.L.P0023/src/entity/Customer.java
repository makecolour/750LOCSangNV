/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Create a Java console program to manage a Fruit Shop (Product and Shopping).> :				
 * <program allow user manage fruit information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-30>      <8.2>     <AnhTD>        <Create a Java console program to manage a Fruit Shop (Product and Shopping).>				
 */
package entity;

/**
 *
 * The Customer class represents a customer entity with a name. It provides
 * methods to get and set the customer's name.
 *
 * @author Tran Duc Anh
 */
public class Customer {

    private String name;

    /**
     * Constructs a new customer with an empty name.
     */
    public Customer() {
    }

    /**
     * Constructs a new customer with the specified name.
     *
     * @param name The name of the customer.
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the customer.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     *
     * @param name The new name for the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

}
