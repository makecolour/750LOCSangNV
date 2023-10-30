/*							
 * Copyright(C) 2023,  FPT University.							
 * Doctor Management							
 * Manage information of doctors				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage information of doctors>							
 */
package object;

/**
 * This class contains all informations of a doctor
 *
 * @author Nguyen Hoang Manh
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
     * @param code doctor code. It is a <code>java.lang.String</code> object
     * @param name doctor name. It is a <code>java.lang.String</code> object
     * @param specialization doctor specialization. It is a
     * <code>java.lang.String</code> object
     * @param availability doctor availability. It is a
     * <code>java.lang.Integer</code> object
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
     * @return a string. It is a <code>java.lang.String</code> object
     */
    public String getCode() {
        return code;
    }

    /**
     * Set doctor code to given code
     *
     * @param code doctor code. It is a <code>java.lang.String</code> object
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get doctor name and return
     *
     * @return a string. It is a <code>java.lang.String</code> object
     */
    public String getName() {
        return name;
    }

    /**
     * Set doctor name to the given name
     *
     * @param name doctor name. It is a <code>java.lang.String</code> object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get doctor specialization and return
     *
     * @return an integer. It is a <code>java.lang.Integer</code> object
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Set doctor specialization to the given parameter
     *
     * @param specialization doctor specialization. It is a
     * <code>java.lang.String</code> object
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Get doctor availability and return
     *
     * @return an integer. It is a <code>java.lang.Integer</code> object
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Set doctor availability to the given parameter
     *
     * @param availability doctor availability. It is a
     * <code>java.lang.Intger</code> object
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }
}
