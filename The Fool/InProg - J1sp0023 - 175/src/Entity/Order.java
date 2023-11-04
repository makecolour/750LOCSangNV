/*
 * Copyright(C) 2005,  <FPTU>.
 * <0023> :
 *  <Fruit Shop Management System>
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * <26/10/2023>                <1>              <la Minh>                       <base>
 */
package Entity;

/**
 * Basic constructor for order list
 *
 * @author La Minh
 */
public class Order {

    private int fruitId;
    private String fruitName;
    private int quantity;
    private double price;

    /**
     * Default constructor
     */
    public Order() {
    }

    /**
     * list constructor
     * @param fruitId
     * @param fruitName
     * @param quantity
     * @param price
     */
    public Order(int fruitId, String fruitName, int quantity, double price) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * get id
     * @return id
     */
    public int getFruitId() {
        return fruitId;
    }

    /**
     * change id
     * @param fruitId
     */
    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    /**
     * get fruit name
     * @return name
     */
    public String getFruitName() {
        return fruitName;
    }

    /**
     * change fruit name
     * @param fruitName name
     */
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    /**
     * get quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * change quantity
     * @param quantity to be changed
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * get price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * change the price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

}
