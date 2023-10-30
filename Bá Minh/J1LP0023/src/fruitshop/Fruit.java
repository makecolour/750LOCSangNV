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
 * This class contains attributes and encapsulation method for Fruit object
 * @author Dell
 */
public class Fruit {
    private String id;
    private String name;
    private double price;
    private int quantity;
    private String origin;

    /**
     * Default constructor
     */
    public Fruit() {}
    
    /**
     * Parameterized Constructor
     * @param id for id attribute
     * @param name for name attribute
     * @param quantity for quantity attribute
     * @param price for price attribute
     * @param origin for origin attribute
     */
    public Fruit(String id, String name, double price, int quantity, String origin) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    /**
     * This method return the id
     * @return String id
     */
    public String getId() {
        return id;
    }

    /**
     * This method return the name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * This method return the price
     * @return double price
     */
    public double getPrice() {
        return price;
    }

    /**
     * This method return the quantity
     * @return int quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * This method return the origin
     * @return string origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * This method set the value for name attribute
     * @param name value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method set the value for price attribute
     * @param price value to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This method set the value for quantity attribute
     * @param quantity value to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * This method set the value for origin attribute
     * @param origin value to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
