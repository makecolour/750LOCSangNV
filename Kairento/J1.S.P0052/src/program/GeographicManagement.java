/*							
 * Copyright(C) 2023,  FPT University.							
 * Geographic Management							
 * Manage information of easr asia country				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-25>       <1.0>          <Nguyen Hoang Manh>     <Manage information of easr asia country	 List>							
 */
package program;

import operations.Menu;
import operations.ManageEastAsiaCountries;
import java.util.ArrayList;
import object.Country;

/**
 * This class is for user/tester to use the program without the need to look at method details
 * 
 * <p>Note: This class also user to add menu option if needed
 * , but user must also writing a function for that options in ManageEastAsiaCountries Class
 * @author Nguyen Hoang Manh
 */
public class GeographicManagement {
    
    private final static int MAX = 2;
    
    /**
     * Get input from user
     * Input information of 11 countries in East Asia
     * Display information of countries
     * Search the information of country
     * Display the information of countries sorted name in ascending
     * @param args 
     */
    public static void main(String[] args) {
        
        ArrayList<Country> countryList = new ArrayList<>();
        
        Menu menu = new Menu();
        menu.add("Input the information of 11 countries in East Asia");
        menu.add("Display the information of country you've just input");
        menu.add("Search the information of country by user-entered name");
        menu.add("Display the information of countries sorted name in ascending");
        menu.add("Exit");
        
        ManageEastAsiaCountries operations = new ManageEastAsiaCountries();
        //loop until user want to exist
        int userChoice;
        while (true) {
            System.out.println("\nGEOGRAPHIC MANAGEMENT");
            userChoice = menu.getUserChoice();
            switch (userChoice) {
                case 1:
                    for(int i = 0; i < MAX; i++) {
                       operations.inputCountry(countryList); 
                    }                    
                    break;
                case 2:
                    operations.printCountry(countryList);
                    break;
                case 3:
                    operations.searchByName(countryList);
                    break;
                case 4:
                    operations.printCountrySorted(countryList);
                    break;
                case 5:
                    return;
            }
        }
    }
}
