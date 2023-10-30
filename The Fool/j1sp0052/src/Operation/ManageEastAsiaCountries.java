/*							
 * Copyright(C) 2023,  FPT University.							
 * Geographic Management							
 * Manage information of east asia country				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-30>       <1.0>          <La Dieu Minh>     <Manage information of east asia country List>							
 */
package Operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;
import Object.Country;
import Main.Input;

/**
 * This class is for managing information of east asia country
 * 
 * @author La Dieu Minh
 */
public class ManageEastAsiaCountries {
    
    private final Logger logger = Logger.getLogger(ManageEastAsiaCountries.class.getName());
    private final Input input = new Input();
    
    
    /**
     * Constructor allow this class to be initialized
     */
    public ManageEastAsiaCountries(){
        
    }
    
   
    /**
     * Allow user input information of countries
     * @param countryList country list
     */
    public void inputCountry(ArrayList<Country> countryList) {
        System.out.print("    Enter code of country: ");
        String countryCode = input.checkInputString();
        //check code country exist or not
        if (!checkCountryExist(countryList, countryCode)) {
            logger.warning("Country is already existed.");
            return;
        }
        System.out.print("    Enter name of country: ");
        String countryName = input.checkInputString();
        
        System.out.print("    Enter total area: ");
        double countryArea = input.checkInputDouble();
        System.out.print("    Enter terrain of country: ");
        String countryTerrain = input.checkInputString();
        
        countryList.add(new Country(countryTerrain, countryCode, countryName, countryArea));
        
        System.out.println("Country added successfully.");
    }

    /**
     * Display information of country
     * 
     * @param countryList country list
     */
    public void printCountry(ArrayList<Country> countryList) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : countryList) {
            country.display();
        }
    }

    /**
     * Display information sort by name in ascending order
     * 
     * @param countryList country list
     */
    public void printCountrySorted(ArrayList<Country> countryList) {
        Collections.sort(countryList);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (Country country : countryList) {
            country.display();
        }
    }

    /**
     * Allow user search country information by name
     * 
     * @param countryList country list
     */
    public void searchByName(ArrayList<Country> countryList) {
        System.out.print("Enter the name you want to search for: ");
        String countryName = input.checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : countryList) {
            if (country.getCountryName().equalsIgnoreCase(countryName) || country.getCountryName().toUpperCase().contains(countryName.toUpperCase()) ) {
                country.display();
            }
        }
    }

    /**
     * Check if country code is already exists in list
     * 
     * @param countryList country list
     * @param countryCode country code
     * @return true if it exists in list, false otherwise
     */
    public boolean checkCountryExist(ArrayList<Country> countryList, String countryCode) {
        for (Country country : countryList) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return false;
            }
        }
        return true;
    }
    
}