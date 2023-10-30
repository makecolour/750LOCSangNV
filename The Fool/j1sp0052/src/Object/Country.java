/*							
 * Copyright(C) 2023,  FPT University.							
 * Geographic Management							
 * Manage information of east asia country				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-30>       <1.0>          <La Dieu Minh>     <Manage information of east asia country List>							
 */
package Object;

/**
 * Country class inheritance EastAsiaCountries class.
 * Get, set country terrain.
 * Display country information.
 * Sort country by name in ascending using comparable 
 *
 * @author La Dieu Minh
 */
public class Country extends EastAsiaCountries implements Comparable<Country> {

    private String countryTerrain;

    /**
     * Constructor called the EastAsiaCountries constructor.
     * 
     * @param countryTerrain country terrain
     * @param countryCode country code
     * @param countryName country name
     * @param countryArea country area
     */
    public Country(String countryTerrain, String countryCode,String countryName, double countryArea) {
        super(countryCode, countryName, countryArea);
        this.countryTerrain = countryTerrain;
    }
    
    /**
     * Constructor allow this class to be initialized
     */
    public Country() {
    }

    /**
     * Display country's information
     */
    @Override
    public void display() {
        System.out.printf("%-10s%-25s%-20.0f%-25s\n", this.countryCode, this.countryName, this.countryArea, this.countryTerrain);
    }

    /**
     * Get the country terrain
     * @return a string
     */
    public String getCountryTerrain() {
        return countryTerrain;
    }

    /**
     * Set country terrain to the given terrain
     * @param countryTerrain country terrain
     */
    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    /**
     * Override method of comparable to sort country by name in ascending order
     * @param country country object
     * @return an integer -1 if lesser 0 if equals and 1 if larger. 
     */
    @Override
    public int compareTo(Country country) {
        return this.getCountryName().compareTo(country.getCountryName());
    }

}
