/*							
 * Copyright(C) 2023,  FPT University.							
 * Doctor management program. 							
 * Manage information of Doctor					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-27>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of Doctor using List>							
 */
package j1.s.p0055;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Logger;

/**
 * This is the most important class in the program, which contains most of main
 * functions
 *
 * @author quyen
 */
public class DoctorsManagement {

    DoctorsList doc = new DoctorsList();
    Input input = new Input();
    private static final Logger LOG = Logger.getLogger(DoctorsManagement.class.getName());

    /**
     * Find Doctor by ID and return it
     *
     * @param id
     * @return
     */
    private Doctor findByID(String id) {
        for (Doctor d : doc.getList()) {
            if (d.getCode().equalsIgnoreCase(id)) {
                return d;
            }
        }
        return null;
    }

    /**
     * Input most of Doctor's attributes
     *
     * @param id
     * @return
     */
    private Doctor enter(String id) {
        String name = input.getString("Name: ", "", "");
        String special = input.getString("Specialization: ", "", "");
        int avail = input.getInt("Availability: ", 1, 10);
        Doctor d = new Doctor(id, name, special, avail);
        return d;
    }

    /**
     * Add Doctor into list
     */
    void addDoc() {
        String id;
        while (true) {
            if (doc.getList().isEmpty()) {
                id = input.getString("Code: ", "", "");
                break;
            } else {
                id = input.getString("Code: ", "", "");
                if (findByID(id) == null) {
                    break;
                } else {
                    LOG.warning("Doctor is already exist");
                }

            }
        }
        Doctor add = enter(id);
        doc.getList().add(add);
    }

    /**
     * Update a Doctor's attribute
     *
     * @param d
     */
    private void updateDoc(Doctor d) {
        System.out.println("1. Name");
        System.out.println("2. Specialization");
        System.out.println("3. Availability");
        int choice = input.getInt("Your choice: ", 1, 3);
        switch (choice) {
            case 1:
                String name = input.getString("Name: ", "", "");
                while (true) {
                    char change = input.getString("Do you want to change this Doctor's name to " + name + "? Y/N ", "", "").charAt(0);
                    if (change == 'y' || change == 'Y') {
                        doc.getList().get(doc.getList().indexOf(d)).setName(name);
                        break;
                    } else if (change == 'n' || change == 'N') {
                        return;
                    } else {
                        LOG.warning("Please input Y/N");
                    }
                }
                break;
            case 2:
                String special = input.getString("Specialization: ", "", "");
                while (true) {
                    char change = input.getString("Do you want to change this Doctor's specialization to " + special + "? Y/N ", "", "").charAt(0);
                    if (change == 'y' || change == 'Y') {
                        doc.getList().get(doc.getList().indexOf(d)).setSpecialization(special);
                        break;
                    } else if (change == 'n' || change == 'N') {
                        return;
                    } else {
                        LOG.warning("Please input Y/N");
                    }
                }
                break;
            case 3:
                int avail = input.getInt("Availability: ", 1, 10);
                while (true) {
                    char change = input.getString("Do you want to change this Doctor's availability to " + avail + "? Y/N ", "", "").charAt(0);
                    if (change == 'y' || change == 'Y') {
                        doc.getList().get(doc.getList().indexOf(d)).setAvailability(avail);
                        break;
                    } else if (change == 'n' || change == 'N') {
                        return;
                    } else {
                        LOG.warning("Please input Y/N");
                    }
                }
                break;
        }
    }

    /**
     * Update doctor's attributes
     */
    void updateDoc() {
        if (doc.getList().isEmpty()) {
            LOG.warning("No doctor available");
            return;
        }
        String id = input.getString("Code: ", "", "");
        Doctor d = findByID(id);

        if (d != null) {
            updateDoc(d);
        } else {
            LOG.warning("No doctor found");
        }
    }

    /**
     * Remove a Doctor
     *
     * @param d
     */
    private void delDoc(Doctor d) {
        while (true) {
            char change = input.getString("Do you want to delete this Doctor? Y/N ", "", "").charAt(0);
            if (change == 'y' || change == 'Y') {
                doc.getList().remove(d);
                break;
            } else if (change == 'n' || change == 'N') {
                return;
            } else {
                LOG.warning("Please input Y/N");
            }
        }
    }

    /**
     * Remove a Doctor
     */
    void delDoc() {
        if (doc.getList().isEmpty()) {
            LOG.warning("No doctor available");
            return;
        }
        String id = input.getString("Code: ", "", "");
        Doctor d = findByID(id);
        if (d != null) {
            delDoc(d);
        } else {
            LOG.warning("No doctor found");
        }
    }

    /**
     * Check if query input is an integer
     *
     * @param query
     * @return
     */
    private boolean checkQuery(String query) {
        try {
            int temp = Integer.parseInt(query);
            if (Integer.toString(temp).equalsIgnoreCase(query)) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Search Doctors
     *
     * @param query
     * @return
     */
    private ArrayList<Doctor> searchDoc(String query) {
        boolean check = checkQuery(query);
        ArrayList<Doctor> list = new ArrayList();
        for (Doctor d : doc.getList()) {
            if (d.getCode().equalsIgnoreCase(query)) {
                list.add(d);
            } else if (d.getName().toLowerCase().contains(query)) {
                list.add(d);
            } else if (d.getSpecialization().toLowerCase().contains(query)) {
                list.add(d);
            } else if (check == true) {
                if (d.getAvailability() == Integer.parseInt(query)) {
                    list.add(d);
                }
            }
        }
        return list;
    }

    /**
     * Search Doctors
     */
    void searchDoc() {
        if (doc.getList().isEmpty()) {
            LOG.warning("No doctor available");
            return;
        }
        String query = input.getString("Type to search: ", "", "");
        ArrayList<Doctor> list = searchDoc(query);
        if (list.isEmpty()) {
            LOG.warning("No doctor found");
            return;
        } else {
            printDoc(list);
        }
    }

    /**
     * Print a list of Doctor
     *
     * @param list
     */
    private void printDoc(ArrayList<Doctor> list) {

        ArrayList<Doctor> tmp = list;
        Collections.sort(tmp, Comparator.comparing(Doctor::getCode));
        System.out.println("Code      Name      Sepcialization       Availability");
        for (Doctor d : tmp) {
            System.out.printf("%-10s%-10s%-21s%-10s\n", d.getCode(), d.getName(), d.getSpecialization(), Integer.toString(d.getAvailability()));
        }
    }

    /**
     * Print all of Doctor
     */
    void printDoc() {
        if (doc.getList().isEmpty()) {
            LOG.warning("No doctor available");
            return;
        }
        
        printDoc(doc.getList());
    }
}
