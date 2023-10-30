/*							
 * Copyright(C) 2023,  FPT University.							
 * Doctor Management							
 * Manage information of doctors				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-09>      <2.0>              <La Dieu Minh>      <Updated for clarity version>						
 */
package Operation;

import java.util.ArrayList;

import Main.ErrorLogger;
import Object.Doctor;

/**
 * This class is for managing information of doctors
 *
 * @author La Dieu Minh
 */
public class ManageDoctors {
    
    private final Input input = new Input();
    private final ErrorLogger logger = new ErrorLogger();
    private final String className = ManageDoctors.class.getName();

    /**
     * Add a doctor to the doctor list
     *
     * @param DoctorList doctor list
     */
    public void addDoctor(ArrayList<Doctor> DoctorList) {
        
        String code;
        while (true) {
            System.out.print("Enter code: ");
            code = input.checkInputString().toUpperCase();
            //check code exists or not
            if (!input.checkCodeExist(DoctorList, code)) {
                logger.Log(className, "Doctor code exist.");
            } else {
                break;
            }
        }
        // name
        System.out.print("Enter name: ");
        String name = input.checkInputString();
        // spec
        System.out.print("Enter specialization: ");
        String specialization = input.checkInputString();
        // availability
        System.out.print("Enter availability: ");
        int availability = input.checkInputInt();

        //check worker duplicate
//        if (!input.checkDuplicate(DoctorList, code, name, specialization, availability)) {
//            logger.Log(className,"Doctor code is duplicated.\n");
//            return;
//        }
        //added
        DoctorList.add(new Doctor(code, name, specialization, availability));
        System.out.println("Doctor added successfully!\n");        
        return;
        
    }

    /**
     * Update a doctor find by code
     *
     * @param DoctorList doctor list
     */
    public void updateDoctor(ArrayList<Doctor> DoctorList) {

        //check if empty
        if (!DoctorList.isEmpty()) {
            //Database is not empty

            // get code
            System.out.print("Enter code: ");
            String code = input.checkInputString().toUpperCase();
            //check code exists or not
            if (input.checkCodeExist(DoctorList, code)) {
                logger.Log(className, "Not found doctor");
                return;
            }

            //find doctor code
            System.out.println("\nUpdate doctor with code: " + code);
            int pos = findDoctorInListByCode(DoctorList, code);
            
            System.out.print("Code change ?");
            if (input.checkInputYN()) {
                System.out.print("Enter code: ");
                code = input.checkInputString().toUpperCase();
            }

            // name
            System.out.print("Enter name: ");
            String name = input.checkInputString();

            //spec
            System.out.print("Enter specialization: ");
            String specialization = input.checkInputString();

            //avail
            System.out.print("Enter availability: ");
            int availability = input.checkInputInt();

            //check user change information or not
            if (!input.checkChangeInfo(DoctorList.get(pos), code, name, specialization, availability)) {
                logger.Log(className, "No changes");
                return;
            }

            // changes item
            DoctorList.get(pos).setCode(code);
            DoctorList.get(pos).setName(name);
            DoctorList.get(pos).setSpecialization(specialization);
            DoctorList.get(pos).setAvailability(availability);
            System.out.println("Update successfully!");
        } else {
            logger.Log(className, "Database is empty");
        }
    }

    /**
     * Allow user delete doctor find by code
     *
     * @param DoctorList doctor list
     */
    public void deleteDoctor(ArrayList<Doctor> DoctorList) {

        //check if empty
        if (!DoctorList.isEmpty()) {
            //Database is not empty

            //get code
            System.out.print("Enter code: ");
            String code = input.checkInputString().toUpperCase();
            int pos = findDoctorInListByCode(DoctorList, code);

            //check if doctor is found
            if (pos == -1) {
                logger.Log(className, "Not found doctor.");
            } else {
                //found and need delete confirm
                System.out.print("Doctor found. Here is his Name: " + DoctorList.get(pos).getName());
                
                System.out.print("Are you sure to delete doctor (Y/N): ");
                if (input.checkInputYN()) {
                    DoctorList.remove(pos);
                    System.out.println("Delete successfully.");
                } else {
                    System.out.println("Cancel delete");
                }
            }
        } else {
            logger.Log(className, "Database is empty");
        }
        
    }

    /**
     * Search doctor by name and display to screen
     *
     * @param DoctorList doctor list
     */
    public void searchDoctor(ArrayList<Doctor> DoctorList) {

        //check if empty
        if (!DoctorList.isEmpty()) {
            //find name
            System.out.print("Enter name: ");
            String nameSearch = input.checkInputString();

            //print
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : DoctorList) {
                if (doctor.getName().contains(nameSearch) || nameSearch.equalsIgnoreCase(doctor.getName().substring(0, 1))) {
                    System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                            doctor.getName(), doctor.getSpecialization(),
                            doctor.getAvailability());
                }
            }
        } else {
            logger.Log(className, "Database is empty.");
        }
    }

    /**
     * Get doctor by code and return Doctor object
     *
     * @param DoctorList doctor list
     * @param code doctor code
     * @return a doctor if found, null otherwise
     */
    public int findDoctorInListByCode(ArrayList<Doctor> DoctorList, String code) {
        int index = 0;

        //check in list to see if he exist
        for (Doctor doctor : DoctorList) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return index;
            }
            index += 1;
        }
        return -1;
    }

    /**
     * Print all for list showcase
     *
     * @param DoctorList the doctor list
     */
    public void printAll(ArrayList<Doctor> DoctorList) {
        if (!DoctorList.isEmpty()) {
            //print
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : DoctorList) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailability());
                
            }
        } else {
            logger.Log(className, "Database is empty.");
        }
    }
}
