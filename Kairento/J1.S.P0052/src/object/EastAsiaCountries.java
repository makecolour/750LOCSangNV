/*							
 * Copyright(C) 2023,  FPT University.							
 * Geographic Management							
 * Manage information of easr asia country				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-25>       <1.0>          <Nguyen Hoang Manh>     <Manage information of easr asia country	 List>							
 */
package object;

/**
 * EastAsiaCountries class is inheritance by Country class.
 * Get, set country name, country code and country area.
 *
 * @author Nguyen Hoang Manh
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
     * @param countryCode country code. It is a <code>java.lang.String</code> object
     * @param countryName country name. It is a <code>java.lang.String</code> object
     * @param countryArea country area. It is a <code>java.lang.Integer</code> object
     */
    public EastAsiaCountries(String countryCode, String countryName, double countryArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryArea = countryArea;
    }

    /**
     * Get country code and return
     * @return a string. It is a <code>java.lang.String</code> object
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Set country code to given parameter
     * @param countryCode country code. It is a <code>java.lang.String</code> object
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Get country name and return
     * @return a string. It is a <code>java.lang.String</code> object
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Set country name to given parameter
     * @param countryName country name. It is a <code>java.lang.String</code> object
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Get country area and return.
     * @return a double. It is a <code>java.lang.Double</code> object
     */
    public double getCountryArea() {
        return countryArea;
    }

    /**
     * Set country area to given parameter
     * @param countryArea country area.  It is a <code>java.lang.Double</code> object
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
