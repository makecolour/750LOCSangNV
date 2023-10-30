/**
 * Copyright(C) 2023,  <FPT University>.
 * <Student management system> :
 * <Create a Java console program to manage students.>
 *
 * Record of change:
 * DATE             Version     AUTHOR           DESCRIPTION
 * <2023-09-14>      <8.2>     <MinhLD>        <Write a program to manage information of student.>
 */
package Manager;

import Display.*;
import Entity.*;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The class contains method createStudent, update, remove, search, Student
 * information from Student table in database.
 * All data will be normalized (trim space) before update/add into database.
 *
 * @author La Dieu Minh
 */
public class StudentManagement {

    private final ArrayList<Student> studentList = new ArrayList<>();
    private final Display d = new Display();
    private final Input ui = new Input();
    private final LoggerOut lo = new LoggerOut();
    private final String className = StudentManagement.class.getName();

    /**
     * default constructor
     */
    public StudentManagement() {
    }

    /**
     * create a student
     */
    public void createStudent() {
        Student newStudent;

        //loop until user don't want to createStudent student and nos >10
        do {
            newStudent = new Student();
            //get student attribute
            newStudent.setId(ui.getId("ID"));
            newStudent.setStudentName(normalize(ui.getString("student name")));
            newStudent.setSemester(ui.getSemester());
            ui.getCourse(newStudent.getCourseList());
            
            //add new student
            studentList.add(newStudent);
            lo.Log(className, "A student has been created");
            //ask user to createStudent more
            if (studentList.size() > 2) {
                System.out.println("Do you want to continue (Y/N)?");
                if (ui.confirm("Y", "N").equalsIgnoreCase("N")) {
                    break;
                }
            }
        } while (true);
    }

    /**
     * Provide the user with options to either find (1) or sort (2) students. If
     * the list of students is empty, the method informs the user that there are
     * no students. It then asks the user to choose between finding or sorting
     * students and calls the corresponding method accordingly.
     */
    public void findAndSort() {
        int choice;
        if (studentList.isEmpty()) {
            lo.Log(className, "There is no student");
        } else {
            //get choice from user
            choice = ui.getInt("choice(1.Find | 2.Sort)", 1, 2);
            System.out.println("======================================================");
            switch (choice) {
                case 1:
                    searchStudent();//call method searchStudent
                    break;
                case 2:
                    sortStudent();//call method sortStudent
                    break;
            }
        }
    }

    /**
     * Provide the user with options to update (U) or delete (D) a student. If
     * the list of students is empty, the method informs the user that there are
     * no students. It then asks the user to choose between updating or deleting
     * a student and calls the corresponding method accordingly.
     */
    public void updateAndDelete() {
        String inputId;
        if (studentList.isEmpty()) {
            lo.Log(className, "There is no student");
        } else {
            Student aStudent;
            do {
                inputId = ui.getString("student Id");
                aStudent = findId(inputId);
                if (aStudent != null) {
                    break;
                } else {
                    lo.Log(className, "Id not found");
                }
            } while (true);
            System.out.println("Student found: " + aStudent.getStudentName());
            System.out.println("Do you want to update (U) or delete (D) student");
            //get choice from user
            switch (ui.confirm("U", "D").toLowerCase()) {
                case "u":
                    updateStudent(aStudent);//call method updateStudent
                    break;
                case "d":
                    removeStudent(aStudent);//call method removeStudent
                    break;
            }
        }
    }

    /**
     * generate a report of all student currently in database
     */
    public void report() {
        if (studentList.isEmpty()) {
            lo.Log(className, "There is no student");
        } else {
            d.listDisplay(studentList);
        }
    }

    /**
     * Find a student in the list by ID.
     *
     * @param id The ID of the student to find
     * @return The student object with the matching ID, or null if
     * the ID is not found in the list
     */
    private Student findId(String id) {
        for (Student aStudent : studentList) {
            //find id on list
            if (id.equalsIgnoreCase(aStudent.getID())) {
                return aStudent;
            }
        }
        return null;
    }

    /**
     * search for a student using name
     */
    private void searchStudent() {
        String inputName;
        //check if list is empty
        if (studentList.isEmpty()) {
            lo.Log(className, "There is no student");
        }
        inputName = ui.getString("name to search");
        //find Student base on name or part of name input from user
        ArrayList<Student> aStudentList = findByName(inputName);
        //if found employee print it to screen
        if (aStudentList != null) {
            System.out.println("Student found");
            show(aStudentList);
        } else {
            lo.Log(className, "name not found");
        }

    }

    /**
     * Sort the list of students alphabetically by student name in descending
     * order (case-insensitive). The method displays the student list before and
     * after sorting.
     */
    private void sortStudent() {
        System.out.println("Student list before sorting");
        show(studentList);
        Collections.sort(studentList);
        System.out.println("Student list after sorting");
        show(studentList);
    }

    /**
     * Function to update student
     *
     * @param aStudent The student to be updated
     */
    private void updateStudent(Student aStudent) {
        do {
            System.out.println("Update student: " + aStudent.getStudentName());
            System.out.println("Attribute: 1.Student Name | 2.Semester | 3.Course");
            switch (ui.getInt("Attribute", 1, 3)) {
                case 1:
                    aStudent.setStudentName(ui.getString("new Student Name"));
                    break;
                case 2:
                    aStudent.setSemester(ui.getSemester());
                    break;
                case 3:
                    aStudent.setCourseList(ui.getCourse(aStudent.getCourseList()));
                    break;
            }
            
            if (ui.confirm("Y", "N").equalsIgnoreCase("n")) {
                System.err.println("This Student has been updated ");
                break;
            }
            System.out.println("Do you want to continue");
        } while (ui.confirm("Y", "N").equalsIgnoreCase("y"));
    }

    /**
     * Function to remove student
     *
     * @param aStudent The student to be removed
     */
    private void removeStudent(Student aStudent) {
        System.out.println("Do you want to delete student: " + aStudent.getStudentName());
        if (ui.confirm("Y", "N").equalsIgnoreCase("Y")) {
            studentList.remove(aStudent);
            System.out.println("This Student has been removed");
        }
    }

    /**
     * find the student by name
     *
     * @param name The name or part of a name to search for among the students
     * @return A list of students matching the search criteria
     */
    private ArrayList<Student> findByName(String name) {
        ArrayList<Student> cList = new ArrayList<>();
        for (Student aStudent : studentList) {
            //check if input name existed or not
            if (aStudent.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                cList.add(aStudent);
            }
        }
        //check empty list
        if (cList.isEmpty()) {
            return null;
        } else {
            return cList;
        }
    }

    /**
     * Display the list of students with their attributes, including ID, student
     * name, semester, and courses.
     *
     * @param sList The list of students to display
     */
    private void show(ArrayList<Student> sList) {
//        System.out.println("|    ID      |     Student Name     | Semester |    Course Name   |  Total Course ");
//        for (Student e : sList) {
//            System.out.print(e);
//            String courseList = " ";
//            for (int i = 0; i < e.getCourseList().length; i++) {
//                if (e.getCourseList()[i].getCourseNumber() > 0) {
//                    courseList += e.getCourseList()[i].getName();
//                    if (i != e.getCourseList().length - 1) {
//                        if (e.getCourseList()[i + 1] != null) {
//                            courseList += ", ";
//                        }
//                    }
//                }
//            }
//            System.out.println(courseList);
//        }
        
        d.listDisplay(sList);
    }

    /**
     * Convert an array of courses to a string representation.
     *
     * @param courseList The array of course objects to convert to a string.
     * @return A string representation of the array of courses
     */
    public String toCourse(Course[] courseList) {
        String courseL = "";
        for (Course course : courseList) {
            if (course.getCourseNumber() > 0) {
                courseL += course.toString();
            }
        }
        return courseL;
    }

    /**
     * Check if a given ID already exists in the list of students.
     *
     * @param inputID The ID to check for duplication
     * @return boolean
     */
    public boolean checkDuplicateId(String inputID) {
        //Load to check duplicated id
        for (Student o : studentList) {
            //check if id input from user existed
            if (inputID.equalsIgnoreCase(o.getID())) {
                System.err.println("Id already existed");
                
                return true;
            }
        }
        return false;
    }

    /**
     * This method normalize the string input
     *
     * @param studentName value to normalize
     * @return the student name
     */
    private String normalize(String studentName) {
        String[] Split = studentName.trim().split("\\s+");
        studentName = "";

        for (String a : Split) {
            studentName += a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase() + " ";
        }
        studentName = studentName.trim();
        return studentName;
    }
}
