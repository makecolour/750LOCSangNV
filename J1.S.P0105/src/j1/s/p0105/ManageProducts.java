/*							
 * Copyright(C) 2023,  FPT University.							
 * Products management system							
 * Manage information of Products					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-24>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of Products using List>							
 */
package j1.s.p0105;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;
import java.util.Date;

/**
 * The most important class, perform almost main functions
 *
 * @author quyen
 */
public class ManageProducts {

    private static final Logger LOG = Logger.getLogger(ManageProducts.class.getName());
    Input input = new Input();
    StoreKeeperList sl = new StoreKeeperList();
    ProductsList pl = new ProductsList();

    /**
     * Compare 2 Date variables
     *
     * @param before
     * @param after
     * @param msg
     * @return
     */
    private boolean compareDate(Date before, Date after, String msg) {
        if (before.compareTo(after) <= 0) {
            return true;
        } else {
            LOG.warning(msg);
            return false;
        }
    }

    /**
     * Get Today's date
     *
     * @return
     */
    private Date getToday() {
        Date now = new Date();
        return now;
    }
    
    /**
     * Let user input product's properties
     *
     * @param id
     * @return
     */
    private Products enter(String id) {
        String name = input.getString("Name: ", "", "");
        String location = input.getString("Location: ", "", "");
        double price = input.getDouble("Price: ");
        Date exp;
        Date mfg;
        do {
            do {
                mfg = input.getDate("Date of manufacture (dd-MM-yyyy): ");
            } while (!compareDate(mfg, getToday(), "Date of manufacture must before or on today"));
            exp = input.getDate("Date of expiry (dd-MM-yyyy): ");
        } while (!compareDate(mfg, exp, "Date of manufacture must before or on date of expiry"));
        String category = input.getString("Category: ", "", "");
        sl.printKeeperList();
        StoreKeeper sk = sl.choose();
        Date receiptDate;
        do{
        receiptDate = input.getDate("Receipt date (dd-MM-yyyy): ");
        }while(!compareDate(mfg,receiptDate, "Receipt date must after date of manufacture"));
        return new Products(id, name, location, price, exp, mfg, category, sk, receiptDate);
    }

    /**
     * Find Products by ít ID, if exist, return itself, else return null
     *
     * @param id
     * @return
     */
    private Products findById(String id) {
        if (pl.getProdList().isEmpty()) {
            return null;
        } else {
            for (Products p : pl.getProdList()) {
                if (p.getId().equalsIgnoreCase(id)) {
                    return p;
                }
            }
            return null;
        }
    }

    /**
     * Find products share the whole or a part of name
     *
     * @param name
     * @return
     */
    private ArrayList<Products> findByName(String name) {
        ArrayList<Products> found = new ArrayList();
        if (pl.getProdList().isEmpty()) {
            return null;
        } else {
            for (Products p : pl.getProdList()) {
                if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                    found.add(p);
                }
            }
            return found;
        }
    }

    /**
     * Find products share the same category
     *
     * @param name
     * @return
     */
    private ArrayList<Products> findByCategory(String category) {
        ArrayList<Products> found = new ArrayList();
        if (pl.getProdList().isEmpty()) {
            return null;
        } else {
            for (Products p : pl.getProdList()) {
                if (p.getCategory().toLowerCase().equals(category.toLowerCase())) {
                    found.add(p);
                }
            }
            return found;
        }
    }

    /**
     * Find products share the same Store Keeper
     *
     * @param name
     * @return
     */
    private ArrayList<Products> findByStore(StoreKeeper sk) {
        ArrayList<Products> found = new ArrayList();
        if (pl.getProdList().isEmpty()) {
            return null;
        } else {
            for (Products p : pl.getProdList()) {
                if (p.getStorekeeper().equals(sk)) {
                    found.add(p);
                }
            }
            return found;
        }
    }

    private ArrayList<Products> findByKeeper(String keeper)
    {
        ArrayList<Products> found = new ArrayList();
        if(pl.getProdList().isEmpty())
        {
            return null;
        }
        else
        {
            for(Products p : pl.getProdList())
            {
                if(p.getStorekeeper().getStoreKeeper().equalsIgnoreCase(keeper))
                {
                    found.add(p);
                }
            }
            return found;
        }
    }
    /**
     * Find products share the same Receipt Date
     *
     * @param name
     * @return
     */
    private ArrayList<Products> findByDate(Date receipt) {
        ArrayList<Products> found = new ArrayList();
        if (pl.getProdList().isEmpty()) {
            return null;
        } else {
            for (Products p : pl.getProdList()) {
                if (p.getReceiptDate().compareTo(receipt) == 0) {
                    found.add(p);
                }
            }
        }
        return found;
    }

    /**
     * Print an Array List of Products
     *
     * @param arr
     */
    private void print(ArrayList<Products> arr) {
        if (arr.isEmpty()) {
            LOG.warning("No product available");
            return;
        }
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
        format.setLenient(false);
        System.out.println("ID                  Name                   Location                 Price                   Date of expiry                  Date of manufacture                  Category                    Storekeeper                 Receipt date");
        for (Products p : arr) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", p.getId(), p.getName(), p.getLocation(), Double.toString(p.getPrice()), format.format(p.getExp()), format.format(p.getMfg()), p.getCategory(), p.getStorekeeper().getStoreKeeper(), format.format(p.getReceiptDate()));
        }
    }

    /**
     * Add new StoreKeeper and check if he/she is already exist on system
     */
    void addStoreKeeper() {
        String storeKeeper;
        storeKeeper = input.getString("Enter new store keeper's name: ", "", "");
        StoreKeeper sk = new StoreKeeper(storeKeeper, sl.getLastID() + 1);
        if (sl.checkExist(sk)) {
            LOG.warning("Store keeper is already exist");
            return;
        } else {
            sl.addStoreKeeper(sk);
            System.out.println("Added successfully");
        }
    }

    /**
     * Add new Product and check if its id is already exist or not
     */
    void addProduct() {
        String id;
        Products p;
        do {
            id = input.getString("ID: ", "", "");
            if (findById(id) == null) {
                break;
            }
            LOG.warning("Product already exist");
        } while (true);
        pl.getProdList().add(enter(id));
        System.out.println("Added successfully");
    }

    /**
     * Find Product by ID and Update it
     */
    void updateProduct() {
        String id = input.getString("ID: ", "", "");
        Products p;
        p = findById(id);
        if (p == null) {
            LOG.warning("No products found");
            return;
        } else {
            pl.getProdList().set(pl.getProdList().indexOf(p), enter(id));
            System.out.println("Updated successfully");
        }
    }

    /**
     * Search product by Name, Category, Storekeeper, ReceiptDate
     */
    void searchByOthers() {
        ArrayList<Products> prod = new ArrayList();
        System.out.println("=======Search by Others=======");
        System.out.println("1. Name");
        System.out.println("2. Category");
        System.out.println("3. Storekeeper");
        System.out.println("4. Receipt Date");
        System.out.println("5. Return");
        int choice = input.getInt("Choose an attribute to search: ", 1, 5);
        switch (choice) {
            case 1:
                String name = input.getString("Name: ", "", "");
                prod = findByName(name);
                if (null == prod) {
                    LOG.warning("No products available");
                    return;
                } else {
                    print(prod);
                }
                return;
            case 2:
                String category = input.getString("Category: ", "", "");
                prod = findByCategory(category);
                if (null == prod) {
                    LOG.warning("No products available");
                    return;
                } else {
                    print(prod);
                }
                return;
            case 3:
//                sl.printKeeperList();
//                prod = findByStore(sl.choose());
//                if (null == prod) {
//                    LOG.warning("No products available");
//                    return;
//                } else {
//                    print(prod);
//                }
                String keeper = input.getString("Storekeeper: ", "", "");
                prod = findByKeeper(keeper);
                if (null == prod) {
                    LOG.warning("No products available");
                    return;
                } else {
                    print(prod);
                }
                return;
            case 4:
                Date receiptDate = input.getDate("Receipt Date: ");
                prod = findByDate(receiptDate);
                if (null == prod) {
                    LOG.warning("No products available");
                    return;
                } else {
                    print(prod);
                }
                return;
            case 5:
                return;
        }
    }

    /**
     * Sort Products by their ID
     */
    void sortProduct() {
        ArrayList<Products> arr = pl.getProdList();
        System.out.println("Search by: ");
        System.out.println("1. Expiry Date");
        System.out.println("2. Date of manufacture");
        int choice = input.getInt("Choose an option: ", 1, 2);
        switch(choice)
        {
            case 1:
                Collections.sort(arr, Comparator.comparing(Products::getExp));
                break;
            case 2:
                Collections.sort(arr, Comparator.comparing(Products::getMfg));
                break;
        }
        
        print(arr);
    }
}
