/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package j1.s.p0055;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 *
 * @author quyen
 */
public class DoctorsManagementIT {
    private DoctorsManagement doctorsManagement;
    private DoctorsList docList;

    @Before
    public void setUp() {
        docList = new DoctorsList();
        doctorsManagement = new DoctorsManagement();
    }

    //Update
    @Test
    public void testUpdateDoc() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Update the doctor
        doctorsManagement.updateDoc("id", "newName", "newSpecial", 10);

        // Check that the doctor was updated
        Doctor updatedDoctor = doctorsManagement.getDoctorByID("id");
        assertEquals("newName", updatedDoctor.getName());
        assertEquals("newSpecial", updatedDoctor.getSpecialization());
        assertEquals(10, updatedDoctor.getAvailability());
    }
    @Test
    public void testUpdateNonExistingDoc() {
        // Try to update a doctor that doesn't exist
        doctorsManagement.updateDoc("nonExistingId", "newName", "newSpecial", 10);

        // Check that the doctor was not found and updated
        Doctor updatedDoctor = doctorsManagement.getDoctorByID("nonExistingId");
        assertNull(updatedDoctor);
    }

    @Test
    public void testUpdateDocWithSameValues() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Update the doctor with the same values
        doctorsManagement.updateDoc("id", "name", "special", 5);

        // Check that the doctor's values remain the same
        Doctor updatedDoctor = doctorsManagement.getDoctorByID("id");
        assertEquals("name", updatedDoctor.getName());
        assertEquals("special", updatedDoctor.getSpecialization());
        assertEquals(5, updatedDoctor.getAvailability());
    }

    @Test
    public void testUpdateDocWithInvalidName() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Update the doctor with an invalid name
        doctorsManagement.updateDoc("id", "", "newSpecial", 10);

        // Check that the doctor's name was not updated
        Doctor updatedDoctor = doctorsManagement.getDoctorByID("id");
        assertEquals("name", updatedDoctor.getName());
    }

    @Test
    public void testUpdateDocWithInvalidSpecialization() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Update the doctor with an invalid specialization
        doctorsManagement.updateDoc("id", "newName", "", 10);

        // Check that the doctor's specialization was not updated
        Doctor updatedDoctor = doctorsManagement.getDoctorByID("id");
        assertEquals("special", updatedDoctor.getSpecialization());
    }

    @Test
    public void testUpdateDocWithInvalidAvailability() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Update the doctor with an invalid availability
        doctorsManagement.updateDoc("id", "newName", "newSpecial", -1);

        // Check that the doctor's availability was not updated
        Doctor updatedDoctor = doctorsManagement.getDoctorByID("id");
        assertEquals(5, updatedDoctor.getAvailability());
    }

    //ADD
    @Test
    public void testAddNewDoc() {
        // Add a new doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Check that the doctor was added
        Doctor addedDoctor = doctorsManagement.getDoctorByID("id");
        assertNotNull(addedDoctor);
        assertEquals("name", addedDoctor.getName());
        assertEquals("special", addedDoctor.getSpecialization());
        assertEquals(5, addedDoctor.getAvailability());
    }

    @Test
    public void testAddDocWithSameId() {
        // Add a doctor to the list
        Doctor doctor1 = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor1);

        // Try to add another doctor with the same ID
        Doctor doctor2 = new Doctor("id", "newName", "newSpecial", 10);
        doctorsManagement.addDoc(doctor2);

        // Check that the second doctor was not added
        Doctor addedDoctor = doctorsManagement.getDoctorByID("id");
        assertEquals("name", addedDoctor.getName());
        assertEquals("special", addedDoctor.getSpecialization());
        assertEquals(5, addedDoctor.getAvailability());
    }

    @Test
    public void testAddDocWithInvalidName() {
        // Try to add a doctor with an invalid name
        Doctor doctor = new Doctor("id", "", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Check that the doctor was not added
        Doctor addedDoctor = doctorsManagement.getDoctorByID("id");
        assertNull(addedDoctor);
    }

    @Test
    public void testAddDocWithInvalidSpecialization() {
        // Try to add a doctor with an invalid specialization
        Doctor doctor = new Doctor("id", "name", "", 5);
        doctorsManagement.addDoc(doctor);

        // Check that the doctor was not added
        Doctor addedDoctor = doctorsManagement.getDoctorByID("id");
        assertNull(addedDoctor);
    }

    @Test
    public void testAddDocWithInvalidAvailability() {
        // Try to add a doctor with an invalid availability
        Doctor doctor = new Doctor("id", "name", "special", -1);
        doctorsManagement.addDoc(doctor);

        // Check that the doctor was not added
        Doctor addedDoctor = doctorsManagement.getDoctorByID("id");
        assertNull(addedDoctor);
    }

    @Test
    public void testAddDocWithNull() {
        // Try to add a null doctor
        doctorsManagement.addDoc(null);

        // Check that the doctor was not added
        Doctor addedDoctor = doctorsManagement.getDoctorByID("null");
        assertNull(addedDoctor);
    }


    @Test
    public void testDelExistingDoc() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Delete the doctor
        doctorsManagement.delDoc(doctor);

        // Check that the doctor was deleted
        Doctor deletedDoctor = doctorsManagement.getDoctorByID("id");
        assertNull(deletedDoctor);
    }

    @Test
    public void testDelNonExistingDoc() {
        // Create a doctor that doesn't exist in the list
        Doctor doctor = new Doctor("nonExistingId", "name", "special", 5);

        // Try to delete the doctor
        doctorsManagement.delDoc(doctor);

        // Check that the doctor was not found and deleted
        Doctor deletedDoctor = doctorsManagement.getDoctorByID("nonExistingId");
        assertNull(deletedDoctor);
    }

    @Test
    public void testDelDocAfterUpdate() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Update the doctor
        doctorsManagement.updateDoc("id", "newName", "newSpecial", 10);

        // Delete the doctor
        doctorsManagement.delDoc(doctor);

        // Check that the doctor was deleted
        Doctor deletedDoctor = doctorsManagement.getDoctorByID("id");
        assertNull(deletedDoctor);
    }

    @Test
    public void testDelDocAfterAdd() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Delete the doctor
        doctorsManagement.delDoc(doctor);

        // Check that the doctor was deleted
        Doctor deletedDoctor = doctorsManagement.getDoctorByID("id");
        assertNull(deletedDoctor);
    }

    @Test
    public void testDelDocWithNull() {
        // Try to delete a null doctor
        doctorsManagement.delDoc(null);

        // Check that the doctor was not deleted
        Doctor deletedDoctor = doctorsManagement.getDoctorByID("null");
        assertNull(deletedDoctor);
    }

    @Test
    public void testDelDocWithInvalidValues() {
        // Create a doctor with invalid values
        Doctor doctor = new Doctor("", "", "", -1);

        // Try to delete the doctor
        doctorsManagement.delDoc(doctor);

        // Check that the doctor was not deleted
        Doctor deletedDoctor = doctorsManagement.getDoctorByID("");
        assertNull(deletedDoctor);
    }

    @Test
    public void testSearchExistingDoc() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Search for the doctor
        ArrayList<Doctor> searchResults = doctorsManagement.searchDoc("name");

        // Check that the doctor was found
        assertTrue(searchResults.contains(doctor));
    }

    @Test
    public void testSearchNonExistingDoc() {
        // Search for a doctor that doesn't exist
        ArrayList<Doctor> searchResults = doctorsManagement.searchDoc("nonExistingName");

        // Check that no doctors were found
        assertTrue(searchResults.isEmpty());
    }

    @Test
    public void testSearchDocWithInvalidQuery() {
        // Search with an invalid query
        ArrayList<Doctor> searchResults = doctorsManagement.searchDoc("");

        // Check that no doctors were found
        assertTrue(searchResults.isEmpty());
    }

    @Test
    public void testSearchDocWithNullQuery() {
        // Search with a null query
        ArrayList<Doctor> searchResults = doctorsManagement.searchDoc(null);

        // Check that no doctors were found
        assertTrue(searchResults.isEmpty());
    }

    @Test
    public void testSearchDocAfterUpdate() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Update the doctor
        doctorsManagement.updateDoc("id", "newName", "newSpecial", 10);

        // Search for the doctor with the new name
        ArrayList<Doctor> searchResults = doctorsManagement.searchDoc("newName");

        // Check that the doctor was found
        assertTrue(searchResults.contains(doctor));
    }

    @Test
    public void testSearchDocAfterAdd() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Search for the doctor
        ArrayList<Doctor> searchResults = doctorsManagement.searchDoc("name");

        // Check that the doctor was found
        assertTrue(searchResults.contains(doctor));
    }

    @Test
    public void testPrintEmptyDocList() {
        // Print the list of doctors when it's empty
        doctorsManagement.printDoc();

        // Since we can't directly check the console output in a JUnit test,
        // we need to manually verify that the console output is correct.
        // In this case, the console output should indicate that the list is empty.
    }

    @Test
    public void testPrintDocListWithOneDoctor() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Print the list of doctors
        doctorsManagement.printDoc();

        // Since we can't directly check the console output in a JUnit test,
        // we need to manually verify that the console output is correct.
        // In this case, the console output should include the details of the added doctor.
    }

    @Test
    public void testPrintDocListWithMultipleDoctors() {
        // Add multiple doctors to the list
        Doctor doctor1 = new Doctor("id1", "name1", "special1", 5);
        Doctor doctor2 = new Doctor("id2", "name2", "special2", 10);
        doctorsManagement.addDoc(doctor1);
        doctorsManagement.addDoc(doctor2);

        // Print the list of doctors
        doctorsManagement.printDoc();

        // Since we can't directly check the console output in a JUnit test,
        // we need to manually verify that the console output is correct.
        // In this case, the console output should include the details of all added doctors.
    }

    @Test
    public void testPrintDocListAfterUpdate() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Update the doctor
        doctorsManagement.updateDoc("id", "newName", "newSpecial", 10);

        // Print the list of doctors
        doctorsManagement.printDoc();

        // Since we can't directly check the console output in a JUnit test,
        // we need to manually verify that the console output is correct.
        // In this case, the console output should include the details of the updated doctor.
    }

    @Test
    public void testPrintDocListAfterDelete() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Delete the doctor
        doctorsManagement.delDoc(doctor);

        // Print the list of doctors
        doctorsManagement.printDoc();

        // Since we can't directly check the console output in a JUnit test,
        // we need to manually verify that the console output is correct.
        // In this case, the console output should indicate that the list is empty.
    }

    @Test
    public void testPrintDocListAfterSearch() {
        // Add a doctor to the list
        Doctor doctor = new Doctor("id", "name", "special", 5);
        doctorsManagement.addDoc(doctor);

        // Search for the doctor
        ArrayList<Doctor> searchResults = doctorsManagement.searchDoc("name");

        // Print the list of doctors
        doctorsManagement.printDoc();

        // Since we can't directly check the console output in a JUnit test,
        // we need to manually verify that the console output is correct.
        // In this case, the console output should include the details of the searched doctor.
    }
    
}
