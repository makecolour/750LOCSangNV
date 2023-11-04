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
 * Main constructor for fruit entity
 *
 * @author La Minh
 */
public class Fruit {
    
    int fruitID;
    String fruitName;
    int price;
    int quantity;
    String origin;
    
    /**
     * default constructor
     */
    public Fruit(){}
    
    /**
     * constructor
     * @param fruitID
     * @param fruitName
     * @param price
     * @param quantity
     * @param origin
     */
    public Fruit(int fruitID, String fruitName, int price, int quantity, String origin){
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    /**
     * return id
     * @return id
     */
    public int getFruitID() {
        return fruitID;
    }

    /**
     * change id
     * @param fruitID need to be changed
     */
    public void setFruitID(int fruitID) {
        this.fruitID = fruitID;
    }

    /**
     * return name
     * @return fruit name
     */
    public String getFruitName() {
        return fruitName;
    }

    /**
     * change fruit name
     * @param fruitName to be changed
     */
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    /**
     * return price
     * @return price
     */
    public int getPrice() {
        return price;
    }

    /**
     * change the price
     * @param price to be changed
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * get quantity
     * @return the quantity
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
     * get origin
     * @return origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * change the origin
     * @param origin 
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
