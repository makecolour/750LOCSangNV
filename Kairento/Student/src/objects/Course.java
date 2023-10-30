/*							
 * Copyright(C) 2023,  FPT University.							
 * Student Management							
 * Manage information of students					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage information of students using List>							
 */
package objects;

/**
 * This class saved the courses that user took Print course and number of course
 * that user took
 *
 * @author manh
 */
public class Course {

    private String courseName;
    private int totalOfCourse = 0;

    /**
     * Constructor without parameter
     */
    public Course() {
        courseName = "";
        totalOfCourse = 0;
    }

    /**
     * Constructor with parameter
     * @param courseName course name. Is is a <code>java.lang.String</code> object
     * @param totalOfCourse total of course. Is is a <code>java.lang.Integer</code> object
     */
    public Course(String courseName, int totalOfCourse) {
        this.courseName = courseName;
        this.totalOfCourse = totalOfCourse;
    }

    /**
     * Get course name and return
     * @return a string. Is is a <code>java.lang.String</code> object
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Get total course and return 
     * @return an integer. Is is a <code>java.lang.Integer</code> object
     */
    public int getTotalOfCourse() {
        return totalOfCourse;
    }

    /**
     * Set course name to the given parameter
     * @param courseName course name. Is is a <code>java.lang.String</code> object
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Set total of course to the given parameter
     * @param totalOfCourse total of course. Is is a <code>java.lang.Integer</code> object
     */
    public void setTotalOfCourse(int totalOfCourse) {
        this.totalOfCourse = totalOfCourse;
    }

    /**
     * Add course if there is no course If there is already a course, simply
     * increment the total of course
     *
     * @param course name of the course. It is a <code>java.lang.String</code>
     * object.
     */
    public void addCourse(String course) {
        if (courseName.isEmpty()) {
            setCourseName(course);
        }

        totalOfCourse += 1;
    }

    /**
     * Return course information, contains course name and course number
     *
     * @return a String. It is a <code>java.lang.String</code> object.
     */
    @Override
    public String toString() {
        return String.format("%-20s | %d\n", getCourseName(), getTotalOfCourse());
    }

}
