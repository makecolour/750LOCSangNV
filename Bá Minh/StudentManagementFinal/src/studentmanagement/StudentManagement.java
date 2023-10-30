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

import java.util.ArrayList;
import java.util.Collections;

/**
 * The class contains method createStudent, update, remove, search, Student
 * information from Student table in database. All data will be normalized (trim
 * space) before update/add into database The method will throw an object of
 * <code>java.lang.Exception</code> class if there is any error occurring when
 * searching, adding, or updating data
 *
 * @author 
 */
public class StudentManagement {

    private static final ArrayList<Student> studentList = new ArrayList<>();

    /**
     * default constructor
     */
    public StudentManagement() {
    }

    /**
     * Create new students and add them to the list. The method allows the user
     * to input student attributes, including ID, student name, semester, and
     * courses. It continues to createStudent new students until the user
     * decides not to createStudent more or until the number of created students
     * reaches 10.
     */
    public void createStudent() {
        Student newStudent;
        String choice;

        //loop until user dont want to createStudent student and nos >10
        do {
            newStudent = new Student();
            //get student attribute            
            newStudent.setId(GetUserInput.getId("ID", studentList));
            newStudent.setStudentName(normalize(GetUserInput.getString("student name")));
            newStudent.setSemester(GetUserInput.getSemester());
            GetUserInput.getCourse(newStudent.getCourseList());
            //add new student 
            studentList.add(newStudent);
            System.err.println("A student has been created");
            //ask user to createStudent more
            if (studentList.size() > 2) {
                System.out.println("Do you want to continue (Y/N)?");
                choice = GetUserInput.confirm("Y", "N");
                if (choice.equalsIgnoreCase("N")) {
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
            MyLog.getLogger().warning("There is no student");
        } else {
            //get choice from user
            choice = GetUserInput.getInt("choice(1.Find | 2.Sort)", 1, 2);
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
        String choice;
        String inputId;
        if (studentList.isEmpty()) {
            MyLog.getLogger().warning("There is no student");
        } else {
            Student aStudent;
            do {
                inputId = GetUserInput.getString("student Id");
                aStudent = findId(inputId);
                if (aStudent != null) {
                    break;
                } else {
                    System.err.println("Id not found");
                }
            } while (true);
            System.out.println("Student found: " + aStudent.getStudentName());
            System.out.println("Do you want to update (U) or delete (D) student");
            //get choice from user
            choice = GetUserInput.confirm("U", "D");
            switch (choice) {
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
     * Generate a report of students and their enrolled courses. If the list of
     * students is empty, the method informs the user that there are no
     * students. Otherwise, it displays the student names along with the courses
     * they are enrolled in.
     */
    public void report() {
        if (studentList.isEmpty()) {
            MyLog.getLogger().warning("There is no student");
        } else {
            System.out.println("======================================================");
            System.out.println("       Student name      Course - Total course");
            //show student
            for (Student s : studentList) {
                System.out.println(String.format("%20s", s.getStudentName()) + toCourse(s.getCourseList()));
            }
        }
    }

    /**
     * Find a student in the list by ID.
     *
     * @param id The ID of the student to find. It is a
     * <code>java.lang.String</code> object.
     * @return The student object with the matching ID, or <code>null</code> if
     * the ID is not found in the list. It is a
     * <code>vn.co.fu.bean.Student</code> object.
     */
    private Student findId(String id) {
        for (Student aStudent : studentList) {
            //find id on list
            if (id.equalsIgnoreCase(aStudent.getId())) {
                return aStudent;
            }
        }
        return null;
    }

    /**
     * Search for students in the list by name or part of a name entered by the
     * user. The method first checks if the list of students is empty and
     * informs the user if there are no students. It then prompts the user to
     * input the name or part of the name to search for among the students. If
     * matching students are found, they are displayed on the screen. If no
     * matching students are found, the method logs a warning indicating that
     * the name was not found.
     */
    private void searchStudent() {
        String inputName;
        //check if list is empty
        if (studentList.isEmpty()) {
            MyLog.getLogger().warning("There is no Student");
        }
        inputName = GetUserInput.getString("name to search");
        //find Student base on name or part of name input from user
        ArrayList<Student> aStudentList = findByName(inputName);
        //if found employee print it to screen
        if (aStudentList != null) {
            System.out.println("Student found");
            show(aStudentList);
        } else {
            MyLog.getLogger().warning("name not found");
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
        String choose;
        do {
            System.out.println("Update student: " + aStudent.getStudentName());
            System.out.println("Attribute: 1.Student Name | 2.Semester | 3.Course");
            int choice = GetUserInput.getInt("Attribute", 1, 3);
            switch (choice) {
                case 1:
                    aStudent.setStudentName(GetUserInput.getString("new Student Name"));
                    break;
                case 2:
                    aStudent.setSemester(GetUserInput.getSemester());
                    break;
                case 3:
                    aStudent.setCourseList(GetUserInput.getCourse(aStudent.getCourseList()));
                    break;
            }
            System.out.println("Do you want to continue");
            choose = GetUserInput.confirm("Y", "N");
            if (choose.equalsIgnoreCase("n")) {
                System.err.println("This Student has been updated ");
                break;
            }
        } while (choose.equalsIgnoreCase("y"));
    }

    /**
     * Function to remove student
     *
     * @param aStudent The student to be removed
     */
    private void removeStudent(Student aStudent) {
        System.out.println("Do you want to delete student: " + aStudent.getStudentName());
        if (GetUserInput.confirm("Y", "N").equalsIgnoreCase("Y")) {
            studentList.remove(aStudent);
            System.out.println("This Student has been removed");
        }
    }

    /**
     * Find students by name or part of a name in a list of students. The method
     * checks for matches with the input name (case-insensitive) in the list of
     * student 's names. If matching students are found, they are added to a new
     * list and returned. If no matching students are found, the method returns
     * <code>null</code>.
     *
     * @param name The name or part of a name to search for among the students.
     * It is a <code>java.lang.String</code> object.
     * @return A list of students matching the search criteria, or
     * <code>null</code> if no matches are found. It is an
     * <code>java.util.ArrayList</code> of <code>vn.co.fu.bean.Student</code>
     * objects.
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
     * @param sList The list of students to display. It is an
     * <code>java.util.ArrayList</code> of <code>vn.co.fu.bean.Student</code>
     * objects.
     */
    private void show(ArrayList<Student> sList) {
        System.out.println("| ID |     Student Name     | semester |    Course Name ");
        for (Student e : sList) {
            System.out.print(e);
            String courseL = " ";
            for (int i = 0; i < e.getCourseList().length; i++) {
                if (e.getCourseList()[i].getCourseNumber() > 0) {
                    courseL += e.getCourseList()[i].getName();
                    if (i != e.getCourseList().length - 1) {
                        if (e.getCourseList()[i + 1] != null) {
                            courseL += ", ";
                        }
                    }
                }
            }
            System.out.println(courseL);
        }
    }

    /**
     * Convert an array of courses to a string representation.
     *
     * @param courseList The array of course objects to convert to a string. It
     * is a <code>vn.co.fu.bean.Course[]</code> array.
     * @return A string representation of the array of courses. It is a
     * <code>java.lang.String</code> object.
     */
    private String toCourse(Course[] courslist) {
        String courseL = "";
        for (int i = 0; i < courslist.length; i++) {
            if (courslist[i].getCourseNumber() > 0) {
                courseL += courslist[i].toString();
            }
        }
        return courseL;
    }

    /**
     * Check if a given ID already exists in the list of students.
     *
     * @param inputId The ID to check for duplication. It is a
     * <code>java.lang.String</code> object.
     * @return <code>true</code> if the ID is found in the list, indicating
     * duplication; <code>false</code> otherwise.
     */
    public static boolean checkDuplicateId(String inputId) {
        //lood to check duplicated id
        for (Student o : studentList) {
            //check if id input from user existed
            if (inputId.equalsIgnoreCase(o.getId())) {
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
     * @return
     */
    private String normalize(String studentName) {
        String[] Split = studentName.trim().split("[\\s]+");
        studentName = "";

        for (String a : Split) {
            studentName += a.substring(0, 1).toUpperCase() + a.substring(1).toLowerCase() + " ";
        }
        studentName = studentName.trim();
        return studentName;
    }
}
