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

import java.util.ArrayList;

/**
 *
 * @author quyen
 */
public class Menu {

    private ArrayList<String> functions = new ArrayList<>();

    /**
     * This method add new features to menu
     *
     * @param fName
     */
    void addFunction(String fName) {
        functions.add(fName);
    }

    /**
     * Display available features
     */
    void display() {
        System.out.println("========== Products management system ==========");
        for (String s : functions) {
            System.out.println("(" + (functions.indexOf(s) + 1) + ") " + s);
        }
    }

    /**
     * Consructor for menu and add available features
     */
    public Menu() {
        addFunction("Add Storekeeper");
        addFunction("Add Product");
        addFunction("Update Product");
        addFunction("Search Product");
        addFunction("Sort Product");
        addFunction("Exit");
    }
}
