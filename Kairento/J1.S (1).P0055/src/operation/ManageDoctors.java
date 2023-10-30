/*							
 * Copyright(C) 2023,  FPT University.							
 * Doctor Management							
 * Manage information of doctors				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage information of doctors>							
 */
package operation;

import java.util.ArrayList;
import java.util.logging.Logger;
import object.Doctor;

/**
 * This class is for managing information of doctors
 *
 * @author Nguyen Hoang Manh
 */
public class ManageDoctors {

    private final static Logger logger = Logger.getLogger(ManageDoctors.class.getName());

    /**
     * Add a doctor to doctor list
     *
     * @param DoctorList doctor list. It is a <code>java.util.ArrayList</code>
     * object
     */
    public void addDoctor(ArrayList<Doctor> DoctorList) {
        System.out.print("    Enter code: ");
        String code = normalize(Validate.checkInputString()).toUpperCase();
        //check code exist or not
        if (!Validate.checkCodeExist(DoctorList, code)) {
            logger.warning("Doctor code is existed.");
            return;
        }
        System.out.print("    Enter name: ");
        String name = normalize(Validate.checkInputString());

        System.out.print("    Enter specialization: ");
        String specialization = Validate.checkInputString();

        System.out.print("    Enter availability: ");
        int availability = Validate.checkInputInt();

        //check worker duplicate
        if (!Validate.checkDuplicate(DoctorList, code, name, specialization, availability)) {
            logger.warning("Doctor code is duplicated.\n");
            return;
        }

        DoctorList.add(new Doctor(code, name, specialization, availability));
        System.out.println("Doctor added successfully!\n");
    }

    /**
     * Normalize for the sake of aesthetic Return the name of that has been
     * normalized
     *
     * @param fullname student's name. Is is a <code>java.lang.String</code>
     * object
     * @return normalized student's name. Is is a <code>java.lang.String</code>
     * object
     */
    private String normalize(String fullname) {
        String name = fullname.trim();
        name = name.replaceAll("[\\s\\s]+", " ");
        String[] arrayOfString = name.split("\\s+");

        for (int i = 0; i < arrayOfString.length; i++) {
            arrayOfString[i] = arrayOfString[i].substring(0, 1).toUpperCase() + arrayOfString[i].substring(1).toLowerCase();
        }
        fullname = String.join(" ", arrayOfString);

        return fullname;
    }

    /**
     * Update a doctor find by by code
     *
     * @param DoctorList doctor list. It is a <code>java.util.ArrayList</code>
     * object
     */
    public void updateDoctor(ArrayList<Doctor> DoctorList) {
        System.out.print("Enter code: ");
        String code = normalize(Validate.checkInputString()).toUpperCase();
        //check code exist or not
        if (Validate.checkCodeExist(DoctorList, code)) {
            logger.warning("Not found doctor");
            return;
        }

        System.out.println("\nUpdate doctor with code: " + code);
        int pos = findDoctorInListByCode(DoctorList, code);

        System.out.print("    Enter name: ");
        String name = normalize(Validate.checkInputString());
        System.out.print("    Enter specialization: ");
        String specialization = Validate.checkInputString();
        System.out.print("    Enter availability: ");
        int availability = Validate.checkInputInt();
        //check user change infomation or not
        if (!Validate.checkChangeInfo(DoctorList.get(pos), code, name, specialization, availability)) {
            logger.info("No changes");
            return;
        }

        DoctorList.get(pos).setName(name);
        DoctorList.get(pos).setSpecialization(specialization);
        DoctorList.get(pos).setAvailability(availability);
        System.out.println("Update successfully!");
    }

    /**
     * Allow user delete doctor find by code
     *
     * @param DoctorList doctor list. It is a <code>java.util.ArrayList</code>
     * object
     */
    public void deleteDoctor(ArrayList<Doctor> DoctorList) {
        System.out.print("Enter code: ");
        String code = Validate.checkInputString().toUpperCase();
        int pos = findDoctorInListByCode(DoctorList, code);

        if (pos == Integer.MIN_VALUE) {
            logger.warning("Not found doctor.");
            return;
        } else {
            System.out.print("Doctor found. Are you sure to delete doctor (Y/N): ");
            boolean delete =  Validate.checkInputYN();
            if(delete) {
                DoctorList.remove(pos);
                System.out.println("Delete successfully.");
            } else {
                System.out.println("Cancel delete");
            }          
        }
        
    }

    /**
     * Search doctor by name and display to screen
     *
     * @param DoctorList doctor list. It is a <code>java.util.ArrayList</code>
     * object
     */
    public void searchDoctor(ArrayList<Doctor> DoctorList) {
        System.out.print("Enter name: ");
        String nameSearch = normalize(Validate.checkInputString());

        if (DoctorList.isEmpty()) {
            logger.warning("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : DoctorList) {
                if (doctor.getName().contains(nameSearch)) {
                    System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                            doctor.getName(), doctor.getSpecialization(),
                            doctor.getAvailability());
                }
            }
        }
    }

    /**
     * Get doctor by code and return Doctor object
     *
     * @param DoctorList doctor list. It is a <code>java.util.ArrayList</code>
     * object
     * @param code doctor code. It is a <code>java.lang.String</code> object
     * @return a doctor if found, null otherwise. It is a
     * <code>java.util.ArrayList</code> object
     */
    public int findDoctorInListByCode(ArrayList<Doctor> DoctorList, String code) {
        int index = 0;
        for (Doctor doctor : DoctorList) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return index;
            }
            index += 1;
        }
        return Integer.MIN_VALUE;
    }

    /**
     * Get the array list of doctor find by name
     *
     * @param DoctorList doctor list. It is a <code>java.util.ArrayList</code>
     * object
     * @param name doctor name. It is a <code>java.lang.String</code> object
     * @return doctor list. It is a <code>java.util.ArrayList</code> object
     */
    public ArrayList<Doctor> listFoundByName(ArrayList<Doctor> DoctorList, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();

        return listFoundByName;
    }
}
