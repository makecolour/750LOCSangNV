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

/**
 * This class contains all the attribute of a doctor
 *
 * @author 
 */
public class Doctor {

    private String doctorCode;
    private String doctorName;
    private String specialization;
    private int availability;

    /**
     * Default constructor
     */
    public Doctor() {
    }

    /**
     * Parameter constructor
     *
     * @param doctorCode for code attribute
     * @param doctorName for name attribute
     * @param specialization for specialization attribute
     * @param availability for availability attribute
     */
    public Doctor(String doctorCode, String doctorName, String specialization, int availability) {
        this.doctorCode = doctorCode;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.availability = availability;
    }

    /**
     * @return doctorCode
     */
    public String getCode() {
        return doctorCode;
    }

    /**
     * @return doctorName
     */
    public String getName() {
        return doctorName;
    }

    /**
     * @return specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @return return availability
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Set doctorCode
     *
     * @param code value to set
     */
    public void setCode(String code) {
        this.doctorCode = code;
    }

    /**
     * Set doctorName
     *
     * @param name value to set
     */
    public void setName(String name) {
        this.doctorName = name;
    }

    /**
     * Set specialization
     *
     * @param specialization value to set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Set availability
     *
     * @param availability value to set
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
