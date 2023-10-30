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
 * Represents a fruit item with attributes such as a unique identifier
 * (fruitId), name (fruitName), price, quantity, and origin.
 *
 *
 * This class provides a default constructor and a parameterized constructor for
 * creating `Fruit` objects with specified attributes. It includes getter and
 * setter methods for accessing and modifying the attributes of a `Fruit`
 * object: fruitId, fruitName, price, quantity, and origin. Additionally, the
 * class overrides the `toString` method to provide a formatted string
 * representation of a `Fruit` object, displaying its name, origin, and price.
 *
 * @author Tran Duc Anh
 */
public class Fruit {

    private String fruitId;
    private String fruitName;
    private double price;
    private int quantity;
    private String origin;

    /**
     * Default constructor for a Fruit object.
     */
    public Fruit() {
    }

    /**
     * Parameterized constructor for a Fruit object.
     *
     * @param fruitId The unique identifier for the fruit.
     * @param fruitName The name of the fruit.
     * @param price The price of the fruit.
     * @param quantity The quantity of the fruit.
     * @param origin The origin or source of the fruit.
     */
    public Fruit(String fruitId, String fruitName, double price, int quantity, String origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    /**
     * Retrieves the fruit's unique identifier.
     *
     * @return The fruit's unique identifier.
     */
    public String getFruitId() {
        return fruitId;
    }

    /**
     * Sets the fruit's unique identifier.
     *
     * @param fruitId The new unique identifier for the fruit.
     */
    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    /**
     * Retrieves the name of the fruit.
     *
     * @return The name of the fruit.
     */
    public String getFruitName() {
        return fruitName;
    }

    /**
     * Sets the name of the fruit.
     *
     * @param fruitName The new name for the fruit.
     */
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    /**
     * Retrieves the price of the fruit.
     *
     * @return The price of the fruit.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the fruit.
     *
     * @param price The new price for the fruit.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the fruit.
     *
     * @return The quantity of the fruit.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the fruit.
     *
     * @param quantity The new quantity for the fruit.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Retrieves the origin or source of the fruit.
     *
     * @return The origin or source of the fruit.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin or source of the fruit.
     *
     * @param origin The new origin or source for the fruit.
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Returns a formatted string representation of the Fruit object.
     *
     * @return A formatted string representing the fruit's name, origin, and
     * price.
     */
    @Override
    public String toString() {
        return String.format("|    %-10s    |  %-8s    |    %5.2f    |", fruitName, origin, price);
    }

    /**
     * Returns a formatted string representation of the order Fruit object.
     *
     * @return A formatted string representing the order fruit's name, origin,
     * and price.
     */
    public String toOrderString() {
        return String.format("%-10s | %8d | %3.2f  | %6.2f", fruitName, quantity, price, price * quantity);
    }

}
