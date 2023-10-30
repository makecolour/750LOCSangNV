/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Create a Java console program to manage a Fruit Shop (Product and Shopping).> :				
 * <program allow user manage fruit information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-30>      <8.2>     <AnhTD>        <Create a Java console program to manage a Fruit Shop (Product and Shopping).>				
 */
package gui;

import management.FruitManagement;
import management.GetUserInput;

/**
 * The `FruitShopManagement` class serves as the entry point for a Fruit Shop
 * management application. It provides a text-based menu for users to interact
 * with various features, including creating fruits, viewing orders, shopping as
 * a buyer, and exiting the program. This class creates an instance of
 * `FruitManagement` to manage the fruit operations and uses the `GetUserInput`
 * class for user input validation.
 *
 * @author Tran Duc Anh
 */
public class FruitShopManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FruitManagement fManage = new FruitManagement();
        int choice = 0;
        do {
            //show menu
            System.out.println("=================================================\n"
                    + "1.Create Fruit\n"
                    + "2.View orders\n"
                    + "3.Shopping (for buyer)\n"
                    + "4.Exit");
            choice = GetUserInput.getInt("Enter your choice: ", 1, 4);//allow user to enter choice
            switch (choice) {
                case 1:
                    fManage.createFruit();//add fruit 
                    break;
                case 2:
                    fManage.viewOrder();//update fruit
                    break;
                case 3:
                    fManage.shopping();//shop fruit
                    break;
                case 4:
                    System.exit(0);//stop program
            }
        } while (true);
    }

}
