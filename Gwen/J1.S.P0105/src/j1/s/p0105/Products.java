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

import java.util.*;

/**
 * This class represent Products object
 *
 * @author quyen
 */
public class Products {

    private String id;
    private String name;
    private String location;
    private double price;
    private Date exp; //date of expiry
    private Date mfg; //date of manufacture
    private String category;
    private StoreKeeper storekeeper;
    private Date receiptDate;

    /**
     * No parameter constructor
     */
    public Products() {
    }

    /**
     *
     * @param id
     * @param name
     * @param location
     * @param price
     * @param exp
     * @param mfg
     * @param category
     * @param storekeeper
     * @param receiptDate
     */
    public Products(String id, String name, String location, double price, Date exp, Date mfg, String category, StoreKeeper storekeeper, Date receiptDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.exp = exp;
        this.mfg = mfg;
        this.category = category;
        this.storekeeper = storekeeper;
        this.receiptDate = receiptDate;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return
     */
    public Date getExp() {
        return exp;
    }

    /**
     *
     * @return
     */
    public Date getMfg() {
        return mfg;
    }

    /**
     *
     * @return
     */
    public String getCategory() {
        return category;
    }

    /**
     *
     * @return
     */
    public StoreKeeper getStorekeeper() {
        return storekeeper;
    }

    /**
     *
     * @return
     */
    public Date getReceiptDate() {
        return receiptDate;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @param exp
     */
    public void setExp(Date exp) {
        this.exp = exp;
    }

    /**
     *
     * @param mfg
     */
    public void setMfg(Date mfg) {
        this.mfg = mfg;
    }

    /**
     *
     * @param category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     *
     * @param storekeeper
     */
    public void setStorekeeper(StoreKeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    /**
     *
     * @param receiptDate
     */
    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

}
