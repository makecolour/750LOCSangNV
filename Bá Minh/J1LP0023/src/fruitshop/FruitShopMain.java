/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Fruit shop management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
*/
package fruitshop;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class contains the main method for implementing the Fruit management project
 * @author Dell
 */
public class FruitShopMain {
    public static void main(String[] args)
    {
        ArrayList<Fruit> listFruit = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> customerInfo = new Hashtable<>();

        while(true) {
            int choice = menu();
            switch(choice) {
                case 1:
                    FruitShopManagementSystem.createFruit(listFruit);
                    break;
                case 2:
                    FruitShopManagementSystem.viewOrders(customerInfo);
                    break;
                case 3:
                    FruitShopManagementSystem.shopping(listFruit, customerInfo);
                    break;
                case 4:
                    return;
            }
        }
    }

    /**
     * This method provide a menu for user's choice
     * @return an integer
     */
    static int menu() {
        System.out.println("1. Create Fruit: ");
        System.out.println("2. View orders: ");
        System.out.println("3. Shopping (for buyer): ");
        System.out.println("4. Exit: ");
        int choice = UserInput.getInt("Enter your choice: ");
        return choice;
    }
}

