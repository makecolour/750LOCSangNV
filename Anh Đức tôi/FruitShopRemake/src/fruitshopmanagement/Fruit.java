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

/**
 * This class contains attributes and encapsulation method for Fruit object
 *
 * @author Nguyen Ba Duc Minh
 */
public class Fruit {

    private String fruitId;
    private String fruitName;
    private double fruitPrice;
    private int fruitQuantity;
    private String fruitOrigin;

    /**
     * Default constructor
     */
    public Fruit() {
    }

    /**
     * Parameterized Constructor
     *
     * @param fruitId for id attribute
     * @param fruitName for name attribute
     * @param fruitQuantity for quantity attribute
     * @param fruitPrice for price attribute
     * @param fruitOrigin for origin attribute
     */
    public Fruit(String fruitId, String fruitName, double fruitPrice, int fruitQuantity, String fruitOrigin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
        this.fruitQuantity = fruitQuantity;
        this.fruitOrigin = fruitOrigin;
    }

    /**
     * This method return the id
     *
     * @return String id
     */
    public String getFruitId() {
        return fruitId;
    }

    /**
     * This method return the name
     *
     * @return String name
     */
    public String getFruitName() {
        return fruitName;
    }

    /**
     * This method return the price
     *
     * @return double price
     */
    public double getFruitPrice() {
        return fruitPrice;
    }

    /**
     * This method return the quantity
     *
     * @return int quantity
     */
    public int getFruitQuantity() {
        return fruitQuantity;
    }

    /**
     * This method return the origin
     *
     * @return string origin
     */
    public String getFruitOrigin() {
        return fruitOrigin;
    }

    /**
     * This method set the value for name attribute
     *
     * @param fruitName value to set
     */
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    /**
     * This method set the value for price attribute
     *
     * @param fruitPrice value to set
     */
    public void setFruitPrice(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    /**
     * This method set the value for quantity attribute
     *
     * @param fruitQuantity value to set
     */
    public void setFruitQuantity(int fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }

    /**
     * This method set the value for origin attribute
     *
     * @param fruitOrigin value to set
     */
    public void setFruitOrigin(String fruitOrigin) {
        this.fruitOrigin = fruitOrigin;
    }
}
