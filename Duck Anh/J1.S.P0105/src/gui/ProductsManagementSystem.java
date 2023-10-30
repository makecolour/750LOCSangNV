/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Products management system>:				
 * <Program allow user manage employee information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-20>      <8.2>     <AnhTD>        <Write a program allow user to input and manage products information on screen.>				
 */
package gui;

import management.ProductListManagement;
import management.GetUserInput;

/**
 * ProductsManagementSystem is a Java application for managing storekeepers and
 * products. This program provides a user-friendly menu-driven interface to
 * perform various operations such as adding storekeepers, adding products,
 * updating products, searching for products by different criteria, sorting
 * products, and exiting the program. The program continues to run in a loop
 * until the user chooses to exit.
 *
 * @author Tran Duc Anh
 */
public class ProductsManagementSystem {

    /**
     * Main method to run the management system for storekeepers and products.
     * Displays a menu for users to add storekeepers, add products, update
     * products, search for products by various criteria, sort products, and
     * exit the program. Continues to loop until the user chooses to exit.
     */
    public static void main(String[] args) {
        ProductListManagement o = new ProductListManagement();
        int choice;
        do {
            System.out.println("============================================================"
                    + "\n1.Add Storekeeper\n"
                    + "2.Add product\n"
                    + "3.Update product\n"
                    + "4.Search product by Name, Category, Storekeeper, ReceiptDate\n"
                    + "5.Sort product by Expiry date, Date of manufacture\n"
                    + "6.Exit");

            choice = GetUserInput.getInt("your choice", 1, 6);
            switch (choice) {
                case 1:
                    o.addStorekeeper();
                    break;
                case 2:
                    o.addProduct();
                    break;
                case 3:
                    o.updateProduct();
                    break;
                case 4:
                    o.searchProduct();
                    break;
                case 5:
                    o.sortProduct();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }
}
