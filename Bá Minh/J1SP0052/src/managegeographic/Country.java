/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Geographic management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
 */
package managegeographic;

/**
 * This class contains all the attributes of Country object Provides methods to
 * get user input and encapsulation methods for Country object
 *
 * @author Nguyen Ba Duc Minh
 */
public class Country {

    private String countryCode;
    private String countryName;
    private float totalArea;

    /**
     * Default constructor
     */
    public Country() {
    }

    /**
     * Parameterized Constructor
     *
     * @param countryCode for countryCode attribute
     * @param countryName for countryName attribute
     * @param totalArea for totalArea attribute
     */
    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    /**
     * This method displays data
     */
    public void display() {
        System.out.print(this.toString());
    }

    /**
     * Override toString method
     *
     * @return a String
     */
    @Override
    public String toString() {
        return String.format("%-25s%-20s%-20s\n", this.getCountryCode(),
                this.getCountryName(), this.getTotalArea());
    }

    /**
     * This method get the countryCode
     *
     * @return countryCode
     */
    public String getCountryCode() {
        return this.countryCode;
    }

    /**
     * This method get the countryName
     *
     * @return countryName
     */
    public String getCountryName() {
        return this.countryName;
    }

    /**
     * This method get the totalArea
     *
     * @return totalAre
     */
    public float getTotalArea() {
        return this.totalArea;
    }

    /**
     * This method set value for countryCode
     *
     * @param countryCode value to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * This method set value for countryName
     *
     * @param countryName value to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * This method set value for totalArea
     *
     * @param totalArea value to set
     */
    public void setToltalArea(float totalArea) {
        this.totalArea = totalArea;
    }
}
