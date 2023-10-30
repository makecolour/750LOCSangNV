/*
 * Copyright(C) 2023,  <La Dieu Minh HE180677>.
 * <ProjectCode/Short Name of Application> : p0055
 *  <J1.s.p0055>
 *
 * Record of change:
 * DATE              Version             AUTHOR             DESCRIPTION
 * <2023-09-09>      <2.0>              <La Dieu Minh>      <Updated for clarity version>
 */
package Main;

import java.util.ArrayList;

import Object.Doctor;
import Operation.*;

/**
 * This class is for user/tester to use the program without the need to look at
 * method details
 *
 *
 * @author La Dieu Minh
 */
public class Display {

    /**
     * Print out the menu. Get user choice to Allow user to add, delete, update
     * or search a doctor
     */
    public static void main(String[] args) {

        ArrayList<Doctor> DoctorList = new ArrayList<>();
        ManageDoctors manager = new ManageDoctors();
        Input input = new Input();

        //loop until user want to exist
        while (true) {
            System.out.println("======DOCTOR MANAGEMENT======");
            System.out.println("1. Add Doctor");
            System.out.println("2. Update Doctor");
            System.out.println("3. Delete Doctor");
            System.out.println("4. Search Doctor");
            System.out.println("5. Exit");
            System.out.println("6. (Debug) Print all");
            System.out.print("Enter choices: ");

            switch (input.checkLimit(1, 6)) {
                case 1:
                    // add doctor
                    manager.addDoctor(DoctorList);
                    break;
                case 2:
                    // update a doctor
                    manager.updateDoctor(DoctorList);
                    break;
                case 3:
                    // delete a doctor
                    manager.deleteDoctor(DoctorList);
                    break;
                case 4:
                    // search a doctor
                    manager.searchDoctor(DoctorList);
                    break;
                case 5:
                    // exit program
                    return;
                case 6:
                    // (debug) print all list
                    manager.printAll(DoctorList);
                    break;
            }
        }
    }
}
