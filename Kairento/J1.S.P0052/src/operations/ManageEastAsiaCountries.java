/*							
 * Copyright(C) 2023,  FPT University.							
 * Geographic Management							
 * Manage information of easr asia country				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-25>       <1.0>          <Nguyen Hoang Manh>     <Manage information of easr asia country	 List>							
 */
package operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Logger;
import object.Country;

/**
 * This class is for managing information of east asia country
 * 
 * @author Nguyen Hoang Manh
 */
public class ManageEastAsiaCountries {
    
    private final static Scanner scanner = new Scanner(System.in);
    private final static Logger logger = Logger.getLogger(ManageEastAsiaCountries.class.getName());
    
    /**
     * Constructor allow this class to be initialized
     */
    public ManageEastAsiaCountries(){
        
    }
    
    /**
     * Check string input and return if conditions is met
     * @return a string. It is a <code>java.lang.String</code> object
     */
    public String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                logger.warning("The string is empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * Check double input and return if conditions is met
     * @return a double. It is a <code>java.lang.Double</code> object
     */
    public double checkInputDouble() {
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (NumberFormatException e) {
                logger.warning("Please input number double");
                System.out.print("Enter again: ");
            }
        }
    }
   
    /**
     * Allow user input information of countries
     * @param countryList country list. It is a <code>java.util.ArrayList</code> object
     */
    public void inputCountry(ArrayList<Country> countryList) {
        System.out.print("    Enter code of country: ");
        String countryCode = checkInputString();
        //check code country exist or not
        if (!checkCountryExist(countryList, countryCode)) {
            logger.warning("Country is already existed.");
            return;
        }
        System.out.print("    Enter name of country: ");
        String countryName = checkInputString();
        
        System.out.print("    Enter total area: ");
        double countryArea = checkInputDouble();
        System.out.print("    Enter terrain of country: ");
        String countryTerrain = checkInputString();
        
        countryList.add(new Country(countryTerrain, countryCode, countryName, countryArea));
        
        System.out.println("Country added successfully.");
    }

    /**
     * Display information of country
     * 
     * @param countryList country list. It is a <code>java.util.ArrayList</code> object
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
     * @param countryList country list. It is a <code>java.util.ArrayList</code> object
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
     * @param countryList country list. It is a <code>java.util.ArrayList</code> object
     */
    public void searchByName(ArrayList<Country> countryList) {
        System.out.print("Enter the name you want to search for: ");
        String countryName = checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : countryList) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
            }
        }
    }

    /**
     * Check if country code is already exists in list
     * 
     * @param countryList country list. It is a <code>java.util.ArrayList</code> object
     * @param countryCode country code. It is a <code>java.util.String</code> object
     * @return true if it exists in list, false otherwise. It is a <code>java.util.Boolean</code> object
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