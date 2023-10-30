/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Student management system> :				
 * <Create a Java console program to manage students.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <>        <Write a program to manage information of student.>				
 */
package studentmanagement;

/**
 * The class contains attribute, constructor of Student and method toString,
 * get, set to manage screen output string
 *
 *
 * @author 
 */
public class Student implements Comparable<Student> {

    private String id;
    private String studentName;
    private String semester;
    private Course[] courseList;

    /**
     * Default constructor for the Student class. Initializes a Student object
     * with default values.
     */
    public Student() {
        courseList = new Course[3];
        courseList[0] = new Course("Java", 0);
        courseList[1] = new Course(".Net", 0);
        courseList[2] = new Course("C/C++", 0);
    }

    /**
     * Constructor for the Student class that sets the student's attributes.
     *
     * @param id The student's unique identifier.
     * @param studentName The student's name.
     * @param semester The current semester the student is enrolled in.
     * @param courseList An array of courses the student is registered for.
     */
    public Student(String id, String studentName, String semester, Course[] courseList) {
        this.id = id;
        this.studentName = studentName;
        this.semester = semester;
        this.courseList = courseList;
    }

    /**
     * Gets the ID of the student.
     *
     * @return The ID of the student as a String.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the ID of the student.
     *
     * @param id The new ID for the student, provided as a String.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name of the student.
     *
     * @return The name of the student as a String.
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the name of the student.
     *
     * @param studentName The new name for the student, provided as a String.
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Gets the semester of the student.
     *
     * @return The semester of the student as a integer.
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets the semester of the student.
     *
     * @param semester The new semester for the student, provided as a integer.
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Gets the list of courses associated with the student.
     *
     * @return An array of Course objects representing the student's courses.
     */
    public Course[] getCourseList() {
        return courseList;
    }

    /**
     * Sets the list of courses associated with the student.
     *
     * @param courseList An array of Course objects representing the student's
     * courses.
     */
    public void setCourseList(Course[] courseList) {
        this.courseList = courseList;
    }

    /**
     * Converts the Student object to a formatted string representation. This
     * method returns a formatted string containing the student's ID, name, and
     * semester.
     *
     * @return A formatted string representation of the Student object.
     */
    @Override
    public String toString() {
        return String.format("| %2s | %20s | %8s | ", id, studentName, semester);
    }

    /**
     * This method is used to compare two Student objects based on their student
     * names.
     *
     * @param o The Student object to compare
     */
    @Override
    public int compareTo(Student o) {
        return this.studentName.compareTo(o.getStudentName());
    }

}
