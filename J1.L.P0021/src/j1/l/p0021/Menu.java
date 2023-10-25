/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

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
