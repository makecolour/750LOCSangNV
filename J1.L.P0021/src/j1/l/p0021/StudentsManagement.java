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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This is the most important of the program, which contains almost every
 * function that this program perform
 *
 * @author quyen
 */
public class StudentsManagement {

    private static final Logger LOG = Logger.getLogger(StudentsManagement.class.getName());
    Scanner sc = new Scanner(System.in);
    StudentsList sl = new StudentsList();
    Input input = new Input();

    /**
     * Find if there exists a Student with input ID
     *
     * @param id
     * @return
     */
    private Student findById(String id) {
        for (Student s : sl.getStudents()) {
            if (id.equalsIgnoreCase(s.getId())) {
                return s;
            }
        }
        return null;
    }

    /**
     * Create new Student and let user input
     *
     * @return
     */
    private Student createNew() {
        String id;
        String name;
        int semester;
        CoursesList course = new CoursesList();
        while (true) {
            id = input.getString("ID: ", "ID must belike HE000000 or HS0000000", "^([Hh]){1}([ESes]){1}(\\d){6}$");
            if (findById(id) == null) {
                break;
            }
            LOG.warning("ID is already exist");
        }
        name = input.getString("Name: ", "", "");
        semester = input.getInt("Semester: ", 1, 10);
        Student s = new Student(id, name, semester);
        course.setCourses(inputCourses());
        s.setCl(course);
        return s;
    }

    /**
     * Get user's input for Student's Courses
     *
     * @return
     */
    private HashMap<Course, Integer> inputCourses() {
        int java = input.getInt("Number of Java Courses: ", 0, Integer.MAX_VALUE);
        int net = input.getInt("Number of .Net Courses: ", 0, Integer.MAX_VALUE);
        int c = input.getInt("Number of C/C++ Courses: ", 0, Integer.MAX_VALUE);
        HashMap<Course, Integer> course = new HashMap<Course, Integer>();
        course.put(new Course("Java"), java);
        course.put(new Course(".Net"), net);
        course.put(new Course("C/C++"), c);
        course.put(new Course("Total"), (java + net + c));
        return course;
    }

    /**
     * Find list of students share the whole or a part of name
     *
     * @param name
     * @return
     */
    private ArrayList<Student> findByName(String name) {
        if (sl.getStudents().isEmpty()) {
            return null;
        }
        ArrayList<Student> found = new ArrayList();
        for (Student s : sl.getStudents()) {
            if (s.getName().toLowerCase().contains(name.toLowerCase())) {
                found.add(s);
            }
        }
        return found;
    }

    /**
     * Print out a list of Student
     *
     * @param sl
     */
    private void printList(ArrayList<Student> sl) {
        System.out.println("ID                  Student Name        Semester            Course Name            Quantity");
        for (Student s : sl) {
            int count = 1;
            Course java = new Course("Java");
            for (Course c : s.getCl().getCourses().keySet()) {
                if (s.getCl().getCourses().get(c) != 0) {
                    if (count == 1) {
                        System.out.printf("%-20s%-20s%-20s%-20s   %d\n", s.getId(), s.getName(), Integer.toString(s.getSemester()), c.getName(), s.getCl().getCourses().get(c));
                        count++;
                    } else {
                        System.out.printf("                                                            %-20s   %d\n", c.getName(), s.getCl().getCourses().get(c));
                    }
                }

            }
        }
    }

    /**
     * Update a student with user's input
     *
     * @param old
     */
    private void updateStudent(Student old) {
        String name;
        int semester;
        CoursesList course = new CoursesList();
        name = input.getString("Name: ", "", "");
        semester = input.getInt("Semester: ", 1, 10);
        Student s = new Student(old.getId(), name, semester);
        course.setCourses(inputCourses());
        s.setCl(course);
        sl.getStudents().set(sl.getStudents().indexOf(old), s);
        System.out.println("Updated successfully");
    }

    /**
     * Delete a student
     *
     * @param old
     */
    private void delStudent(Student old) {
        while (true) {
            char choice = input.getString("Do you want to continue Y/N? ", "", "").charAt(0);
            if (choice == 'Y' || choice == 'y') {
                break;
            } else if (choice == 'N' || choice == 'n') {
                return;
            }
        }
        sl.getStudents().remove(old);
        System.out.println("Deleted Successfully");
    }

    /**
     * Create 2 students, if number of students >=3, ask user
     */
    void createStudent() {
        while (true) {
            if (sl.getStudents().size() >= 3) {
                while (true) {
                    char choice = input.getString("Do you want to continue Y/N? ", "", "").charAt(0);
                    if (choice == 'Y' || choice == 'y') {
                        break;
                    } else if (choice == 'N' || choice == 'n') {
                        return;
                    }
                }

            }
            for (int i = 0; i < 2; i++) {
                sl.getStudents().add(createNew());
            }
            break;
        }
    }

    /**
     * Find students with a part of the name, sort them by name then print out
     */
    void findNSort() {
        String name = input.getString("Name: ", "", "");
        ArrayList<Student> s = new ArrayList();
        s = findByName(name);
        if (s == null) {
            LOG.warning("No student available");
            return;
        } else if (s.isEmpty()) {
            LOG.warning("No student found");
            return;
        } else {
            Collections.sort(s, Comparator.comparing(Student::getName));
            printList(s);
        }
    }

    /**
     * Update and Delete Student
     */
    void upNDel() {
        String id = input.getString("ID: ", "ID must belike HE000000 or HS0000000", "^([Hh]){1}([ESes]){1}(\\d){6}$");
        Student s = findById(id);
        if (sl.getStudents().isEmpty()) {
            LOG.warning("No student available");
            return;
        } else if (s == null) {
            LOG.warning("Student not found");
            return;
        } else {
            while (true) {
                char choice = input.getString("Do you want to update (U) or delete (D) student or else: ", "", "").charAt(0);
                if (choice == 'U' || choice == 'u') {
                    updateStudent(s);
                    return;
                } else if (choice == 'D' || choice == 'd') {
                    delStudent(s);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    /**
     * Report all Students
     */
    void report() {
        printList(sl.getStudents());
    }
}
