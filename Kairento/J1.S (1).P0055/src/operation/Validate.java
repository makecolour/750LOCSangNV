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

import object.Doctor;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class is to validate all the things that the user type in
 *
 * @author Nguyen Hoang Manh
 */
public class Validate {

    private final static Scanner in = new Scanner(System.in);
    private final static Logger logger = Logger.getLogger(Validate.class.getName());

    /**
     * Check user input for string
     *
     * @return a string if the condition is met. It is a
     * <code>java.lang.String</code> object
     */
    public static String checkInputString() {
        //loop until user input correct
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                logger.warning("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    /**
     * Check user input for an integer
     *
     * @return an integer if all conditions is met. It is a
     * <code>java.lang.Integer</code> object
     */
    public static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                logger.warning("Please input number integer");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * Check input for Yes or No
     *
     * @return true if user choose Yes, false otherwise. It is a
     * <code>java.lang.Boolean</code> object
     */
    public static boolean checkInputYN() {
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
            logger.warning("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    /**
     * Check if the doctor code is existed in doctor list or not
     *
     * @param DoctorList Doctor list. It is a <code>java.util.ArrayList</code>
     * object
     * @param code doctor code. It is a <code>java.lang.String</code> object
     * @return true if existed, false otherwise. It is a
     * <code>java.lang.Boolean</code> object
     */
    public static boolean checkCodeExist(ArrayList<Doctor> DoctorList, String code) {
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
     * @param DoctorList Doctor list. It is a <code>java.util.ArrayList</code>
     * object
     * @param code doctor code. It is a <code>java.lang.String</code> object
     * @param name doctor name. It is a <code>java.lang.String</code> object
     * @param specialization doctor specialization. It is a
     * <code>java.lang.String</code> object
     * @param availability doctor availability. It is a
     * <code>java.lang.Integer</code> object
     * @return true if duplicate, false otherwise. It is a
     * <code>java.lang.Boolean</code> object
     */
    public static boolean checkDuplicate(ArrayList<Doctor> DoctorList, String code,
            String name, String specialization, int availability) {
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
     * @param doctor Doctor. It í a <code>object.Doctor</code> object
     * @param code doctor code. It is a <code>java.lang.String</code> object
     * @param name doctor name. It is a <code>java.lang.String</code> object
     * @param specialization doctor specialization. It is a
     * <code>java.lang.String</code> object
     * @param availability doctor availability. It is a
     * <code>java.lang.Integer</code> object
     * @return true if changed, false otherwise. It is a
     * <code>java.lang.Boolean</code> object
     */
    public static boolean checkChangeInfo(Doctor doctor, String code,
            String name, String specialization, int availability) {
        if (doctor.getCode().equalsIgnoreCase(code)
                && doctor.getName().equalsIgnoreCase(name)
                && doctor.getSpecialization().equalsIgnoreCase(specialization)
                && doctor.getAvailability() == availability) {
            return false;
        }
        return true;
    }
}
