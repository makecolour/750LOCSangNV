/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Geography management program> :				
 * <Create a Java console program to manage geography.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program to manage the geographic. >				
 */
package manage;

import entity.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The `ManageEastAsiaCountries` class is responsible for managing a list of
 * East Asian countries. It provides methods for adding, displaying, searching,
 * and sorting East Asian countries in the list
 *
 * @author Trần Đức Anh
 */
public class ManageEastAsiaCountries {

    private ArrayList<EastAsiaCountries> countryList;

    /**
     * Default constructor for the `ManageEastAsiaCountries` class. Initializes
     * an empty list of East Asian countries.
     */
    public ManageEastAsiaCountries() {
        countryList = new ArrayList<>();
        //countryList.add(new EastAsiaCountries("nice", "1", "Aiet", 12334));
        //countryList.add(new EastAsiaCountries("nice", "2", "Dhai", 56464));
        //countryList.add(new EastAsiaCountries("nice", "3", "Campodia", 156456));
        //countryList.add(new EastAsiaCountries("nice", "4", "Bndonesia", 996456));
    }

    /**
     * Constructor for the `ManageEastAsiaCountries` class that allows
     * initializing the list of East Asian countries with an existing ArrayList.
     *
     * @param countryList The initial list of East Asian countries.
     */
    public ManageEastAsiaCountries(ArrayList countryList) {
        this.countryList = countryList;
    }

    /**
     * The `addCountry` method allows the user to add a new East Asian country
     * to the list. It prompts the user to enter the country code, name, total
     * area, and terrain type and adds the new country to the list.
     */
    public void addCountry() {
        String text = null;
        int i = 0;
        String confirm = null;
        do {
            EastAsiaCountries newCountry = new EastAsiaCountries();
            newCountry.setCountryCode(InputUser.getUniqueCode("east asia country code", countryList));
            newCountry.setCountryName(InputUser.getUniqueName("east asia country name", text, countryList));
            newCountry.setTotalArea(InputUser.getFloat("area", 0, Float.MAX_VALUE));
            newCountry.setCountryTerrain(InputUser.getString("terrain", text));
            System.out.println("This east country has been created");
            countryList.add(newCountry);
            System.out.println("Do you want to continue");
            do {
                confirm = InputUser.getString("Y/N", text);
                if ("y".equalsIgnoreCase(confirm) || "n".equalsIgnoreCase(confirm)) {
                    break;
                } else {
                    System.out.println("Error choice");
                }
            } while (true);
        } while (confirm.equalsIgnoreCase("y"));
    }

    /**
     * The `displayCountry` method displays the list of East Asian countries. If
     * the list is empty, it prints a message indicating that there are no
     * countries. Otherwise, it prints a table showing the country ID, name,
     * total area, and terrain type.
     */
    public void displayCountry() {
        if (countryList.isEmpty()) {
            System.err.println("There is no country");
        } else {
            System.out.println("ID    Name       Total Area      Terrain");
            for (EastAsiaCountries eastAsiaCountries : countryList) {
                System.out.println(eastAsiaCountries);
            }
        }
    }

    /**
     * The `searchCountry` method allows the user to search for East Asian
     * countries by name. It prompts the user to enter a search term, and it
     * displays a list of countries whose names contain the search term in a
     * table format.
     */
    public void searchCountry() {
        String text = null;
        ArrayList<EastAsiaCountries> countryListFound = new ArrayList<>();
        if (countryList.isEmpty()) {
            System.err.println("There is no country");
        } else {
            String name = InputUser.getString("east asia country name to search", text);
            for (EastAsiaCountries eastAsiaCountries : countryList) {
                if (eastAsiaCountries.getCountryName().toLowerCase().contains(name.toLowerCase())) {
                    countryListFound.add(eastAsiaCountries);
                }
            }
            if (countryListFound.isEmpty()) {
                System.out.println("No contry found");
            } else {
                System.out.println("ID    Name       Total Area      Terrain");
                for (EastAsiaCountries eastAsiaCountries : countryListFound) {
                    System.out.println(eastAsiaCountries);
                }
            }
        }
    }

    /**
     * The `sortCountry` method sorts the list of East Asian countries
     * alphabetically by name and then displays the sorted list in a table
     * format. If the list is empty, it prints a message indicating that there
     * are no countries to sort.
     */
    public void sortCountry() {
        if (countryList.isEmpty()) {
            System.err.println("There is no country");
        } else {
            Collections.sort(countryList);
            displayCountry();
        }
    }
}
