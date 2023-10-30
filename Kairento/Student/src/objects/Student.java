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

import java.util.ArrayList;

/**
 * The class is to get, set, or print information of a student
 *
 * @author Nguyen Hoang Manh
 */
public class Student implements Comparable {

    private String id;
    private String studentName;
    private int semester;
    private ArrayList<Course> studentCourse;

    /**
     * Constructor with no parameter of Student
     */
    public Student() {
        id = "";
        studentName = "";
        semester = 0;
        studentCourse = new ArrayList<>();
    }

    /**
     * Constructor of Student
     *
     * @param id student id. Is is a <code>java.lang.String</code> object
     * @param studentName student name. Is is a <code>java.lang.String</code> object
     * @param semester student semester. Is is a <code>java.lang.Integer</code> object
     * @param studentCourse student course. Is is a <code>java.util.ArrayList</code> object
     */
    public Student(String id, String studentName, int semester, ArrayList<Course> studentCourse) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.studentCourse = studentCourse;
    }

    /**
     * Get student id and return
     * @return id. Is is a <code>java.lang.String</code> object
     */
    public String getId() {
        return id;
    }

    /**
     * Get student name and return
     * @return a string. Is is a <code>java.lang.String</code> object
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Get student semester and return
     * @return an integer. Is is a <code>java.lang.Integer</code> object
     */
    public int getSemester() {
        return semester;
    }

    /**
     * Get student course and return
     * @return an array list of Course. Is is a <code>java.util.ArrayList</code> object
     */
    public ArrayList<Course> getStudentCourse() {
        return studentCourse;
    }

    /**
     * set Student id to the given parameter
     * @param id student id. Is is a <code>java.lang.Integer</code> object
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set student name to given parameter
     * @param studentName student name. Is is a <code>java.lang.String</code> object
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Set student id to the given parameter
     * @param semester student semester. Is is a <code>java.lang.Integer</code> object
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     * Set student course to the given parameter
     * @param studentCourse array list of Course. Is is a <code>java.util.ArrayList</code> object
     */
    public void setStudentCourse(ArrayList<Course> studentCourse) {
        this.studentCourse = studentCourse;
    }

    /**
     * Sort by student's name
     *
     * @param stu object Student. It is a
     */
    @Override
    public int compareTo(Object stu) {
        return this.getStudentName().compareTo(((Student) stu).getStudentName());
    }

}
