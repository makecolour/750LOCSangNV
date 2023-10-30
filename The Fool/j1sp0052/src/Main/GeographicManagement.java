/*							
 * Copyright(C) 2023,  FPT University.							
 * Geographic Management							
 * Manage information of east asia country				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-30>       <1.0>          <La Dieu Minh>     <Manage information of east asia country List>							
 */
package Main;

import Operation.*;
import Object.Country;

import java.util.ArrayList;


/**
 * This class is for user/tester to use the program without the need to look at method details
 *
 * @author La Dieu Minh
 */
public class GeographicManagement {

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
        menu.add("Display the information of countries sorted name in descending order");
        menu.add("Exit");

        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        //loop until user want to exist
        while (true) {
            System.out.println("\nGEOGRAPHIC MANAGEMENT");
            switch (menu.getUserChoice()) {
                case 1:
                    for(int i = 0; i < 2; i++) {
                        manager.inputCountry(countryList);
                    }
                    break;
                case 2:
                    manager.printCountry(countryList);
                    break;
                case 3:
                    manager.searchByName(countryList);
                    break;
                case 4:
                    manager.printCountrySorted(countryList);
                    break;
                case 5:
                    return;
            }
        }
    }
}
