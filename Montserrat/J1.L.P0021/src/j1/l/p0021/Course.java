/*							
 * Copyright(C) 2023,  FPT University.							
 * Students management system							
 * Manage information of Students					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-25>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of Students using List>							
 */
package j1.l.p0021;

/**
 * This class represent Course object
 *
 * @author quyen
 */
public class Course {

    private String name;

    /**
     * Constructor with parameter
     *
     * @param name
     */
    public Course(String name) {
        this.name = name;
    }

    /**
     * Constructor without parameter
     */
    public Course() {
    }

    /**
     * Getter of Course's name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of String's name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
