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

/**
 * This class represents Doctor object
 *
 * @author quyen
 */
public class Doctor {

    private String code;
    private String name;
    private String specialization;
    private int availability;

    /**
     * Constructor
     */
    public Doctor() {
    }

    /**
     * Constructor
     * @param code
     * @param name
     * @param specialization
     * @param availability
     */
    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    /**
     * Getter
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Getter
     * @return
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * Getter
     * @return
     */
    public int getAvailability() {
        return availability;
    }

    /**
     * Setter
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter
     * @param specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * Setter
     * @param availability
     */
    public void setAvailability(int availability) {
        this.availability = availability;
    }

}
