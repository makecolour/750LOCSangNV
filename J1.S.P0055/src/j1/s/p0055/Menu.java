/*							
 * Copyright(C) 2023,  FPT University.							
 * Doctor management program. 							
 * Manage information of Doctor					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-27>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of Doctor using List>							
 */
package j1.s.p0055;

import java.util.ArrayList;

/**
 * Menu
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
        System.out.println("========== DOCTOR MANAGEMENT ==========");
        for (String s : functions) {
            System.out.println("(" + (functions.indexOf(s) + 1) + ") " + s);
        }
    }

    int getMax() {
        return functions.size();
    }

    /**
     * Consructor for menu and add available features
     */
    public Menu() {
        addFunction("Add Doctor");
        addFunction("Update Doctor");
        addFunction("Delete Doctor");
        addFunction("Search Doctor");
        addFunction("Report");
        addFunction("Exit");
    }

}
