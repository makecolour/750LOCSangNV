/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Doctor management program> :				
 * <Create a Java console program to manage doctor.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program to manage information of Doctor.>				
 */
package entity;

/**
 * The `Doctor` class represents a medical doctor with attributes such as code,
 * name, specialization, and availability. It provides methods to access and
 * modify these attributes and also includes a custom `toString` method for
 * formatting.
 *
 * @author Trần Đức Anh
 */
public class Doctor {

    private String code;
    private String name;
    private String specialization;
    private int availability;

    /**
     * Default constructor for the `Doctor` class. Initializes all attributes to
     * their default values.
     */
    public Doctor() {
    }

    /**
     * Parameterized constructor for the `Doctor` class.
     *
     * @param code The unique code for the doctor.
     * @param name The name of the doctor.
     * @param specialization The medical specialization of the doctor.
     * @param availability The availability status or schedule of the doctor.
     */
    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    /**
     * Get the unique code of the doctor.
     *
     * @return The doctor's code.
     */
    public String getCode() {
        return code;
    }

    /**
     * Set the unique code of the doctor.
     *
     * @param code The new code for the doctor.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get the name of the doctor.
     *
     * @return The doctor's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the doctor.
     *
     * @param name The new name for the doctor.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the medical specialization of the doctor.
     *
     * @return The doctor's specialization.
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Set the medical specialization of the doctor.
     *
     * @param specialization The new specialization for the doctor.
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Get the availability status or schedule of the doctor.
     *
     * @return The doctor's availability.
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Set the availability status or schedule of the doctor.
     *
     * @param availability The new availability status for the doctor.
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * Override of the `toString` method to provide a formatted string
     * representation of the `Doctor` object.
     *
     * @return A formatted string representing the doctor's information.
     */
    @Override
    public String toString() {
        return String.format("%-6s %-10s %-12s    %12s", code, name, specialization, availability);
    }

}
