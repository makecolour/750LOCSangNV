/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Geography management program> :				
 * <Create a Java console program to manage geography.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program to manage the geographic. >				
 */
package entity;

/**
 * The `Country` class represents information about a country, including its
 * country code, country name, and total area. It provides methods to access and
 * modify these attributes.
 *
 * @author Trần Đức Anh
 */
public class Country {

    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    /**
     * Default constructor for the `Country` class.
     */
    public Country() {
    }

    /**
     * Constructs a new `Country` object with the specified country code,
     * country name, and total area.
     *
     * @param countryCode The unique code representing the country.
     * @param countryName The name of the country.
     * @param totalArea The total land area of the country in square kilometers.
     */
    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    /**
     * Get the country code of the country.
     *
     * @return The country code as a string.
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Set the country code of the country.
     *
     * @param countryCode The new country code to set.
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Get the name of the country.
     *
     * @return The name of the country as a string.
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Set the name of the country.
     *
     * @param countryName The new country name to set.
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Get the total land area of the country in square kilometers.
     *
     * @return The total land area as a floating-point number.
     */
    public float getTotalArea() {
        return totalArea;
    }

    /**
     * Set the total land area of the country in square kilometers.
     *
     * @param totalArea The new total area to set.
     */
    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    /**
     * Returns a string representation of the `Country` object, including its
     * country code, country name, and total area.
     *
     * @return A formatted string representation of the `Country` object.
     */
    @Override
    public String toString() {
        return String.format("%-5s %-10s %-10.2f", countryCode, countryName, totalArea);
    }

}
