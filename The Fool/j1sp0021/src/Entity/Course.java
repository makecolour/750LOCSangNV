/**				
 * Copyright(C) 2023,  <FPT University>.				
 * <Student management system> :				
 * <Create a Java console program to manage students.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <3.7>     <MinhLD>        <Write a program to manage information of student.>
 */
package Entity;

/**
 * Course class
 *
 * @author La Dieu Minh
 */
public class Course {

    private String name;
    private int courseNumber;

    /**
     * Default constructor for the Course class. Initializes a Course object
     * with default values.
     */
    public Course() {
    }

    /**
     * Represents a course with a name and a course number.
     *
     * @param name The name of the course.
     * @param courseNumber The course number.
     */
    public Course(String name, int courseNumber) {
        this.name = name;
        this.courseNumber = courseNumber;
    }

    /**
     * Gets the name of the Course member.
     *
     * @return The name of the Course as a String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Course member.
     *
     * @param name The new name for the Course, provided as a String.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the course number associated with the Course member.
     *
     * @return The course number as an integer.
     */
    public int getCourseNumber() {
        return courseNumber;
    }

    /**
     * Sets the course number associated with the Course.
     *
     * @param courseNumber The new course number for the Course, provided as an
     * integer.
     */
    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    /**
     * Converts the Course object to a formatted string representation. This
     * method takes a Course object and returns a string containing specific
     * information about the Course.
     *
     * @return A formatted string representation of the Course object, including
     * the Course 's name and course number.
     */
    @Override
    public String toString() {
        return String.format(" | %-5s | %d", name, courseNumber);//super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
