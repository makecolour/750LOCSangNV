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

/**
 * This class contains the main method for implementing the geographic
 * management project
 *
 * @author Nguyen Ba Duc Minh
 */
public class GeographicManagementMain {

    /**
     * Ask user for inputting choice addCountryInformation
     * getRecentlyEnteredInformation searchInformationByName
     * sortInformationByAscendingOrder
     *
     * @param args
     */
    public static void main(String[] args) {
        ManageEastAsiaCountries countryList = new ManageEastAsiaCountries();
        Menu menu = new Menu();
        int userChoice;
        do {
            userChoice = menu.getUserChoice();
            switch (userChoice) {
                case 1:
                    countryList.addCountryInformation();
                    break;
                case 2:
                    countryList.getRecentlyEnteredInformation();
                    break;
                case 3:
                    countryList.searchInformationByName(UserInput.getLine("Enter name of country for searching: "));
                    break;
                case 4:
                    countryList.sortInformationByAscendingOrder();
                    break;
                case 5:
                    System.out.println("Exit!");
                    break;
            }
        } while (userChoice != 5);

    }
}
