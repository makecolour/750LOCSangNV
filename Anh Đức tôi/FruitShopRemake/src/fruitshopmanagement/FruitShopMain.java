/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Fruit shop management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
 */
package fruitshopmanagement;

/**
 * This class contains the main method for implementing the Fruit management
 * project
 *
 * @author Nguyen Ba Duc Minh
 */
public class FruitShopMain {

    /**
     * Ask user for inputting choice createFruit viewOrders shopping
     *
     * @param args
     */
    public static void main(String[] args) {
        FruitShopManagementSystem fruitMangae = new FruitShopManagementSystem();
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    fruitMangae.createFruit();
                    break;
                case 2:
                    fruitMangae.viewOrders();
                    break;
                case 3:
                    fruitMangae.shopping();
                    break;
                case 4:
                    return;
            }
        }
    }

    /**
     * This method provide a menu for user's choice
     *
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
