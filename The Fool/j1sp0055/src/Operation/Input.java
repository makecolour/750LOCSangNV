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

import Main.ErrorLogger;
import Object.Doctor;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is to validate all the things that the use r types in
 *
 * @author La Dieu Minh
 */
public class Input {

    private final Scanner in = new Scanner(System.in);
    private final ErrorLogger erl = new ErrorLogger();
    private final String className = Input.class.getName();

    /**
     * Check user input for string
     *
     * @return String
     */
    public String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                erl.Log(className, "Input is empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * check if int is over limit
     *
     * @param min min value
     * @param max max value
     * @return the value
     */
    public int checkLimit(int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(in.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                erl.Log(className, "Re-input");
            }
        }
    }

    /**
     * Check user input for an integer
     *
     * @return an integer
     */
    public int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                erl.Log(className, "Please input number integer");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Check input for Yes or No
     *
     * @return boolean
     */
    public boolean checkInputYN() {
        //loop until user input correct
        while (true) {
            String result = checkInputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            erl.Log(className, "Please input Y/N.");
            System.out.print("Enter again: ");
        }
    }

    /**
     * Check if the doctor code is existed in the doctor list or not
     *
     * @param DoctorList Doctor list
     * @param code doctor code
     * @return boolean
     */
    public boolean checkCodeExist(ArrayList<Doctor> DoctorList, String code) {
        //check from first to last list doctor
        for (Doctor doctor : DoctorList) {
            if (code.equalsIgnoreCase(doctor.getCode())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the doctor is duplicate
     *
     * @param DoctorList Doctor list
     * @param code doctor code
     * @param name doctor name
     * @param specialization doctor specialization
     * @param availability doctor availability
     * @return boolean
     */
    public boolean checkDuplicate(ArrayList<Doctor> DoctorList, String code, String name, String specialization, int availability) {
        //check from first to last list doctor
        for (Doctor doctor : DoctorList) {
            if (code.equalsIgnoreCase(doctor.getCode())
                    && name.equalsIgnoreCase(doctor.getName())
                    && specialization.equalsIgnoreCase(doctor.getSpecialization())
                    && availability == doctor.getAvailability()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check user change doctor information or not
     *
     * @param doctor Doctor
     * @param code doctor code
     * @param name doctor name
     * @param specialization doctor specialization
     * @param availability doctor availability
     * @return boolean
     */
    public boolean checkChangeInfo(Doctor doctor, String code, String name, String specialization, int availability) {
        return !doctor.getCode().equalsIgnoreCase(code) || !doctor.getName().equalsIgnoreCase(name) || !doctor.getSpecialization().equalsIgnoreCase(specialization) || doctor.getAvailability() != availability;
    }
}
