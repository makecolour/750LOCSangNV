/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Doctor management program> :				
 * <Create a Java console program to manage doctor.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program to manage information of Doctor.>				
 */
package manage;

import entity.Doctor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The DoctorHash class represents a database of doctors using a HashMap data
 * structure. It allows users to add, update, delete, search, and display doctor
 * information. Each doctor is uniquely identified by a code, name,
 * specialization, and availability.
 *
 * @author Trần Đức Anh
 */
public class DoctorHash {

    private HashMap<String, Doctor> doctorMap;

    /**
     * Initializes a new instance of the DoctorHash class and populates it with
     * some initial doctor entries for demonstration purposes.
     */
    public DoctorHash() {
        doctorMap = new HashMap<>();
        //doctorMap.put("10", new Doctor("DOC 1", "Nghia", "Orthopedics", 0));
        //doctorMap.put("2", new Doctor("DOC 2", "Phuong", "Obstetrics", 1));
        //doctorMap.put("3", new Doctor("DOC 3", "Lien", "orthodontic", 2));
    }

    /**
     * Adds a new doctor to the database. The user is prompted for the doctor's
     * code, name, specialization, and availability.
     */
    public void addDoctor() {
        System.out.println("=================== Add Doctor ==================");
        Doctor newDoctor = new Doctor();
        String text = null;
        newDoctor.setCode(InputUser.getCode("doctor code", doctorMap));
        newDoctor.setName(InputUser.getString("doctor name", text));
        newDoctor.setSpecialization(InputUser.getString("specialization", text));
        newDoctor.setAvailability(InputUser.getInt("availability", 0, 10));
        doctorMap.put(newDoctor.getCode(), newDoctor);
        System.err.println("Status doctor added");
    }

    /**
     * Updates an existing doctor's information in the database. The user can
     * choose which attribute (code, name, specialization, or availability) to
     * update.
     */
    public void updateDoctor() {
        System.out.println("==================== Update Doctor ===================");
        String text = null;
        if (doctorMap.isEmpty()) {
            System.err.println("Database does not exist");
        } else {
            do {

                String code = InputUser.getString("code to update", text);
                //Map.Entry<String, Doctor> updateDoctor = findByCode(code);
                Doctor updateDoctor = doctorMap.get(code);

                if (updateDoctor == null) {
                    System.err.println("Doctor code doesn’t exist");
                } else {
                    System.out.println("Attribute: 1.Doctor Name | 2.Specialization | 3.Availability");
                    int choice = InputUser.getInt("Attribute", 1, 3);
                    //update student's attribute
                    switch (choice) {
                        case 1:
                            updateDoctor.setName(InputUser.getString("new doctor Name", text));
                            break;
                        case 2:
                            updateDoctor.setSpecialization(InputUser.getString("new specialization", text));
                            break;
                        case 3:
                            updateDoctor.setAvailability(InputUser.getInt("new availability", 0, 10));
                            break;
                    }
                    //allow user to continue/stop updating doctor
                    System.out.println("Do you want to continue updating");
                    do {
                        //ask user to continue update or delete
                        text = InputUser.getString("Y/N", text);
                        if ("y".equalsIgnoreCase(text) || "n".equalsIgnoreCase(text)) {
                            break;
                        }
                    } while (true);
                    if ("n".equalsIgnoreCase(text)) {
                        System.err.println("Status doctor fix");
                        break;
                    }
                }
            } while (true);
        }
    }

    /**
     * Deletes a doctor from the database based on their code.
     */
    public void deleteDoctor() {
        String text = null;
        System.out.println("==================== Delete Doctor ===================");
        if (doctorMap.isEmpty()) {
            System.err.println("Database does not exist");
        } else {
            String code = InputUser.getString("code to remove", text);
            //Map.Entry doctorFound = findByCode(code);
            Doctor doctorFound = doctorMap.get(code);
            if (doctorFound == null) {
                System.err.println("Database does not exist");
            } else {
                doctorMap.remove(doctorFound);
                System.err.println("Status doctor fixed.");
            }
        }
    }

    /**
     * Displays the list of doctors in the database
     */
    private void show() {
        System.out.println("Code   Name       Specialization    	Availability");
        for (Map.Entry<String, Doctor> entry : doctorMap.entrySet()) {
            System.out.println(entry);
        }
    }

    /**
     * Searches for doctors in the database
     */
    public void searchDoctor() {
        System.out.println("==================== Search Doctor ===================");
        int choice = 0;
        String text = null;
        if (doctorMap.isEmpty()) {
            System.err.println("Database does not exist");
        } else {
            choice = InputUser.getInt("choice(1.Code| 2.Name| 3.Specialization))", 1, 3);
            text = InputUser.getString("string", text);

            List<Doctor> doctorMapFound = findByString(choice, text);
            if (doctorMapFound.isEmpty()) {
                System.err.println("Database does not exist");
            } else {
                System.out.println("Code   Name	  Specialization       Availability");
                for (Doctor doctor : doctorMapFound) {
                    System.out.println(doctor);
                }
            }
        }
    }

    /**
     * Help method search to find doctors in the database based on a string
     * input
     *
     * @param choice The case search (1 for code, 2 for name, 3 for
     * specialization).
     * @param inputValue The input value to search.
     * @return A HashMap containing matching doctors based on inputValue
     */
    private List findByString(int choice, String inputValue) {
        List<Doctor> newDoctorList = new ArrayList<Doctor>();
        if (choice == 1) {
            for (Map.Entry<String, Doctor> entry : doctorMap.entrySet()) {
                if (entry.getValue().getCode().toLowerCase().equals(inputValue.toLowerCase())) {
                    newDoctorList.add(entry.getValue());
                }
            }
        } else if (choice == 2) {
            for (Map.Entry<String, Doctor> entry : doctorMap.entrySet()) {
                if (entry.getValue().getName().toLowerCase().contains(inputValue.toLowerCase())) {
                    newDoctorList.add(entry.getValue());
                }
            }
        } else {
            for (Map.Entry<String, Doctor> entry : doctorMap.entrySet()) {
                if (entry.getValue().getSpecialization().toLowerCase().contains(inputValue.toLowerCase())) {
                    newDoctorList.add(entry.getValue());
                }
            }
        }
        return newDoctorList;
    }
}
