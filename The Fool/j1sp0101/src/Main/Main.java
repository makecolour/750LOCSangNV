/*
 * Copyright(C) 2005,  FPTU.
 * EM :
 *  Employee Manager
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2023-10-18                 1.5                 MinhLD                       <General fixes>
 */
package Main;

import java.util.Date;
import java.util.ArrayList;
import Display.Display;

import Manage.*;

/**
 * The whole application main run-time
 *
 * @author MinhLD
 */
public class Main {

    /**
     * Main Run-time
     */
    public static void main(String[] args) {
        int choice;
        Input input = new Input();
        EmployeeManagement EmployeeManagement = new EmployeeManagement();
        Display display = new Display();
        ArrayList<Employee> EmployeeList = new ArrayList<>();
        
        EmployeeList.add(new Employee(18587, "Thuong Quyen", "Nguyen", "0335610213" , "quyennguyen083004@gmail.com" , "Ha Dong"  , new Date(1976 - 1900, 05, 16), "M", 10000 , "FPT Group"));
        EmployeeList.add(new Employee(18567, "Thien Nga"   , "Nguyen", "0335390209" , "nganthe186502@fpt.edu.vn"    , "Bac Giang", new Date(2003 - 1900, 04, 12), "F", 1000  , "FPT University"));
        EmployeeList.add(new Employee(18564, "Hoang Manh"  , "Nguyen", "0388789965" , "hoangmanhnguyen204@gmail.com", "Ha Dong"  , new Date(1978 - 1900, 05, 9) , "M", 1000  , "FPT University"));
        EmployeeList.add(new Employee(18467, "Dieu Minh"   , "La"    , "0943526955" , "laminhcokho@gmail.com"       , "Dong Da"  , new Date(2004 - 1900, 01, 26), "M", 3000  , "FPT University"));
        
        
        do {
            //1. Display a menu
            display.DisplayMenu();
            //2. Ask and Get user's choice
            choice = input.getInteger("Let's select option: ", 1, 6);
            //3.Do the option user select
            switch (choice) {
                case 1: //Add Employee
                    EmployeeManagement.addEmployee(EmployeeList);
                    break;
                case 2: //Update employees
                    EmployeeManagement.updateEmployee(EmployeeList);
                    break;
                case 3: //Removed employees
                    EmployeeManagement.removedEmployee(EmployeeList);
                    break;
                case 4: //Search employees
                    EmployeeManagement.Search(EmployeeList);
                    break;
                case 5: //Sort employees by salary
                    EmployeeManagement.SortBySalary(EmployeeList);
                    break;
                case 6: // Display all
                    display.DisplayAllList(EmployeeList);
                    break;
            }
        } while (choice < 7);
    }
}
