/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Doctor management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0                           First implemention
 */
package doctormanagementsystem;

import java.util.ArrayList;

/**
 * This class contain methods for manage the doctor list
 *
 * @author 
 */
public class DoctorManager {

    private static final ArrayList<Doctor> doctorList = new ArrayList<>();

    /**
     * Allow user to add new doctor
     */
    public void addDoctor() {
        String code = checkCode();
        String name = checkNormalize(UserInput.getString("Enter name: "));
        String specialization = UserInput.getString("Enter specialization: ");
        int availability = UserInput.getInt("Enter availability: ");
        doctorList.add(new Doctor(code, name, specialization, availability));
    }

    /**
     * Find doctor by doctor id
     *
     * @param id value to find
     * @return an integer
     */
    private Doctor findDoctorById(String id) {
        for (int i = 0; i < doctorList.size(); i++) {
            if (doctorList.get(i).getCode().equalsIgnoreCase(id)) {
                return doctorList.get(i);
            }
        }
        return null;
    }

    /**
     * Allow user to update a doctor
     */
    public void updateDoctor() {
        if (doctorList.isEmpty()) {
            MyLog.getLogger().warning("This list is empty!");
            return;
        }
        String code = UserInput.getString("Enter code: ");
        String name = checkNormalize(UserInput.getString("Enter name: "));
        String specialization = UserInput.getString("Enter specialization: ");
        int availability = UserInput.getInt("Enter availability: ");
        Doctor doctor = findDoctorById(code);
        if (doctor == null) {
            MyLog.getLogger().warning("Code not existed!");
        } else {
            doctor.setName(name);
            doctor.setSpecialization(specialization);
            doctor.setAvailability(availability);
        }
    }

    /**
     * Allow user to delete a doctor
     */
    public void deleteDoctor() {
        if (doctorList.isEmpty()) {
            MyLog.getLogger().warning("This list is empty!");
            return;
        }
        String code = UserInput.getString("Enter code: ");
        Doctor doctor = findDoctorById(code);
        if (doctor == null) {
            MyLog.getLogger().info("Code not existed!");
        } else {
            String choose;
            do {
                choose = UserInput.getString("Do you want to delete Y/N:");
                if (choose.equalsIgnoreCase("Y") || choose.equalsIgnoreCase("N")) {
                    break;
                }
            } while (true);
            if (choose.equalsIgnoreCase("y")) {
                doctorList.remove(doctor);
                MyLog.getLogger().info("Doctor delete successfully!");
            }

        }
    }

    /**
     * Allow user to search doctor
     */
    public void searchDoctor() {
        if (doctorList.isEmpty()) {
            MyLog.getLogger().warning("This list is empty!");
            return;
        }
        String name = UserInput.getString("Enter name: ");
        name = checkNormalize(name);
        ArrayList<Doctor> listFoundByName = listFoundByName(name);
        if (listFoundByName.isEmpty()) {
            MyLog.getLogger().info("No Doctor found!");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name", "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }
        }
    }

    /**
     * Add found doctor to a list
     *
     * @param name value to search
     * @return an arrayList
     */
    private ArrayList<Doctor> listFoundByName(String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : doctorList) {
            if (doctor.getName().toLowerCase().contains(name.toLowerCase())) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }

    /**
     * Validate the doctorCode
     *
     * @return a String
     */
    private String checkCode() {
        String code;
        Doctor doctor;
        do {
            code = UserInput.getString("Enter code: ");
            doctor = findDoctorById(code);
            if (doctor != null) {
                MyLog.getLogger().warning("Doctor code duplicate: ");
            }
        } while (doctor != null);
        return code;
    }

    /**
     * Normalize the doctor name
     *
     * @param fullname value to normalize
     * @return normalized name
     */
    private String checkNormalize(String fullname) {
        String[] Split = fullname.trim().split("[\\s]+");
        fullname = "";
        for (String a : Split) {
            fullname += a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase() + " ";
        }
        fullname = fullname.trim();
        return fullname;
    }
}
