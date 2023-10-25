/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import java.util.HashMap;

/**
 * HashMap of courses
 *
 * @author quyen
 */
public class CoursesList {

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
