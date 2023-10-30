/*							
 * Copyright(C) 2023,  FPT University.							
 * Student Management							
 * Manage information of students					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage information of students using List>							
 */
package operations;

import objects.Student;
import objects.Course;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * This class contains methods for adding, delete and find student In the
 * progress of adding a student, there are method such that normalize and valid
 * id to save the information that are in the right format
 *
 * @author manh
 */
public class StudentList {

    private static final Logger logger = Logger.getLogger(StudentList.class.getName());

    /**
     * Initialize ArrayList
     */
    public StudentList() {
    }

    /**
     * Add a student, save the name, id course and semester In addition, when
     * adding a course, user only allow to choose courses that are available A
     * student can have multiple course
     *
     * @param studentList list of students. Is is a
     * <code>java.util.ArrayList</code> object.
     */
    public void addStudent(ArrayList<Student> studentList) {
        Menu menu = new Menu();

        String newName;
        String newID;
        int semester;
        ArrayList<Course> studentCourses = new ArrayList<>();

        System.out.println("Enter New Student Detail: ");

        newID = getIDFromUser(studentList);

        System.out.print("    Name: ");
        newName = normalize(menu.getValidString());

        getCourseFromUser(studentCourses);

        System.out.print("    Semester: ");
        semester = menu.getValidInteger();

        studentList.add(new Student(newID, newName, semester, studentCourses));

        System.out.println("New Student has been added!");
    }

    /**
     * Get course from user, a student can have multiple course objects
     *
     * @param studentCourse student course list.
     */
    public void getCourseFromUser(ArrayList<Course> studentCourse) {
        ArrayList<String> CourseArray = new ArrayList<>(Arrays.asList("Java", ".Net", "C/C++"));
        Menu menu = new Menu();
        int choice;
        Map<String, Integer> courseAndTotal = new HashMap<>();
        String courseName;

        while (true) {
            printCourse(CourseArray);
            System.out.print("    Choose a course for student (Press " + (CourseArray.size() + 1) + " to QUIT): ");

            choice = menu.getValidInteger();
            if (choice == CourseArray.size() + 1) {
                logger.warning("Course does not exist!");
                break;
            }
            
            courseName = CourseArray.get(choice - 1);
            System.out.println("    Course " + courseName + " added!");
            if (courseAndTotal.containsKey(courseName)) {
                courseAndTotal.put(courseName, courseAndTotal.get(courseName) + 1);
            } else {
                courseAndTotal.put(courseName, 1);
            }
        }
        for (String courseString : courseAndTotal.keySet()) {
            studentCourse.add(new Course(courseString, courseAndTotal.get(courseString)));
        }
    }

    /**
     * Print out the available course
     *
     * @param CourseArray course array. Is is a <code>java.util.ArrayList</code>
     * object
     */
    private void printCourse(ArrayList<String> CourseArray) {
        int option = 1;
        System.out.print("    AVAILABLE COURSE: ");
        for (String CourseName : CourseArray) {
            System.out.print(option + "-" + CourseName + " ");
            option += 1;
        }
        System.out.println();
    }

    /**
     * Print student information to screen
     *
     * @param studentList list of students. Is is a
     * <code>java.util.ArrayList</code> object
     */
    public void report(ArrayList<Student> studentList) {
        Collections.sort(studentList);

        System.out.printf("%-30s | %-20s | %s\n", "NAME", "COURSE NAME", "TOTAL");
        for (Student stu : studentList) {
            if (stu.getStudentCourse().size() == 1) {
                System.out.printf("%-30s | %-20s | %s\n", stu.getStudentName(), stu.getStudentCourse().get(0).getCourseName(), stu.getStudentCourse().get(0).getTotalOfCourse());
            } else {
                System.out.printf("%-30s | %-20s | %s\n", stu.getStudentName(), stu.getStudentCourse().get(0).getCourseName(), stu.getStudentCourse().get(0).getTotalOfCourse());
                for (int i = 1; i < stu.getStudentCourse().size(); i++) {
                    Course course = stu.getStudentCourse().get(i);
                    System.out.printf("%-30s | %-20s | %s\n", " ", course.getCourseName(), course.getTotalOfCourse());
                }
            }
        }
        System.out.println();
    }

    /**
     * Find student by name, sort by name and print to the screen all student
     * that have a part of name
     *
     * @param studentList list of students. Is is a
     * <code>java.util.ArrayList</code> object
     * @param stuName student's name or part of the name. Is is a
     * <code>java.lang.String</code> object
     */
    public void findAndSort(ArrayList<Student> studentList, String stuName) {
        stuName = normalize(stuName.trim());

        Collections.sort(studentList);

        String courseName = "";

        System.out.printf("%-30s | %-30s | %s\n", "NAME", "COURSE NAME", "SEMESTER");
        for (Student stu : studentList) {
            if (stu.getStudentName().contains(stuName)) {
                courseName = "";
                for (Course course : stu.getStudentCourse()) {
                    courseName = courseName + course.getCourseName() + " ";
                }
                System.out.printf("%-30s | %-30s | %s\n", stu.getStudentName(), courseName, stu.getSemester());
            }
        }
        System.out.println();
    }

    /**
     * Let user choose to update or delete a student
     *
     * @param studentList list of students. Is is a
     * <code>java.util.ArrayList</code> object
     */
    public void updateOrDeleteStudent(ArrayList<Student> studentList) {
        String stuID;
        Menu menu = new Menu();
        String choice;
        boolean valid;

        System.out.print("Enter Student's ID to begin Update/Delete: ");
        stuID = menu.getValidString().toUpperCase();
        if (findByIDInList(studentList, stuID) != -1) {
            do {
                System.out.print("Do you want to update (U) or delete (D) student? ");
                choice = menu.getValidString().toUpperCase();
                valid = choice.matches("^[UD]");
            } while (!valid);

            if (choice.startsWith("U")) {
                updateStudent(studentList, stuID);
            } else if (choice.startsWith("D")) {
                deleteStudent(studentList, stuID);
            }
        } else {
            logger.warning("Student's ID is not existed");
        }
    }

    /**
     * Update student by ID
     *
     * @param studentList list of students. Is is a
     * <code>java.util.ArrayList</code> object
     * @param stuID student's ID. Is is a <code>java.lang.String</code> object
     */
    private void updateStudent(ArrayList<Student> studentList, String stuID) {
        Menu menu = new Menu();

        menu.add("Update Student's Full Information");
        menu.add("Update Student's Name");
        menu.add("Update Student's Course");
        menu.add("Update Student's Semester");
        menu.add("Done");

        String newName;
        int semester;
        ArrayList<Course> stuCourse = new ArrayList<>();

        int pos = findByIDInList(studentList, stuID);

        int userChoice;
        System.out.print("\nUpdate Student with ID: " + stuID + "\n");
        do {
            userChoice = menu.getUserChoice();
            switch (userChoice) {
                case 1:
                    System.out.print("    Name: ");
                    newName = normalize(menu.getValidString());
                    studentList.get(pos).setStudentName(newName);

                    getCourseFromUser(stuCourse);
                    studentList.get(pos).setStudentCourse(stuCourse);

                    System.out.print("    Semester: ");
                    semester = menu.getValidInteger();
                    studentList.get(pos).setSemester(semester);
                    break;

                case 2:
                    System.out.print("    Name: ");
                    newName = normalize(menu.getValidString());
                    studentList.get(pos).setStudentName(newName);
                    break;

                case 3:
                    System.out.print("    Course Name: ");
                    getCourseFromUser(stuCourse);
                    studentList.get(pos).setStudentCourse(stuCourse);
                    break;

                case 4:
                    System.out.print("    Semester: ");
                    semester = menu.getValidInteger();
                    studentList.get(pos).setSemester(semester);
                    break;
            }

        } while (userChoice < menu.size());

        System.out.println("Update is done.");
    }

    /**
     * Delete student by ID
     *
     * @param studentList list of students. Is is a
     * <code>java.util.ArrayList</code> object
     * @param stuID student's ID. Is is a <code>java.lang.String</code> object
     */
    private void deleteStudent(ArrayList<Student> studentList, String stuID) {
        int pos = findByIDInList(studentList, stuID);
        studentList.remove(pos);

        System.out.println("Student with ID: " + stuID + " has been delete");
    }

    /**
     * Check if the list of students is empty
     *
     * @param studentList list of students. Is is a
     * <code>java.util.ArrayList</code> object
     * @return true if the list is empty, false otherwise. Is is a
     * <code>java.lang.Boolean</code> object
     */
    public boolean isEmptyList(ArrayList<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("Empty List");
            return true;
        }
        return false;
    }

    /**
     * Find student by id Return the position of student in the list
     *
     * @param studentList list of students. Is is a
     * <code>java.util.ArrayList</code> object
     * @param id student's ID. Is is a <code>java.lang.String</code> object
     * @return position if found, -1 if not. Is is a
     * <code>java.lang.Integer</code> object
     */
    public int findByIDInList(ArrayList<Student> studentList, String id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Normalize for the sake of aesthetic Return the name of that has been
     * normalized
     *
     * @param fullname student's name. Is is a <code>java.lang.String</code>
     * object
     * @return normalized student's name. Is is a <code>java.lang.String</code>
     * object
     */
    private String normalize(String fullname) {
        String name = fullname.trim();
        name = name.replaceAll("[\\s\\s]+", " ");
        String[] arrayOfString = name.split("\\s+");

        for (int i = 0; i < arrayOfString.length; i++) {
            arrayOfString[i] = arrayOfString[i].substring(0, 1).toUpperCase() + arrayOfString[i].substring(1).toLowerCase();
        }
        fullname = String.join(" ", arrayOfString);

        return fullname;
    }

    /**
     * Check if the ID is existed in the list Return true if contains, false
     * otherwise
     *
     * @param id student's ID. Is is a <code>java.lang.String</code> object
     * @return true if contains, false otherwise. Is is a
     * <code>java.lang.Boolean</code> object
     */
    private boolean containID(ArrayList<Student> studentList, String id) {
        if (studentList.isEmpty()) {
            return false;
        }

        for (Student x : studentList) {
            if (id.equals(x.getId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get student's id and check if the student's id is in correct format
     *
     * @return student's id after all conditions are met. Is is a
     * <code>java.lang.String</code> object
     */
    private String getIDFromUser(ArrayList<Student> studentList) {
        Menu menu = new Menu();
        boolean existedID;
        String newID;

        boolean valid = true;

        do {
            System.out.print("    ID (Format: S000): ");
            newID = menu.getValidString().toUpperCase();

            existedID = containID(studentList, newID);
            if (existedID) {
                logger.warning("Student's ID is already existed");
                continue;
            }

            valid = newID.matches("^S\\d{3}$");
            if (!valid) {
                logger.warning("Format of student code: S and 3 digits");

            }
        } while (existedID || !valid);

        return newID;
    }

}
