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

import java.util.Comparator;

/**
 * This class extends from Country Contains all the attributes of Country object
 * Provides methods to get user input and encapsulation methods for
 * EastAsiaCountries object
 *
 * @author Nguyen Ba Duc Minh
 */
public class EastAsiaCountries extends Country implements Comparator<EastAsiaCountries> {

    private String countryTerrain;

    /**
     * Default constructor
     */
    public EastAsiaCountries() {
    }

    /**
     * Parameterized Constructor
     *
     * @param countryCode for countryCode attribute
     * @param countryName for countryName attribute
     * @param totalArea for totalArea attribute
     * @param countryTerrain for countryTerrain attribute
     */
    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    /**
     * This method get the countryTerrain
     *
     * @return countryTerrain
     */
    public String getCountryTerrain() {
        return this.countryTerrain;
    }

    /**
     * This method set the countryTerrain
     *
     * @param countryTerrain value to set
     */
    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    /**
     * Display the data
     */
    @Override
    public void display() {
        System.out.println(this.toString());
    }

    /**
     * Override the toString method
     *
     * @return a String
     */
    @Override
    public String toString() {
        return String.format("%-25s%-20s%-20s%-20s", this.getCountryCode(),
                this.getCountryName(), this.getTotalArea(),
                this.getCountryTerrain());
    }

    /**
     * override compare method
     *
     * @param o1 value to compare
     * @param o2 value to compare
     * @return
     */
    @Override
    public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
        return o1.getCountryName().compareTo(o2.getCountryName());
    }
}
