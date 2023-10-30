/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Fruit shop management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
 */
package fruitshop;

/**
 * This class contains attributes and encapsulation method for Order object
 *
 * @author Dell
 */
public class Order {

    private String id;
    private String Name;
    private int quantity;
    private double price;

    /**
     * Default constructor
     */
    public Order() {
    }

    /**
     * Parameterized Constructor
     *
     * @param id for id attribute
     * @param Name for name attribute
     * @param quantity for quantity attribute
     * @param price for price attribute
     */
    public Order(String id, String Name, int quantity, double price) {
        this.id = id;
        this.Name = Name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * This method return the id
     *
     * @return String id
     */
    public String getId() {
        return id;
    }

    /**
     * This method return the name
     *
     * @return String name
     */
    public String getName() {
        return Name;
    }

    /**
     * This method return the price
     *
     * @return double price
     */
    public double getPrice() {
        return price;
    }

    /**
     * This method return the quantity
     *
     * @return int quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method set the value for name attribute
     *
     * @param Name value to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * This method set the value for price attribute
     *
     * @param price value to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This method set the value for quantity attribute
     *
     * @param quantity value to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
