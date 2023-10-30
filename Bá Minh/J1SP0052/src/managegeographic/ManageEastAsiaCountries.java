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

import java.util.ArrayList;
import java.util.Collections;

/**
 * This class provides method for adding, searching, sorting all the input
 * countries
 *
 * @author Nguyen Ba Duc Minh
 */
public class ManageEastAsiaCountries {

    private final static ArrayList<EastAsiaCountries> listCountries = new ArrayList<>();
    private EastAsiaCountries recentlyAdd;

    /**
     * Default constructor
     */
    public ManageEastAsiaCountries() {
    }

    /**
     * Ask User for inputting information for 11 countries
     */
    public void addCountryInformation() {
        boolean option = false;
        do {
            do {
                do {
                    recentlyAdd = new EastAsiaCountries();
                    recentlyAdd.setCountryCode(UserInput.getLine("Enter code of country: "));
                    recentlyAdd.setCountryName(normalize(UserInput.getLine("Enter name of country: ")));
                    recentlyAdd.setToltalArea(UserInput.getFloat("Enter total Area: "));
                    recentlyAdd.setCountryTerrain(UserInput.getLine("Enter terrain of country: "));
                    if (!checkValiddata(recentlyAdd)) {
                        MyLog.getLogger().warning("Invalid data, check your country Id or total area again!");
                    } else {
                        listCountries.add(recentlyAdd);
                        break;
                    }
                } while (true);
                if (listCountries.size() >= 3) {
                    option = checkInputYN("Do you want to continue: ");
                }
            } while (option);
        } while (listCountries.size() < 3);
    }

    /**
     * This method normalize the string input
     *
     * @param countryName value to normalize
     * @return
     */
    private String normalize(String countryName) {
        String[] Split = countryName.trim().split("[\\s]+");
        countryName = "";

        for (String a : Split) {
            countryName += a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase() + " ";
        }
        countryName = countryName.trim();
        return countryName;
    }

    /**
     * Print out the recently added country
     */
    public void getRecentlyEnteredInformation() {
        if (recentlyAdd != null) {
            this.showFormat();
            this.recentlyAdd.display();
            return;
        }
        MyLog.getLogger().info("You have not added any info yet!");
    }

    /**
     * Ask user input a name for searching the country
     *
     * @param name User input name for searching
     */
    public void searchInformationByName(String name) {
        if (listCountries.isEmpty()) {
            MyLog.getLogger().info("This list is empty!");
            return;
        }
        for (EastAsiaCountries country : listCountries) {
            if (normalize(name).equalsIgnoreCase(country.getCountryName())) {
                this.showFormat();
                country.display();
                return;
            }
        }
        MyLog.getLogger().info(String.format("Country name: [%s] not exists", name));
    }

    /**
     * Check whether the country's data valid or not
     *
     * @param totalArea to check
     * @param countryCode to check
     * @return
     */
    private boolean checkValiddata(EastAsiaCountries country) {
        if (country.getTotalArea() <= 0) {
            return false;
        }
        for (EastAsiaCountries checkCountry : listCountries) {
            if (checkCountry.getCountryCode().equalsIgnoreCase(country.getCountryCode())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sort the ArrayList of EastAsiaCountryes in Ascending order by country
     * name
     */
    public void sortInformationByAscendingOrder() {
        if (listCountries.isEmpty()) {
            MyLog.getLogger().info("This list is empty!");
            return;
        }
        Collections.sort(listCountries, new EastAsiaCountries());
        showAllCountries(listCountries);
    }

    /**
     * Print out the format to display data on screen
     */
    private void showFormat() {
        System.out.printf("%-25s%-20s%-20s%-20s\n", "Id", "Name", "Total Area", "Terrain");
    }

    /**
     * Print out all the countries in the ArrayList
     *
     * @param t The ArrayList of countries
     */
    private void showAllCountries(ArrayList<EastAsiaCountries> t) {
        showFormat();
        for (EastAsiaCountries country : t) {
            country.display();
        }
    }

    /**
     * Check the user input y/Y or n/N
     *
     * @param mess The message to ask user for inputting data
     * @return a true or false value
     */
    private boolean checkInputYN(String mess) {
        while (true) {
            String result = UserInput.getLine(mess);
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }

            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            MyLog.getLogger().warning("Please input y/Y or n/N.");
            System.out.println("Enter again! ");
        }
    }
}
