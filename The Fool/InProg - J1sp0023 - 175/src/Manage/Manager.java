/*
 * Copyright(C) 2005,  <FPTU>.
 * <0023> :
 *  <Fruit Shop Management System>
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * <26/10/2023>                <1>              <la Minh>                       <base>
 */
package Manage;

import Display.*;
import Entity.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

/**
 * Main program logic to execute choices and generation
 *
 * @author La Minh
 */
public class Manager {
    
    private final Input input = new Input();
    private final Display d = new Display();
    private final ErrorLog erl = new ErrorLog();
    private final String className = Manager.class.getName();

    /**
     * create fruit and then add to the list
     * 
     * @param fl the fruit list
     */
    public void createFruit(ArrayList<Fruit> fl){
        System.out.print("New fruit ID is: ");
        int id = generateID(fl);
        System.out.println(id);
        
        String fruitName = input.checkString("Enter fruit name: ");
        int price = input.checkInt("Enter fruit price: ");
        int quantity = input.checkInt("Enter fruit amount: ");
        String origin = input.checkString("Enter fruit origin: ");

        if (input.checkYN()){
            fl.add(new Fruit(id, fruitName, price, quantity, origin));
            System.out.println("Add fruit success");
        } else {
            System.out.println("Cancelled adding fruit");
        }
    }

    /**
     * allow user to view the order they made
     * 
     * @param oT the order list and the table that come with it
     */
    public void viewOrder(Hashtable<String, ArrayList<Order>> oT){
        for (String name : oT.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> lo = oT.get(name);
            d.displayListOrder(lo);
        }
    }

    /**
     *allow the user to specify which item they want to take and make order upon it
     * 
     * @param fruitList the fruit list
     * @param orderTable the order list and table that come with it
     */
    public void shopping(ArrayList<Fruit> fruitList, Hashtable<String, ArrayList<Order>> orderTable){

        int flag = 0;
        //check if shop is empty
        if (fruitList.isEmpty()){
            erl.Log(className, "Shop is empty");
        }

        //If shop is stocked
        ArrayList<Order> newList = new ArrayList<>();
        do {
            d.displayAllFruit(fruitList);

            System.out.print("Enter item: ");
            int item = input.checkLimit(1, fruitList.size());

            Fruit fruit = getFruitByItem(fruitList, item);

            System.out.print("Enter quantity: ");
            int quantity = input.checkLimit(1, fruit.getQuantity());
            
            //check item exist or not
            System.out.println("Add item to cart ?");
            if(input.checkYN()){
                //wanted to add
                if (!input.exisitingItem(newList, fruit.getFruitID())) {
                    //added to exisiting item
                    updateOrder(newList, fruit.getFruitID(), quantity);

                } else {
                    //new
                    newList.add(new Order(fruit.getFruitID(), fruit.getFruitName(), quantity, fruit.getPrice()));
                }
                fruit.setQuantity(fruit.getQuantity() - quantity);
                System.out.println("Added successfully");
            } else {
                System.out.println("Cancelled adding");
            }
            
               
            System.out.println("Continue? ");
        } while (input.checkYN());


        if (newList.isEmpty()){
            System.out.println("Order empty. Cancelling");
            return;
        } else {
            d.displayListOrder(newList);
        }
        
        //finishing
        String name = input.checkString("Please enter name: ");
        
        //check if user exist
        if (orderTable.get(name) != null){
            //check if overwite
            System.out.println("User exist do you want to continue? ");
            if (!input.checkYN()) {
                ArrayList<Order> currentOrder = orderTable.get(name);
                //check for each item and then add to list
                for (Order order : newList) {
                    for (Order cOrder : currentOrder) {
                        if (order.getFruitId() == cOrder.getFruitId()) {
                            updateOrder(currentOrder, order.getFruitId(), order.getQuantity());
                            flag = 1;
                            break;
                        }
                    }
                    if (flag != 1) {
                        currentOrder.add(order);
                    }
                    flag = 0;
                }
            } 
            // overwrite
            else {
                System.out.println("Are you new customer? ");
                if (input.checkYN()) {
                    Set<String> keys = orderTable.keySet();
                    int count = 0;
                    for (String countName : keys){
                        if (countName.equals(name)){
                            count++;
                        }
                    }
                    String newName = name + " - " + count;
                    orderTable.put(newName, newList);
                } else {
                    orderTable.put(name, newList);
                    System.out.println("Overwite success!");
                }

            }
        } 
        //new
        else {
            orderTable.put(name, newList);
        }
        
        System.err.println("Add successfull");
    }
    
    /**
     * create a unique id that will be created upon making a fruit and has check if missing in middle
     * 
     * @param fl the fruit list
     * @return the unique ID
     */
    private int generateID(ArrayList<Fruit> fl){
        int id = 1;
        boolean idAdded = false;
        if (!fl.isEmpty()) {
            if (fl.size() >= 2) {
                //check if missing more than 1 item between 2 undelete value
                for (int i = 0; i < fl.size() - 1; i++)
                    if (fl.get(i + 1).getFruitID() - fl.get(i).getFruitID() > 1) {
                        id = fl.get(i).getFruitID() + 1;
                        idAdded = true;
                    }
            }
            if (!idAdded) {
                id = fl.get(fl.size() - 1).getFruitID() + 1;
            }
        }
        return id;
    }

    /**
     * check if shop have the shop or not
     * @param fl the fruit list
     * @param item id ?
     * @return the fruit name and selection
     */
    private Fruit getFruitByItem(ArrayList<Fruit> fl, int item) {
        int countItem = 1;
        for (Fruit fruit : fl) {
            //check shop have item or not
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }

    /**
     * change order if user choose the item twice
     * @param lo the order table
     * @param id id of the fruit
     * @param quantity amount of fruit choosen
     */
    private void updateOrder(ArrayList<Order> lo, int id, int quantity) {
        for (Order order : lo) {
            if (order.getFruitId() == id) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }
    
}
