/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Matrices calculation
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
 */
package calculatingmatrices;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class provide the menu for user
 *
 * @author Dell
 */
public class Menu extends ArrayList<String> {

    /**
     * Default constructor
     */
    public Menu() {
        super();
        this.addMenuItem("1. Addition Matrix");
        this.addMenuItem("2. Subtraction Matrix");
        this.addMenuItem("3. Multiplication Matrix");
        this.addMenuItem("4. Quit");
    }

    /**
     * Add the item for menu
     *
     * @param S A string item to be added
     */
    void addMenuItem(String S) {
        this.add(S);
    }

    /**
     * Display all the menu item and get the user choice
     *
     * @return an integer value
     */
    int getUserChoice() {
        System.out.println("========Calculator Program==========");
        for (int i = 0; i < this.size(); i++) {
            System.out.printf("%d-%s\n", i + 1, this.get(i));
        }
        System.out.println("______________________");
        boolean cond = true;
        int input = 0;

        while (cond) {
            System.out.print("Select 1..4: ");
            boolean mis = false;
            Scanner scan = new Scanner(System.in);
            try {
                input = scan.nextInt();
            } catch (InputMismatchException e) {
                MyLog.getLogger().warning("ERROR: INTEGER-type INPUT, please try again");
                cond = true;
                mis = true;
            }
            if ((input <= 0 || input > this.size() || input != (int) input) && mis == false) {
                MyLog.getLogger().warning("ERROR: POSITIVE INTEGER-type INPUT in range [1-4], please try again");
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
