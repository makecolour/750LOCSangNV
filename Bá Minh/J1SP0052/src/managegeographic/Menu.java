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

import java.util.Vector;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class provide the menu for user
 *
 * @author Nguyen Ba Duc Minh
 */
public class Menu extends Vector<String> {

    /**
     * Default constructor
     */
    public Menu() {
        super();
        this.addMenuItem("1. Enter the information for 11 countries in Southeast Asia");
        this.addMenuItem("2. Display the information of country you've just input");
        this.addMenuItem("3. Search the information of country by user-entered name");
        this.addMenuItem("4. Display the information of countries sorted name in ascending order");
        this.addMenuItem("5. Exit");
    }

    /**
     * Add the item for menu
     *
     * @param S A string item to be added
     */
    private void addMenuItem(String S) {
        this.add(S);
    }

    /**
     * Display all the menu item and get the user choice
     *
     * @return an integer value
     */
    int getUserChoice() {
        System.out.printf("%30s", "Menu\n");
        System.out.println("======================================================================");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%d-%s\n", i + 1, elementAt(i));
        }
        System.out.println("======================================================================");
        boolean cond = true;
        int input = 0;

        while (cond) {
            System.out.print("Select 1..5: ");
            boolean mis = false;
            Scanner scn = new Scanner(System.in);
            try {
                input = scn.nextInt();
            } catch (InputMismatchException e) {
                MyLog.getLogger().warning("ERROR: INTEGER-type INPUT, please try again");
                cond = true;
                mis = true;
            }
            if ((input <= 0 || input > 5 || input != (int) input) && mis == false) {
                MyLog.getLogger().warning("ERROR: POSITIVE INTEGER-type INPUT in range [1-5], please try again");
                cond = true;
            } else if (mis == false) {
                cond = false;
            }
            if (cond == false) {
                break;
            }
        }

        return input;
    }
}
