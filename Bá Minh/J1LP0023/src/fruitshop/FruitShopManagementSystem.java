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
import java.util.Scanner;

/**
 * This class provide method for creating fruit and order fruit
 *
 * @author Dell
 */
public class FruitShopManagementSystem {

    /**
     * Input a list of fruit with fruitId, fruitName, fruitPrice, fruitQuantity,
     * fruitOrigin
     *
     * @param listFruit An ArrayList contain Fruit
     */
    public static void createFruit(ArrayList<Fruit> listFruit) {
        String id;
        do {
            do {
                id = UserInput.getLine("Enter fruit id:");
            } while (!checkFruitId(id, listFruit));
            String name = UserInput.getLine("Enter fruit name:");
            double price = UserInput.getDouble("Enter fruit price:");
            int quantity = UserInput.getInt("Enter fruit quantity: ");
            String origin = UserInput.getLine("Enter fruit origin:");
            listFruit.add(new Fruit(id, name, price, quantity, origin));
        } while (checkInputYN("Do you want to continue (Y/N)?"));
    }

    /**
     * Display an ArrayList of Fruit
     *
     * @param listFruit The ArrayList of Fruit to be displayed
     */
    public static void displayFruit(ArrayList<Fruit> listFruit) {
        int item = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit f : listFruit) {
            System.out.printf("%-10d%-20s%-20s%-1.0f$\n", item,
                    f.getName(), f.getOrigin(),
                    f.getPrice());
            item++;
        }
    }

    /**
     * Asking user input an item to order fruit and add the ordered fruit into
     * an ArrayList
     *
     * @param listFruit The ArrayList store all the Fruit in the store
     * @return an ArrayList of ordered fruit
     */
    private static ArrayList<Order> waitToOrderList(ArrayList<Fruit> listFruit) {
        ArrayList<Order> listOrder = new ArrayList<>();
        do {
            displayFruit(listFruit);
            int count = 1;
            int flag = 0;
            int item = validateInput("Enter fruit item: ", 1, listFruit.size());
            for (Fruit f : listFruit) {
                if (count == item) {
                    if (f.getQuantity() == 0) {
                        MyLog.getLogger().info(String.format(f.getName() + " is sold out!"));
                        break;
                    }
                    System.out.println("You selected: " + f.getName());
                    int quantity = validateInput("Please input quantity: ", 1, f.getQuantity());
                    f.setQuantity(f.getQuantity() - quantity);
                    for (Order o : listOrder) {
                        if (o.getName().equals(f.getName())) {
                            o.setQuantity(o.getQuantity() + quantity);
                            flag = 1;
                            break;
                        }
                    }
                    if (flag != 1) {
                        listOrder.add(new Order(f.getId(), f.getName(), quantity, f.getPrice()));
                    }
                    break;
                }
                count++;
            }
        } while (!checkInputYN("Do you want to order now (Y/N): "));
        return listOrder;
    }

    /**
     * Check whether the list_F is empty or not. If empty the method return If
     * not it calls the waitToOrderList method, receiving the list of ordered
     * fruit ask customers to input their name and put both the values into a
     * HashTable ht
     *
     * @param listFruit The ArrayList of fruit in the store
     * @param customerInfo The HashTable contain name of customers and the
     * ArrayList of order correspond to
     */
    public static void shopping(ArrayList<Fruit> listFruit, Hashtable<String, ArrayList<Order>> customerInfo) {
        if (listFruit.isEmpty()) {
            MyLog.getLogger().info("There're no available products!");
            return;
        }
        ArrayList<Order> listOrder = waitToOrderList(listFruit);
        displayListOrder(listOrder);
        String customer = UserInput.getLine("Enter name of customer: ");
        if (customerInfo.get(customer) != null) {
            for (Order order : listOrder) {
                int flag = 0;
                for (Order o : customerInfo.get(customer)) {
                    if (o.getName().equals(order.getName())) {
                        o.setQuantity(o.getQuantity() + order.getQuantity());
                        flag = 1;
                        break;
                    }
                }
                if (flag != 1) {
                    customerInfo.get(customer).add(new Order(order.getId(), order.getName(), order.getQuantity(), order.getPrice()));
                    break;
                }
            }
        } else {
            customerInfo.put(customer, listOrder);
        }
    }

    /**
     * Display the order list of fruit
     *
     * @param listOrder The ArrayList contain the order
     */
    private static void displayListOrder(ArrayList<Order> listOrder) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : listOrder) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    /**
     * Display all the fruit order
     *
     * @param customerInfo The HashTable with key is a String of customer's name
     * correspond to value of ArrayList of Order
     */
    public static void viewOrders(Hashtable<String, ArrayList<Order>> customerInfo) {
        if (customerInfo.isEmpty()) {
            MyLog.getLogger().info("No order");
            return;
        }
        for (String name : customerInfo.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> listOrder = customerInfo.get(name);
            displayListOrder(listOrder);
        }
    }

    /**
     * Validate whether the user input is valid or not
     *
     * @param mess The message ask the user for inputting data
     * @param min The min value to check user input
     * @param max The max value to check user input
     * @return an integer value
     */
    private static int validateInput(String mess, int min, int max) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mess);
        while (true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                //check range of number
                if (number < min || number > max) {
                    MyLog.getLogger().warning(String.format("Please input between [%d], [%d]", min, max));
                    continue;
                }
                return number;
            } catch (Exception e) {
                MyLog.getLogger().warning("Please input an integer number: ");
            }
        }
    }

    private static boolean checkFruitId(String id, ArrayList<Fruit> listFruit) {
        for (Fruit fruit : listFruit) {
            if (id.equalsIgnoreCase(fruit.getId())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check the user for inputting y/Y or n/N
     *
     * @param mess The message to ask user for inputting data
     * @return
     */
    private static boolean checkInputYN(String mess) {
        Scanner sc = new Scanner(System.in);
        System.out.print(mess);
        while (true) {
            String result = sc.nextLine();

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
