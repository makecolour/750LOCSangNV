/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Student management system> :				
 * <Create a Java console program to manage students.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <AnhTD>        <Write a program to manage information of student.>				
 */
package management;

import java.util.ArrayList;
import java.util.logging.Logger;
import entity.Course;
import entity.Student;
import java.util.Collections;

/**
 * The class contains method createStudent, update, remove, search, Student
 * information from Student table in database. All data will be normalized (trim
 * space) before update/add into database The method will throw an object of
 * <code>java.lang.Exception</code> class if there is any error occurring when
 * searching, adding, or updating data
 *
 * @author Tran Duc Anh
 */
public class StudentList {

    private ArrayList<Student> list;
    private Logger logger = Logger.getLogger(StudentList.class.getName());

    /**
     * Initializes a new instance of the StudentList class, creating an empty
     * list of students. This constructor is used to instantiate a StudentList
     * object when you want to manage a list of students. To add students to the
     * list, use the addStudent method.
     */
    public StudentList() {
        list = new ArrayList<Student>();

    }

    /**
     * Initializes a new instance of the StudentList class, creating an empty
     * list of students. This constructor is used to instantiate a StudentList
     * object when you want to manage a list of students. To add students to the
     * list, use the addStudent method.
     */
    public StudentList(ArrayList<Student> list) {
        this.list = list;
    }

    /**
     * Create new students and add them to the list. The method allows the user
     * to input student attributes, including ID, student name, semester, and
     * courses. It continues to createStudent new students until the user
     * decides not to createStudent more or until the number of created students
     * reaches 10.
     */
    public void createStudent() {
        Student newStudent = new Student();
        String choice;
        int numberOfStudent = 1;
        String text = null;
        Course[] courslist = null;

        //loop until user dont want to createStudent student and nos >10
        do {
            newStudent = new Student();
            //get student attribute            
            newStudent.setId(GetUserInput.getId("ID", list));
            newStudent.setStudentName(GetUserInput.getString("student name", text));
            newStudent.setSemester(GetUserInput.getInt("semester", 1, 9));
            newStudent.setCourseList(GetUserInput.getCourse(courslist));
            //add new student 
            list.add(newStudent);
            System.err.println("A student has been created");
            numberOfStudent++;
            //ask user to createStudent more
            if (numberOfStudent > 2) {
                System.out.println("Do you want to continue (Y/N)?");
                choice = GetUserInput.confirmYesNo("", "Y", "N");
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
        int choice = 0;
        if (list.isEmpty()) {
            System.err.println("There is no student");
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
        String choice = null;
        if (list.isEmpty()) {
            System.err.println("There is no student");
        } else {
            System.out.println("Do you want to update (U) or delete (D) student");
            //get choice from user
            choice = GetUserInput.confirmYesNo(choice, "U", "D");
            switch (choice) {
                case "u":
                    updateStudent();//call method updateStudent
                    break;
                case "d":
                    removeStudent();//call method removeStudent
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
        if (list.isEmpty()) {
            System.err.println("There is no student");
        } else {
            System.out.println("======================================================");
            System.out.println("       Student name      Course - Total course");
            //show student
            for (Student s : list) {
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
        for (Student aStudent : list) {
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
    public void searchStudent() {
        String inputName = null;
        //check if list is empty
        if (list.isEmpty()) {
            System.err.println("There is no Student");
        }
        inputName = GetUserInput.getString("name to search", inputName);
        //find Student base on name or part of name input from user
        ArrayList<Student> aStudentList = findByName(inputName);
        //if found employee print it to screen
        if (aStudentList != null) {
            System.out.println("Student found");
            show(aStudentList);
        } else {
            logger.warning("name not found");
        }

    }

    /**
     * Sort the list of students alphabetically by student name in descending
     * order (case-insensitive). The method displays the student list before and
     * after sorting.
     */
    private void sortStudent() {
        System.out.println("Student list before sorting");
        show(list);
        Collections.sort(list);
        System.out.println("Student list after sorting");
        show(list);
    }

    /**
     * Update a student's attributes based on the user's input, including ID,
     * student name, semester, and courses. The method first checks if the list
     * of students is empty and informs the user if there are no students. It
     * then prompts the user to input the ID of the student to be updated. If
     * the student is found, the method allows the user to choose which
     * attribute to update (ID, student name, semester, or courses). After
     * updating an attribute, the user can choose to continue updating or stop.
     * If the user chooses to stop, the method informs the user that the student
     * has been updated.
     */
    private void updateStudent() {
        Student aStudent = new Student();
        String inputId = null;
        String choose = null;
        String text = null;
        //loop until user stop
        do {
            if (list.isEmpty()) {
                System.err.println("There is no Student");
                break;
            }
            //find Student base on Id input from user
            inputId = GetUserInput.getString("Id to update", inputId);
            aStudent = findId(inputId);
            //choose Student'attribute to update
            if (aStudent != null) {
                do {
                    System.out.println("Attribute: 1.ID | 2.Student Name | 3.Semester | 4.Course");
                    int choice = GetUserInput.getInt("Attribute", 1, 4);
                    //update student's attribute
                    switch (choice) {
                        case 1:
                            aStudent.setId(GetUserInput.getId("new Id", list));
                            break;
                        case 2:
                            aStudent.setStudentName(GetUserInput.getString("new Student Name", text));
                            break;
                        case 3:
                            aStudent.setSemester(GetUserInput.getInt("new semester", 1, 9));
                            break;
                        case 4:
                            Course[] newCourseList = null;
                            aStudent.setCourseList(GetUserInput.getCourse(newCourseList));
                            break;
                    }
                    //allow user to continue/stop updating Student
                    System.out.println("Do you want to continue");
                    do {
                        //ask user to continue update or delete
                        choose = GetUserInput.getString("Y/N", choose);
                        if (choose.equalsIgnoreCase("Y") || choose.equalsIgnoreCase("N")) {
                            break;
                        }
                    } while (true);
                    if (choose.equalsIgnoreCase("n")) {
                        System.err.println("This Student has been updated ");
                        break;
                    }
                } while (choose.equalsIgnoreCase("y"));
                break;
            } else {
                System.err.println("Id not found");
            }
        } while (true);
    }

    /**
     * Remove a student from the list based on the user's input of the student's
     * ID. The method first checks if the list of students is empty and informs
     * the user if there are no students. It then prompts the user to input the
     * ID of the student to be removed. If the student is found, the method asks
     * for confirmation before removing the student. If confirmed, the student
     * is removed from the list; otherwise, the removal process is stopped.
     */
    private void removeStudent() {
        String inputId = null;
        String confirm = null;
        Student aStudent = new Student();
        //find Student base on Id input from user
        do {
            //check empty database
            if (list.isEmpty()) {
                System.err.println("There is no Student");
                break;
            }
            inputId = GetUserInput.getString("Id to remove", inputId);
            aStudent = findId(inputId);
            if (aStudent != null) {
                //ask to student to continue or not
                if (GetUserInput.confirmYesNo(confirm, "Y", "N").equalsIgnoreCase("Y")) {
                    list.remove(aStudent);
                    System.out.println("This Student has been removed");
                    break;
                } else {
                    break;
                }
            } else {
                System.err.println("Id not found");
            }
        } while (true);

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
        ArrayList<Student> cList = new ArrayList<Student>();
        for (Student aStudent : list) {
            //check if input name existed or not
            if (aStudent.getStudentName().toLowerCase().contains(name.toLowerCase()) || aStudent.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                cList.add(aStudent);
            }
        }
        //check empty list
        if (cList.isEmpty() == true) {
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
                if (e.getCourseList()[i] != null) {
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
            if (courslist[i] != null) {
                courseL += courslist[i].toString();
            }
        }
        return courseL;
    }
}
