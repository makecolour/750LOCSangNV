/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Products management system> :				
 * <Program allow user manage employee information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-20>      <8.2>     <AnhTD>        <Write a program allow user to input and manage products information on screen.>				
 */
package management;

import java.util.ArrayList;
import entity.Product;
import entity.Storekeeper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;

/**
 * The ProductListManagement class represents a system for managing products and
 * storekeepers. It includes methods for adding, updating, searching, sorting,
 * and displaying products, as well as managing storekeepers.
 *
 * This class utilizes ArrayLists to maintain lists of Product and Storekeeper
 * objects, allowing users to interact with and manage the inventory
 * efficiently.
 *
 * @author Tran Duc Anh
 */
public class ProductListManagement {

    ArrayList<Product> pList;
    ArrayList<Storekeeper> sList;

    /**
     * Constructs a new instance of ProductListManagement with an empty list of
     * products and storekeepers.
     *
     * This constructor initializes the pList and sList with empty ArrayList
     * instances. It can be used to create a new ProductListManagement object
     * without any pre-existing data.
     */
    public ProductListManagement() {
        pList = new ArrayList<Product>();
        sList = new ArrayList<Storekeeper>();
        //sList.add(new Storekeeper("1", "a"));
        //pList.add(new Product("1", "a", 10, "a", LocalDate.parse("2024-04-20"), LocalDate.parse("2023-04-20"), "a", sList.get(0), LocalDate.parse("2024-03-20")));
        //pList.add(new Product("2", "aasd", 10, "ad", LocalDate.parse("2024-04-21"), LocalDate.parse("2023-05-20"), "a", sList.get(0), LocalDate.parse("2025-03-20")));
    }

    /**
     * Constructs a new instance of ProductListManagement with an existing list
     * of products.
     *
     * This constructor initializes the pList with the provided list of
     * products. It can be used to create a new ProductListManagement object
     * with pre-existing product data.
     *
     * @param pList The ArrayList of Product objects to initialize the pList
     * with.
     */
    public ProductListManagement(ArrayList<Product> pList) {
        this.pList = pList;
    }

    /**
     * Adds a new Storekeeper to the list of storekeepers.
     *
     * This method prompts the user for the Storekeeper 's ID and name and adds
     * a new Storekeeper object to the list of storekeepers (sList). The new
     * Storekeeper is created with the provided ID and name. After adding the
     * Storekeeper, it prints a confirmation message.
     */
    public void addStorekeeper() {
        sList.add(new Storekeeper(GetUserInput.getId("storekeeper id", sList, 1), GetUserInput.getStorekeeperName("storekeeper name", sList)));
        System.err.println("This storekeeper has been added");
    }

    /**
     * Prompts the user to input details for a new product and adds it to the
     * product list.
     *
     * This method collects various attributes of a product, such as ID, name,
     * price, location, expiry date, date of manufacture, category, storekeeper,
     * and receipt date, and creates a new Product object with these details. It
     * then adds the new product to the product list.
     */
    public void addProduct() {

        String text = null;
        Product newProduct = new Product();
        newProduct.setId(GetUserInput.getId("product id", pList, 2));
        newProduct.setName(GetUserInput.getString("product name", text));
        newProduct.setPrice(GetUserInput.getDouble("price", 0, 10000));
        newProduct.setLocation(GetUserInput.getString("location", text));
        newProduct.setDateOfManufacture(GetUserInput.getManufactureDate("manufacture date (YYYY-MM-DD)", text));
        newProduct.setExpiryDate(compareDate("expiry date", newProduct.getDateOfManufacture(), null, null));
        newProduct.setCategory(GetUserInput.getString("category", text));
        
        newProduct.setStorekeeper(GetUserInput.getStorekeeper("storekeeper name", sList));
        newProduct.setReceiptDate(compareDate("receipt date", newProduct.getDateOfManufacture(), newProduct.getExpiryDate(), null));
        pList.add(newProduct);
        System.err.println("This product has been added");
    }

    /**
     * Allows the user to update the attributes of an existing product based on
     * its ID.
     *
     * This method prompts the user to input an ID and then searches for a
     * product with that ID in the product list. If found, it allows the user to
     * choose which attribute of the product to update, such as ID, product
     * name, price, location, expiry date, date of manufacture, category,
     * storekeeper, or receipt date. The user can choose to continue updating
     * the product or stop.
     *
     * If the product is updated, the method displays a confirmation message. If
     * the provided ID is not found, it displays an error message. The method
     * runs until the user decides to stop updating or exits due to an empty
     * product list.
     */
    public void updateProduct() {
        String inputId = null;
        String choose = null;
        String text = null;
        Product aProduct;
        do {
            if (pList.isEmpty()) {
                System.err.println("There is no Product");
                break;
            }
            //find Product base on Id input from user
            inputId = GetUserInput.getString("Id to update", inputId);
            aProduct = findId(inputId);
            //choose Product'attribute to update
            if (aProduct != null) {
                do {
                    System.out.println("Attribute: 1.ID | 2.Product Name | 3.Price| 4.Location| 5.Expiry date| 6.Date of manufacture| 7.Category| 8.Storekeeper |9.Receipt date");
                    int choice = GetUserInput.getInt("Attribute", 1, 9);
                    switch (choice) {
                        case 1:
                            aProduct.setId(GetUserInput.getId("new Id", pList, 2));
                            break;
                        case 2:
                            aProduct.setName(GetUserInput.getString("new product name", text));
                            break;
                        case 3:
                            aProduct.setPrice(GetUserInput.getDouble("price", 0, 10000));
                            break;
                        case 4:
                            aProduct.setLocation(GetUserInput.getString(" new location", text));
                            break;
                        case 5:
                            aProduct.setExpiryDate(compareDate("expiry date", aProduct.getDateOfManufacture(), null, aProduct.getReceiptDate()));
                            break;
                        case 6:
                            aProduct.setDateOfManufacture(compareDate("date of manufacture (YYYY-MM-DD)", null, aProduct.getExpiryDate(), aProduct.getReceiptDate()));
                            break;
                        case 7:
                            aProduct.setCategory(GetUserInput.getString("category", text));
                            break;
                        case 8:
                            aProduct.setStorekeeper(GetUserInput.getStorekeeper("storekeeper", sList));
                            break;
                        case 9:
                            aProduct.setReceiptDate(compareDate("new receipt date (YYYY-MM-DD)", aProduct.getDateOfManufacture(), aProduct.getExpiryDate(), null));
                            break;
                    }
                    //allow user to continue/stop updating Product
                    System.out.println("Do you want to continue update");
                    do {
                        choose = GetUserInput.getString("Y/N", choose);
                        if (choose.equalsIgnoreCase("Y") || choose.equalsIgnoreCase("N")) {
                            break;
                        }
                    } while (true);
                    if (choose.equalsIgnoreCase("n")) {
                        System.err.println("This Product has been updated ");
                        break;
                    }
                } while (choose.equalsIgnoreCase("y"));
                break;
            } else {
                System.err.println("Id not found");
            }
        } while (true);
    }

    /**
     * Searches for a product based on user input criteria.
     *
     * This method allows the user to search for a product by specifying a
     * search criteria, such as the product's name, category, storekeeper, or
     * receipt date. It interacts with the user to gather input and then
     * searches the list of products to find matching entries.
     *
     */
    public void searchProduct() {
        int inputText = 0;
        String inputValue = null;
        LocalDate inputDate;
        //find Product base on name or part of name input from user
        //check if list is empty
        if (pList.isEmpty()) {
            System.err.println("There is no Product");
        } else {
            do {
                System.out.println("Type (1.Name |2.Category |3.Storekeeper |4.Receipt Date)");
                inputText = GetUserInput.getInt("choice to search", 1, 4);
                if (inputText == 1 || inputText == 2 || inputText == 3) {
                    inputValue = GetUserInput.getString("string", "");
                    break;
                } else if (inputText == 4) {
                    inputDate = GetUserInput.getExpiryAndReceiptDate("receipt date to search", "");
                    break;
                } else {
                    System.err.println("Error type");
                }
            } while (true);
            ArrayList<Product> employeeList = findByText(inputText, inputValue);
            //if found employee print it to screen
            if (employeeList != null) {
                System.out.println("Product found");
                show(employeeList);
            } else {
                System.err.println("Product not found");
            }
        }
    }

    /**
     * Sorts the list of products based on user choice.
     *
     * This method allows the user to choose how to sort the list of products.
     * The user can select either sorting by expiry date or sorting by date of
     * manufacture. The sorted list is then displayed.
     */
    public void sortProduct() {
        int choice;
        if (pList.isEmpty()) {
            System.err.println("There is no product");
        } else {
            System.out.println("Sorting (1.Date of manufacture |2.Expiry date )");
            choice = GetUserInput.getInt("choice", 1, 2);
            switch (choice) {
                case 1:
                    System.out.println("List before sorting");
                    show(pList);
                    System.out.println("List after sorting");
                    Collections.sort(pList, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getDateOfManufacture().compareTo(o2.getDateOfManufacture());
                        }
                    });
                    show(pList);
                    break;
                case 2:
                    System.out.println("List before sorting");
                    show(pList);
                    System.out.println("List after sorting");
                    Collections.sort(pList, new Comparator<Product>() {
                        @Override
                        public int compare(Product o1, Product o2) {
                            return o1.getExpiryDate().compareTo(o2.getExpiryDate());
                        }
                    });
                    show(pList);
                    break;
            }
        }
    }

    /**
     * Displays a list of products in a tabular format.
     *
     * This method takes an ArrayList of Product objects and prints them in a
     * tabular format to the console. Each product's details, including ID,
     * name, price, location, expiry date, date of manufacture, category,
     * storekeeper, and receipt date, are displayed in a well-organized table.
     *
     * @param list The ArrayList of Product objects to be displayed.
     */
    private void show(ArrayList<Product> list) {
        System.out.println("| ID | Product Name |   Price   | Location | Expiry Date | Date of manufacture | Category | Storekeeper | Receipt date |");
        for (Product e : list) {
            System.out.println(e);
        }
    }

    /**
     * Finds and returns a Product based on its ID.
     *
     * This method searches through the list of products to find a product with
     * a matching ID. If a product with the specified ID is found
     * (case-insensitive), it is returned; otherwise, null is returned.
     *
     * @param id The ID of the product to find.
     * @return The Product object with the matching ID, or null if no such
     * product is found.
     */
    private Product findId(String id) {
        for (Product e : pList) {
            if (id.equalsIgnoreCase(e.getId())) {
                return e;
            }
        }
        return null;
    }

    /**
     * Finds and returns a list of products based on the specified search type
     * and search text.
     *
     * This method searches through the list of products based on the provided
     * search type (e.g., "Name," "Category," "Storekeeper," "Receipt Date") and
     * the search text. It returns an ArrayList containing products that match
     * the search criteria. The search is case-insensitive.
     *
     * @param type The type of search criteria (e.g., "Name," "Category,"
     * "Storekeeper," "Receipt Date").
     * @param text The search text to match against the specified criteria.
     * @return An ArrayList of Product objects that match the search criteria,or
     * null
     */
    private ArrayList<Product> findByText(int type, String text) {
        ArrayList<Product> fList = new ArrayList<Product>();
        if (type == 1) {
            for (Product e : pList) {
                //check if input name existed or not
                if (e.getName().toLowerCase().contains(text.toLowerCase()) || e.getName().toLowerCase().contains(text.toLowerCase())) {
                    fList.add(e);
                }
            }
        } else if (type == 2) {
            for (Product e : pList) {
                //check if input name existed or not
                if (e.getCategory().toLowerCase().contains(text.toLowerCase()) || e.getCategory().toLowerCase().contains(text.toLowerCase())) {
                    fList.add(e);
                }
            }
        } else if (type == 3) {
            for (Product e : pList) {
                //check if input name existed or not
                if (e.getStorekeeper().getName().toLowerCase().contains(text.toLowerCase()) || e.getStorekeeper().getName().toLowerCase().contains(text.toLowerCase())) {
                    fList.add(e);
                }
            }
        } else if (type == 4) {
            for (Product e : pList) {
                //check if input name existed or not
                if (e.getReceiptDate().toString().contains(text) || e.getReceiptDate().toString().contains(text)) {
                    fList.add(e);
                }
            }
        }
        //check empty list
        if (fList.isEmpty() == true) {
            return null;
        } else {
            return fList;
        }
    }

    /**
     * Compares and validates dates for manufacturing, expiry, and receipt to
     * ensure logical relationships between them, based on specific rules, and
     * returns the valid date.
     *
     * @param msg A descriptive message specifying the purpose of date entry
     * (e.g., "Manufacture Date").
     * @param manufactureDate The manufacturing date as a LocalDate object (null
     * if not provided).
     * @param expiryDate The expiry date as a LocalDate object (null if not
     * provided).
     * @param receiptDate The receipt date as a LocalDate object (null if not
     * provided).
     * @return The validated date (manufacture, expiry, or receipt) as a
     * LocalDate object.
     */
    private LocalDate compareDate(String msg, LocalDate manufactureDate, LocalDate expiryDate, LocalDate receiptDate) {

        if (manufactureDate == null && expiryDate != null) {

            do {
                manufactureDate = GetUserInput.getManufactureDate(msg + "(YYYY-MM-DD)", "");
                if (manufactureDate.isAfter(expiryDate)) {
                    System.err.println("Manufacture date can not be after Expiry date");
                } else if (receiptDate.compareTo(manufactureDate) < 0) {
                    System.err.println("Manufacture date can not be after Receipt date");
                } else {
                    return manufactureDate;
                }
            } while (true);
        } else if (expiryDate == null && manufactureDate != null) {
            do {
                expiryDate = GetUserInput.getExpiryAndReceiptDate(msg + "(YYYY-MM-DD)", "");
                if (manufactureDate.compareTo(expiryDate) > 0) {
                    System.err.println("Expiry date can not be ahead Manufacture date");
                } else if (receiptDate != null && expiryDate.compareTo(receiptDate) < 0) {
                    System.err.println("Expiry date date can not be ahead Receipt date");
                } else {
                    return expiryDate;
                }
            } while (true);
        } else {
            do {
                receiptDate = GetUserInput.getExpiryAndReceiptDate(msg + "(YYYY-MM-DD)", "");
                if (receiptDate.compareTo(manufactureDate) < 0) {
                    System.err.println("Receipt date can not be ahead Manufacture date");
                } else if (receiptDate.compareTo(expiryDate) > 0) {
                    System.err.println("Receipt date date can not be after Expiry date");
                } else {
                    return receiptDate;
                }
            } while (true);
        }

    }
}
