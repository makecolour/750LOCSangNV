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

import java.util.HashMap;

/**
 * HashMap of courses
 *
 * @author quyen
 */
public class CoursesList {
//Co the thay bang dua value vao Course nhu 1 attribute 

    private HashMap<Course, Integer> courses = new HashMap<Course, Integer>();

    /**
     * Constructor
     *
     * @return
     */
    public HashMap<Course, Integer> getCourses() {
        return courses;
    }

    /**
     * Constructor
     */
    public CoursesList() {
        courses.put(new Course("Java"), 0);
        courses.put(new Course(".Net"), 0);
        courses.put(new Course("C/C++"), 0);
        courses.put(new Course("Total"), 0);
    }

    /**
     * set Courses HashMap
     *
     * @param courses
     */
    public void setCourses(HashMap<Course, Integer> courses) {
        this.courses = courses;
    }

}
