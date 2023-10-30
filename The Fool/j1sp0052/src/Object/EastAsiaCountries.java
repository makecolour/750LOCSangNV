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
 * EastAsiaCountries class is inheritance by Country class.
 * Get, set country name, country code and country area.
 *
 * @author La Dieu Minh
 */
public class EastAsiaCountries {

    protected String countryCode;
    protected String countryName;
    protected double countryArea;

    /**
     * Constructor allow this class to be initialized
     */
    public EastAsiaCountries() {
    }

    /**
     * Constructor of the EastAsiaCountries class
     * @param countryCode country code
     * @param countryName country name
     * @param countryArea country area
     */
    public EastAsiaCountries(String countryCode, String countryName, double countryArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryArea = countryArea;
    }

    /**
     * Get country code and return
     * @return a string
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Set country code to given parameter
     * @param countryCode country code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Get country name and return
     * @return a string
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Set country name to given parameter
     * @param countryName country name
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Get country area and return.
     * @return a double
     */
    public double getCountryArea() {
        return countryArea;
    }

    /**
     * Set country area to given parameter
     * @param countryArea country area
     */
    public void setCountryArea(double countryArea) {
        this.countryArea = countryArea;
    }

    /**
     * This method is override in Country class.
     */
    public void display() {
    }
}
