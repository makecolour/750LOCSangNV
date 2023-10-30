/*							
 * Copyright(C) 2023,  FPT University.							
 * Doctor Management							
 * Manage information of doctors				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage information of doctors>							
 */
package program;

import java.util.ArrayList;
import object.Doctor;
import operation.ManageDoctors;
import operation.Menu;

/**
 * This class is for user/tester to use the program without the need to look at
 * method details
 *
 * <p>
 * Note: This class also user to add menu option if needed , but user must also
 * writing a function for that options in ManageDoctors Class
 *
 * @author Nguyen Hoang Manh
 */
public class DoctorManagement {

    /**
     * Print out the menu Get user choice Allow user to add, delete, update or
     * search a doctor
     *
     * @param args
     */
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.add("Add doctor");
        menu.add("Update doctor");
        menu.add("Delete doctor");
        menu.add("Search doctor");
        menu.add("Exit");

        ArrayList<Doctor> DoctorList = new ArrayList<>();
        ManageDoctors operations = new ManageDoctors();

        //loop until user want to exist
        int userChoice;
        while (true) {
            System.out.println("DOCTOR MANAGEMENT");
            userChoice = menu.getUserChoice();

            switch (userChoice) {
                case 1:
                    operations.addDoctor(DoctorList);
                    break;
                case 2:
                    operations.updateDoctor(DoctorList);
                    break;
                case 3:
                    operations.deleteDoctor(DoctorList);
                    break;
                case 4:
                    operations.searchDoctor(DoctorList);
                    break;
                case 5:
                    return;
            }
        }
    }
}
