/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Employee management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package student_p0021;

import java.util.ArrayList;

/**
 * This class provides methods for inputting data
 *
 * @author Chu Hoang Giang
 */
public class Student implements Comparable<Student> {
    private String id;
    private String name;
    private ArrayList<Course> CourseName;
    private Semester Semester;
    
    /**
     * 
     * @param id to set student id
     * @param name to set student name
     * @param CourseName to set student CourseName
     * @param Semester to set student Semester
     */
    public Student(String id, String name, ArrayList<Course> CourseName, Semester Semester) {
        this.id = id;
        this.name = name;
        this.CourseName = CourseName;
        this.Semester = Semester;
    }

    /**
     * get id
     * @return String value
     */

    public String getId() {
        return id;
    }
    
    /**
     * get name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * get course name
     * @return ArrayList
     */
    public ArrayList<Course> getCourseName() {
        return CourseName;
    }

    /**
     * get semester
     * @return Semester 
     */
    public Semester getSemester() {
        return Semester;
    }

    /**
     * set id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * set name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set course name
     * @param CourseName 
     */
    public void setCourseName(ArrayList<Course> CourseName) {
        this.CourseName = CourseName;
    }

    /**
     * set semester
     * @param Semester 
     */
    public void setSemester(Semester Semester) {
        this.Semester = Semester;
    }
    /**
     * to get course detail of each student
     */
    public void getCourseDetail() {
        for (int i = 1; i < CourseName.size(); i++) {
            System.out.printf("%-50s%-20s%-20s%n"," ",CourseName.get(i).getName(), CourseName.get(i).getQuantity());
        }
    }
    /**
     * to compare name with other name
     * @param otherStudent to compare name with name
     * @return 
     */
    public int compareTo(Student otherStudent) {
        return this.name.compareTo(otherStudent.getName());
    }
}
