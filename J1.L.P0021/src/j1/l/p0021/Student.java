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
 * This class represent Student objects
 *
 * @author quyen
 */
public class Student {

    private String id;
    private String name;
    private int semester;
    private CoursesList cl = new CoursesList();

    /**
     * Constructor
     */
    public Student() {
    }

    /**
     * Constructor with param
     *
     * @param id
     * @param name
     * @param semester
     */
    public Student(String id, String name, int semester) {
        this.id = id;
        this.name = name;
        this.semester = semester;
    }

    /**
     * Getter of ID
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Getter of Name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of Semester
     *
     * @return
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Getter of Courses
     *
     * @return
     */
    public CoursesList getCl() {
        return cl;
    }

    /**
     * Setter of ID
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Setter of Name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter of Semester
     *
     * @param semester
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Setter of Courses
     *
     * @param cl
     */
    public void setCl(CoursesList cl) {
        this.cl = cl;
    }

}
