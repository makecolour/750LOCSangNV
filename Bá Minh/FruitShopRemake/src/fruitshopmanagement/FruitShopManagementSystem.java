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

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * This class provide method for creating fruit and order fruit
 *
 * @author Nguyen Ba Duc Minh
 */
public class FruitShopManagementSystem {

    private static int fruitId = 0;
    private final ArrayList<Fruit> listFruit = new ArrayList<>();
    private final Hashtable<String, Customer> customerInfo = new Hashtable<>();

    /**
     * Default constructor
     */
    public FruitShopManagementSystem() {
    }

    /**
     * Input a list of fruit with fruitId, fruitName, fruitPrice, fruitQuantity,
     * fruitOrigin
     */
    public void createFruit() {
        String fruitName;
        do {
            do {
                fruitName = UserInput.getLine("Enter fruit name: ");
            } while (!checkFruitName(fruitName));
            double fruitPrice = validateFruitPrice("Enter fruit price: ", 1, 1000);
            int fruitQuantity = validateFruitQuantity("Enter fruit quantity: ", 1, 1000);
            String fruitOrigin = UserInput.getLine("Enter fruit origin: ");
            listFruit.add(new Fruit(generateId(), fruitName, fruitPrice, fruitQuantity, fruitOrigin));
        } while (checkInputYN("Do you want to continue (Y/N): "));
    }

    /**
     * Auto generate the fruit id
     *
     * @return an id
     */
    private String generateId() {
        fruitId++;
        return "f" + fruitId;
    }

    /**
     * Display all fruit in stock
     */
    public void displayFruit() {
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (int item = 0; item < listFruit.size(); item++) {
            System.out.printf("%-10d%-20s%-20s%-1.0f$\n", item + 1,
                    listFruit.get(item).getFruitName(), listFruit.get(item).getFruitOrigin(),
                    listFruit.get(item).getFruitPrice());
        }
    }

    /**
     * Asking user input an item to order fruit and add the ordered fruit into
     * an ArrayList
     *
     * @param listFruit The ArrayList store all the Fruit in the store
     * @return an ArrayList of ordered fruit
     */
    private ArrayList<Fruit> addToCart() {
        ArrayList<Fruit> listOrder = new ArrayList<>();
        int item;
        do {
            displayFruit();
            int flag = 0;
            do {
                item = validateFruitQuantity("Enter fruit item: ", 1, listFruit.size());
                if (listFruit.get(item - 1).getFruitQuantity() == 0) {
                    MyLog.getLogger().info(String.format(listFruit.get(item - 1).getFruitName() + " is sold out!"));
                } else {
                    break;
                }
            } while (true);
            System.out.println("You selected: " + listFruit.get(item - 1).getFruitName());
            int quantity = validateFruitQuantity("Please input quantity: ", 1, listFruit.get(item - 1).getFruitQuantity());
            listFruit.get(item - 1).setFruitQuantity(listFruit.get(item - 1).getFruitQuantity() - quantity);
            for (Fruit o : listOrder) {
                if (o.getFruitId().equalsIgnoreCase(listFruit.get(item - 1).getFruitId())) {
                    o.setFruitQuantity(o.getFruitQuantity() + quantity);
                    flag = 1;
                    break;
                }
            }
            if (flag != 1) {
                listOrder.add(new Fruit(listFruit.get(item - 1).getFruitId(), listFruit.get(item - 1).getFruitName(), listFruit.get(item - 1).getFruitPrice(), quantity, listFruit.get(item - 1).getFruitOrigin()));
            }
            if (!checkValueInStock()) {
                MyLog.getLogger().info("All Stock has been sold out, please come back later !");
                break;
            }
        } while (!checkInputYN("Do you want to order now (Y/N): "));
        return listOrder;
    }

    /**
     * Add stock for customer
     */
    public void shopping() {
        if (!checkValueInStock()) {
            MyLog.getLogger().info("There're no available products!");
            return;
        }
        ArrayList<Fruit> listOrder = addToCart();
        displayListOrder(listOrder);
        String customerName = UserInput.getLine("Enter name of customer: ");
        if (customerInfo.get(customerName) != null) {
            for (Fruit order : listOrder) {
                int flag = 0;
                for (Fruit o : customerInfo.get(customerName).getFruitOrder()) {
                    if (o.getFruitId().equalsIgnoreCase(order.getFruitId())) {
                        o.setFruitQuantity(o.getFruitQuantity() + order.getFruitQuantity());
                        flag = 1;
                        break;
                    }
                }
                if (flag != 1) {
                    customerInfo.get(customerName).getFruitOrder().add(new Fruit(order.getFruitId(), order.getFruitName(), order.getFruitPrice(), order.getFruitQuantity(), order.getFruitOrigin()));
                    break;
                }
            }
        } else {
            Customer customer = new Customer(customerName, listOrder);
            customerInfo.put(customerName, customer);
        }
    }

    /**
     * Display the order list of fruit
     *
     * @param listOrder The ArrayList contain the order
     */
    private void displayListOrder(ArrayList<Fruit> listOrder) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit order : listOrder) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getFruitQuantity(), order.getFruitPrice(),
                    order.getFruitPrice() * order.getFruitQuantity());
            total += order.getFruitPrice() * order.getFruitQuantity();
        }
        System.out.println("Total: " + total);
    }

    /**
     * Display all the fruit order
     */
    public void viewOrders() {
        if (customerInfo.isEmpty()) {
            MyLog.getLogger().info("No order");
            return;
        }
        for (String customerName : customerInfo.keySet()) {
            System.out.println("Customer: " + customerName);
            ArrayList<Fruit> listOrder = customerInfo.get(customerName).getFruitOrder();
            displayListOrder(listOrder);
        }
    }

    /**
     * Validate whether the fruit quantity input is valid or not
     *
     * @param mess The message ask the user for inputting data
     * @param min The min value to check user input
     * @param max The max value to check user input
     * @return an integer value
     */
    private int validateFruitQuantity(String mess, int min, int max) {
        while (true) {
            int number = UserInput.getInt(mess);
            //check range of number
            if (number < min || number > max) {
                MyLog.getLogger().warning(String.format("Please input between [%d], [%d]", min, max));
                continue;
            }
            return number;
        }
    }

    /**
     * Validate whether the fruit price input is valid or not
     *
     * @param mess The message ask the user for inputting data
     * @param min The min value to check user input
     * @param max The max value to check user input
     * @return an integer value
     */
    private double validateFruitPrice(String mess, int min, int max) {
        while (true) {
            double number = UserInput.getDouble(mess);
            //check range of number
            if (number < min || number > max) {
                MyLog.getLogger().warning(String.format("Please input between [%d], [%d]", min, max));
                continue;
            }
            return number;
        }
    }

    /**
     * This method check the duplicate of fruit id
     *
     * @param fruitName value to check
     * @return
     */
    private boolean checkFruitName(String fruitName) {

        for (int i = 0; i < listFruit.size(); i++) {
            if (fruitName.equalsIgnoreCase(listFruit.get(i).getFruitName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check for Value in Stock
     *
     * @return a booleanValue
     */
    private boolean checkValueInStock() {
        int stockSoldOut = 0;
        if (listFruit.isEmpty()) {
            return false;
        }
        for (int item = 0; item < listFruit.size(); item++) {
            if (listFruit.get(item).getFruitQuantity() == 0) {
                stockSoldOut++;
            }
        }
        if (stockSoldOut == listFruit.size()) {
            return false;
        }
        return true;
    }

    /**
     * Check the user for inputting y/Y or n/N
     *
     * @param mess The message to ask user for inputting data
     * @return
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
            System.out.print("Enter again: ");
        }
    }
}
