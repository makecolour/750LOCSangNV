/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Fruit shop management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
 */
package fruitshopmanagement;

import java.util.ArrayList;

/**
 * This class provides the attributes of a customer
 *
 * @author Nguyen Ba Duc Minh
 */
public class Customer {

    private String customerName;
    private final ArrayList<Fruit> fruitOrder = new ArrayList();

    /**
     * Default constructor
     */
    public Customer() {
    }

    /**
     * parameterized constructor
     *
     * @param customerName value to set
     * @param fruitOrder value to set
     */
    public Customer(String customerName, ArrayList<Fruit> fruitOrder) {
        this.customerName = customerName;
        this.fruitOrder.addAll(fruitOrder);
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the listOrder
     */
    public ArrayList<Fruit> getFruitOrder() {
        return fruitOrder;
    }
}
