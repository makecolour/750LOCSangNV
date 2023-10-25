/*							
 * Copyright(C) 2023,  FPT University.							
 * Employee management system							
 * Manage information of Employees					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-23>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of employee using List>							
 */
package j1.s.p0101;

import java.util.ArrayList;

/**
 * This class generate the menu and perform its features
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
        System.out.println("========== Employee management system ==========");
        for (String s : functions) {
            System.out.println("(" + (functions.indexOf(s) + 1) + ") " + s);
        }
    }

    /**
     * Consructor for menu and add available features
     */
    public Menu() {
        addFunction("Add employees");
        addFunction("Update employees");
        addFunction("Remove employees");
        addFunction("Search employees");
        addFunction("Sort employees by salary");
        addFunction("Exit");
    }

    
}
