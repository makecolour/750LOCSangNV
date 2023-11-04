/*
 * Copyright(C) 2005,  <FPTU>.
 * <0023> :
 *  <Fruit Shop Management System>
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * <26/10/2023>                <1>              <la Minh>                       <base>
 */
package Display;

import Entity.*;
import Manage.*;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Main menu display for interaction and displaying fruit list and order
 *
 * @author La Minh
 */
public class Display {

    /**
     * main - runtime
     * @param args
     */
    public static void main(String[] args) {
        //Method call
        Manager manager = new Manager();
        Input input = new Input();
        
        // Create new table
        ArrayList<Fruit> fruitList = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> orderTable = new Hashtable<>();
        
        //test
        fruitList.add(new Fruit(1, "Apple", 3, 20, "Vietnam"));
        fruitList.add(new Fruit(2, "Banana", 4, 10, "Brazil"));
        fruitList.add(new Fruit(3, "Grape", 2, 40, "Thailand"));
        fruitList.add(new Fruit(4, "Orange", 2, 50, "Russia"));
        
        while (true) {
            
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            switch (input.checkLimit(1, 4)){
                // make new fruit
                case 1: manager.createFruit(fruitList); break;
                // view existing order
                case 2: manager.viewOrder(orderTable); break;
                // make new order
                case 3: manager.shopping(fruitList, orderTable); break;
                // end
                case 4: return;
            }
        }   
    }

    /**
     * display the order in list for user to see
     * @param lo the order list
     */
    public void displayListOrder(ArrayList<Order> lo) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : lo) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    /**
     * display all the fruit for user to see
     * @param fl the fruit list
     */
    public void displayAllFruit(ArrayList<Fruit> fl) {
        System.out.printf("%15s%15s%15s%15s%15s\n", "ID", "Name", "Price", "Quantity", "Origin");
        for (Fruit f : fl) {
            if (f.getQuantity() != 0){
                System.out.printf("%15s%15s%15d$%15dx%15s\n",
                        f.getFruitID(), f.getFruitName(), f.getPrice(), f.getQuantity(), f.getOrigin());
            }
        }
    }
}
