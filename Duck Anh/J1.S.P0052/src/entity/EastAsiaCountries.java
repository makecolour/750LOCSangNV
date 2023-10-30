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
 * The `EastAsiaCountries` class extends the `Country` class and represents
 * countries in East Asia. It includes additional attributes country
 * terrain and implements the `Comparable` interface for comparing country
 * names.
 *
 * @author Trần Đức Anh
 */
public class EastAsiaCountries extends Country implements Comparable<EastAsiaCountries> {

    private String countryTerrain;

    /**
     * Default constructor for the `EastAsiaCountries` class.
     */
    public EastAsiaCountries() {
    }

    /**
     * Constructs a new `EastAsiaCountries` object
     *
     * @param countryTerrain The terrain type of the country.
     * @param countryCode The unique code representing the country.
     * @param countryName The name of the country.
     * @param totalArea The total land area of the country in square kilometers.
     */
    public EastAsiaCountries(String countryTerrain, String countryCode, String countryName, float totalArea) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    /**
     * Get the terrain type of the country.
     *
     * @return The terrain type as a string.
     */
    public String getCountryTerrain() {
        return countryTerrain;
    }

    /**
     * Set the terrain type of the country.
     *
     * @param countryTerrain The new terrain type to set.
     */
    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    /**
     * Returns a string representation of the `EastAsiaCountries` object,
     * including its country code, country name, total area, and terrain type.
     *
     * @return A formatted string representation of the `EastAsiaCountries`
     * object.
     */
    @Override
    public String toString() {
        return super.toString() + String.format("    %6s", countryTerrain);
    }

    /**
     * Compares this `EastAsiaCountries` object to another `EastAsiaCountries`
     * object based on their country names.
     *
     * @param o The `EastAsiaCountries` object to compare to.
     * @return A negative integer if this object's country name is
     * lexicographically less than the other object's country name, a positive
     * integer if greater, and zero if equal.
     */
    @Override
    public int compareTo(EastAsiaCountries o) {
        return this.countryName.compareTo(o.countryName);
    }

}
