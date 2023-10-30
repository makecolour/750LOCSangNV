/*							
 * Copyright(C) 2023,  FPT University.							
 * Doctor Management							
 * Manage information of doctors				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-09>      <2.0>              <La Dieu Minh>      <Updated for clarity version>					
 */
package Object;

/**
 * This class contains all informations of a doctor
 *
 * @author La Dieu Minh
 */
public class Doctor {

    private String code;
    private String name;
    private String specialization;
    private int availability;

    /**
     * Constructor allowed this class to be initialized
     */
    public Doctor() {
    }

    /**
     * Constructor allowed this class to be initialized with value
     *
     * @param code doctor code
     * @param name doctor name
     * @param specialization doctor specialization
     * @param availability doctor availability
     */
    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    /**
     * Get doctor code and return
     *
     * @return a string
     */
    public String getCode() {
        return code;
    }

    /**
     * Set doctor code to given code
     *
     * @param code doctor code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get doctor name and return
     *
     * @return doctor name
     */
    public String getName() {
        return name;
    }

    /**
     * Set doctor name to the given name
     *
     * @param name doctor name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get doctor specialization and return
     *
     * @return Specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Set doctor specialization to the given parameter
     *
     * @param specialization doctor specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Get doctor availability and return
     *
     * @return Availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Set doctor availability to the given parameter
     *
     * @param availability doctor availability
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
