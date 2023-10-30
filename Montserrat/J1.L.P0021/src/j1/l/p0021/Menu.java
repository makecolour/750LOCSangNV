/*							
 * Copyright(C) 2023,  FPT University.							
 * Students management system							
 * Manage information of Students					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-25>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of Students using List>							
 */
package j1.l.p0021;

import java.util.ArrayList;

/**
 * The class save and display all main func
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
        System.out.println("========== Student management system ==========");
        for (String s : functions) {
            System.out.println("(" + (functions.indexOf(s) + 1) + ") " + s);
        }
    }

    /**
     * Consructor for menu and add available features
     */
    public Menu() {
        addFunction("Create");
        addFunction("Find and Sort");
        addFunction("Update/Delete");
        addFunction("Report");
        addFunction("Exit");
    }
}
