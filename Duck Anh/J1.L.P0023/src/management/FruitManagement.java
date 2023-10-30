/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Create a Java console program to manage a Fruit Shop (Product and Shopping).> :				
 * <program allow user manage fruit information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-30>      <8.2>     <AnhTD>        <Create a Java console program to manage a Fruit Shop (Product and Shopping).>				
 */
package management;

import entity.Customer;
import entity.Fruit;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

/**
 * The FruitManagement class represents a system for managing fruits and orders.
 * It includes methods for creating fruits, viewing orders, and facilitating the
 * shopping process. The class also utilizes a list of fruits and a hash table
 * to store customer orders.
 *
 * @author Tran Duc Anh
 */
public class FruitManagement {

    private ArrayList<Fruit> fList;
    private Hashtable<Customer, ArrayList<Fruit>> orderList;

    /**
     * Default constructor for FruitManagement. Initializes the list of fruits
     * and the order hash table.
     */
    public FruitManagement() {
        fList = new ArrayList<>();
        orderList = new Hashtable<>();
        //fList.add(new Fruit("1", "Banana", 10, 5, "VietNam"));
        //fList.add(new Fruit("2", "Mango", 4, 8, "Thai"));
    }

    /**
     * Parameterized constructor for FruitManagement. Allows for initialization
     * with existing lists of fruits and orders.
     *
     * @param fList The list of fruits to be managed.
     * @param orderList The hash table containing customer orders.
     */
    public FruitManagement(ArrayList<Fruit> fList, Hashtable<Customer, ArrayList<Fruit>> orderList) {
        this.fList = fList;
        this.orderList = orderList;
    }

    /**
     * Creates a new fruit by obtaining user input for its properties. The
     * process can be repeated based on user confirmation.
     */
    public void createFruit() {
        String text = null;
        String confirm = null;
        do {
            Fruit newFruit = new Fruit();
            newFruit.setFruitId(GetUserInput.getId("Enter fruit id: ", fList));
            newFruit.setFruitName(GetUserInput.getFruitName("Enter fruit name: ", fList));
            newFruit.setPrice(GetUserInput.getDouble("Enter fruit price: ", 0, 10000));
            newFruit.setOrigin(GetUserInput.getString("Enter origin: ", text));
            newFruit.setQuantity(GetUserInput.getInt("Enter fruit quantity: ", 0, 10000));
            fList.add(newFruit);
            //fList.get(fList.indexOf(newFruit)).setFruitId(String.valueOf(fList.indexOf(newFruit)));

            System.err.println("This fruit has been created");
            confirm = confirmYesNo(text, "Do you want to continue (Y/N)? ");
        } while (confirm.equalsIgnoreCase("y"));
    }

    /**
     * Displays information about customer orders, including product details and
     * totals. If there are no orders, a message indicating so is printed.
     */
    public void viewOrder() {

        if (orderList.isEmpty()) {
            System.err.println("There is no order");
        } else {
            for (Map.Entry<Customer, ArrayList<Fruit>> entry : orderList.entrySet()) {
                System.out.println("Customer: " + entry.getKey().getName() + "\n   Product   | Quantity | Price | Amount");
                double total = 0;
                for (int i = 0; i < entry.getValue().size(); i++) {
                    System.out.println((i + 1) + "." + entry.getValue().get(i).toOrderString());
                    total += entry.getValue().get(i).getQuantity() * entry.getValue().get(i).getPrice();
                }
                System.out.println("Total: " + total);
            }
        }
    }

    /**
     * Facilitates the shopping process, allowing customers to select fruits,
     * place orders, and view the total amount. The orders are then associated
     * with the customer's name.
     */
    public void shopping() {
        double total = 0;
        String ask = null;
        String customerName = null;
        ArrayList<Fruit> newOrderList = new ArrayList<>();
        if (fList.isEmpty()) {
            System.err.println("There is no fruit in stock");
        } else {
            do {
                System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
                for (int i = 0; i < fList.size(); i++) {
                    System.out.println("|      " + (i + 1) + "     " + fList.get(i));
                }
                int index = GetUserInput.getInt("Enter item: ", 1, fList.size()) - 1;
                System.err.println("You selected: " + fList.get(index).getFruitName());
                Fruit newOrder = null;

                int flag = 0;
                if (newOrderList.isEmpty() == false) {
                    for (int i = 0; i < newOrderList.size(); i++) {
                        if (fList.get(index).getFruitId().equals(newOrderList.get(i).getFruitId())) {
                            int duplicatedQuantity = GetUserInput.getInt("Please input quantity: ", 0, fList.get(index).getQuantity());
                            newOrderList.get(i).setQuantity(newOrderList.get(i).getQuantity() + duplicatedQuantity);
                            //update quantity in fruit stock
                            fList.get(index).setQuantity(fList.get(index).getQuantity() - duplicatedQuantity);
                            flag = 1;
                            break;
                        }
                    }
                }
                if (flag == 0) {
                    newOrder = new Fruit(fList.get(index).getFruitId(),
                            fList.get(index).getFruitName(),
                            fList.get(index).getPrice(),
                            (GetUserInput.getInt("Please input quantity: ", 0, fList.get(index).getQuantity())),
                            fList.get(index).getOrigin());
                    if (newOrder.getQuantity() != 0) {
                        newOrderList.add(newOrder);
                        //update quantity in fruit stock
                        fList.get(index).setQuantity(fList.get(index).getQuantity() - newOrder.getQuantity());
                    }
                }

                ask = confirmYesNo(ask, "Do you want to order now (Y/N): ");
                if (ask.equalsIgnoreCase("y")) {
                    System.out.println(" Product   | Quantity | Price | Amount");
                    for (Fruit order : newOrderList) {
                        System.out.println(order.toOrderString());
                        total += order.getQuantity() * order.getPrice();
                    }
                    System.out.println("Total: " + total);
                }
            } while (ask.equalsIgnoreCase("n"));
            Customer newCustomer = new Customer(checkName(customerName));

            orderList.put(newCustomer, newOrderList);
        }

    }

    /**
     * Private helper method to confirm user input (Yes/No).
     *
     * @param confirm The user's input to be confirmed.
     * @param msg The message prompting the user for confirmation.
     * @return The confirmed user input ("Y" for Yes, "N" for No).
     */
    private String confirmYesNo(String confirm, String msg) {
        do {
            System.out.print(msg);
            confirm = GetUserInput.getString("", confirm);
            if (confirm.equalsIgnoreCase("Y") || confirm.equalsIgnoreCase("N")) {
                return confirm;
            } else {
                System.err.println("Error");
            }
        } while (true);
    }

    /**
     * Checks if a customer name already exists in the orderList.
     *
     * This method continuously prompts the user to enter a name until a name
     * that doesn't exist in the orderList is provided. If a matching name is
     * found, it informs the user that the name already exists.
     *
     * @param customerName The name to be checked against existing entries in
     * the orderList.
     * @return The unique customer name that is not already in the orderList.
     */
    private String checkName(String customerName) {
        do {
            customerName = GetUserInput.getString("Enter name to finish ordering: ", customerName);
            for (Map.Entry<Customer, ArrayList<Fruit>> entry : orderList.entrySet()) {
                if (customerName.equalsIgnoreCase(entry.getKey().getName())) {
                    System.err.println("Name existed");
                    customerName = null;
                }
            }
            if (customerName != null) {
                return customerName;
            }
        } while (true);
    }
}
