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

import java.time.LocalDate;

/**
 * The Product class represents a product with various attributes, including ID,
 * name, price, location, expiry date, date of manufacture, category,
 * storekeeper, and receipt date. It includes methods for getting and setting
 * these attributes and formatting the object as a string for display. This
 * class utilizes the Storekeeper class to associate a product with a
 * storekeeper and ensures that date attributes are formatted in the
 * "YYYY-MM-DD" format.
 *
 * @author Tran Duc Anh
 */
public class Product {

    private String id;
    private String name;
    private double price;
    private String location;
    private LocalDate expiryDate;
    private LocalDate dateOfManufacture;
    private String category;
    private Storekeeper storekeeper;
    private LocalDate receiptDate;

    /**
     * Default constructor for the Product class. Initializes a Product object
     * with default values.
     */
    public Product() {
    }

    /**
     * Parameterized constructor for the Product class. Initializes a Product
     * object with the provided attributes.
     *
     * @param id The unique identifier of the product.
     * @param name The name of the product.
     * @param price The price of the product.
     * @param location The location where the product is stored.
     * @param expiryDate The date when the product expires.
     * @param dateOfManufacture The date when the product was manufactured.
     * @param category The category to which the product belongs.
     * @param storekeeper The storekeeper responsible for the product.
     * @param receiptDate The date when the product was received.
     */
    public Product(String id, String name, double price, String location, LocalDate expiryDate, LocalDate dateOfManufacture, String category, Storekeeper storekeeper, LocalDate receiptDate) {
        this.id = id;
        this.name = name;

        this.price = price;
        this.location = location;
        this.expiryDate = expiryDate;
        this.dateOfManufacture = dateOfManufacture;
        this.category = category;
        this.storekeeper = storekeeper;
        this.receiptDate = receiptDate;
    }

    /**
     * Get the price of an item.
     *
     * @return The price of the item as a double value.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of an item.
     *
     * @param price The new price of the item as a double value.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the location of an item.
     *
     * @return The location of the item as a string.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the location of an item.
     *
     * @param location The new location of the item as a string.
     */
    public void setLocation(String location) {
        this.location = location;
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
     * Get the expiry date of the object.
     *
     * @return The expiry date as a LocalDate.
     */
    public LocalDate getExpiryDate() {

        return expiryDate;
    }

    /**
     * Set the expiry date of the object.
     *
     * @param expiryDate The new expiry date as a LocalDate.
     */
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Get the date of manufacture of the object.
     *
     * @return The date of manufacture as a LocalDate.
     */
    public LocalDate getDateOfManufacture() {

        return dateOfManufacture;
    }

    /**
     * Set the date of manufacture of the object.
     *
     * @param dateOfManufacture The new date of manufacture as a LocalDate.
     */
    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    /**
     * Get the category of the object.
     *
     * @return The category as a string.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set the category of the object.
     *
     * @param category The new category as a string.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Get the storekeeper associated with the object.
     *
     * @return The storekeeper as a Storekeeper object.
     */
    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    /**
     * Set the storekeeper associated with the object.
     *
     * @param storekeeper The new storekeeper as a Storekeeper object.
     */
    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    /**
     * Get the receipt date of the object.
     *
     * @return The receipt date as a LocalDate.
     */
    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    /**
     * Set the receipt date of the object.
     *
     * @param receiptDate The new receipt date as a LocalDate.
     */
    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    /**
     * Convert the object to a formatted string representation.
     *
     * @return A formatted string representing the object.
     */
    @Override
    public String toString() {
        return String.format("| %2s | %12s | %9.2f | %8s | %11s | %19s | %8s | %11s | %12s |", id, name, price, location, expiryDate, dateOfManufacture, category, storekeeper.getName(), receiptDate);
    }

}
