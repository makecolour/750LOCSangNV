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
import java.util.Collections;

/**
 * This class manage the program
 *
 * @author Chu Hoang Giang
 */
public class Manager {

    private final ArrayList<Semester> semesterList = new ArrayList<>();
    private final ArrayList<String> courseList = new ArrayList<>();
    private final ArrayList<Student> stuList = new ArrayList<>();
    private final Scan sc = new Scan();

    /**
     * Add new stu
     */
    public void addNewStu() {
        setSemester();
        setCouseName();
        int count = 0;
        do {
            System.out.println("\nStudent " + (count + 1));
            String id = addStuID();
            String name = normalize(sc.nextLine("Enter name: "));
            ArrayList<Course> stuCourse = new ArrayList<>();
            stuCourse = getCourse(stuCourse);
            int semesterChoice = sc.checkLimit(1, semesterList.size(), "Enter semester(1.Spriring, 2.Summer, 3.Fall): ");
            Semester semester = semesterList.get(semesterChoice - 1);
            stuList.add(new Student(id, name, stuCourse, semester));
            count++;
            System.err.println("Add successfully");
        } while (sc.checkApprove("Do you want to add more student? "));
    }

    /**
     * Help stu choose course
     *
     * @param temp to store Course
     * @return
     */
    public ArrayList<Course> getCourse(ArrayList<Course> temp) {
        int round = 0;
        do {
            int count = 0;
            int courseChoice = sc.checkLimit(1, courseList.size(), "Enter course name (1.Java, 2.Net, 3.C/C++): ") - 1;
            Course stuCourse = new Course(courseList.get(courseChoice), count + 1);
            if (round == 0) {
                temp.add(stuCourse);
            } else {

                if (checkDuplicate(temp, courseList.get(courseChoice))) {
                    for (int j = 0; j < temp.size(); j++) {
                        if (temp.get(j).getName().equalsIgnoreCase(courseList.get(courseChoice))) {
                            temp.get(j).setQuantity(temp.get(j).getQuantity() + count + 1);
                            break;
                        }
                    }
                } else {
                    temp.add(stuCourse);
                }
            }
            round++;
        } while (sc.checkApprove("Do you want to continue choice? "));
        for (Course data : temp) {
            System.out.printf("%-20s%-20s%n", "Course name", "Quantity");
            System.out.printf("%-20s%-20s%n", data.getName(), data.getQuantity());
        }
        return temp;
    }

    /**
     * to check duplicate course name
     *
     * @param temp to store ArrayList
     * @param courseName to check duplicate
     * @return
     */
    public boolean checkDuplicate(ArrayList<Course> temp, String courseName) {
        for (int j = 0; j < temp.size(); j++) {
            if (temp.get(j).getName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find student name and sort
     */
    public void findAndSort() {
        ArrayList<Student> stuNameList = new ArrayList<>();
        String name = getName();
        for (int i = 0; i < stuList.size(); i++) {
            if (stuList.get(i).getName().toLowerCase().contains(name)) {
                stuNameList.add(stuList.get(i));
            }
        }
        Collections.sort(stuNameList);
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "ID", "Student Name", "Semester", "Course Name", "Quantity");
        for (int i = 0; i < stuNameList.size(); i++) {
            if (stuNameList.get(i).getCourseName().size() == 1) {
                System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", stuNameList.get(i).getId(), stuNameList.get(i).getName(), stuNameList.get(i).getSemester().getSemester(), stuNameList.get(i).getCourseName().get(0).getName(), stuNameList.get(i).getCourseName().get(0).getQuantity());
            } else {
                System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", stuNameList.get(i).getId(), stuNameList.get(i).getName(), stuNameList.get(i).getSemester().getSemester(), stuNameList.get(i).getCourseName().get(0).getName(), stuNameList.get(i).getCourseName().get(0).getQuantity());
                stuNameList.get(i).getCourseDetail();
            }
        }
    }

    /**
     * get student name
     *
     * @return
     */
    public String getName() {
        String name;
        do {
            name = sc.nextLine("Enter name: ").toLowerCase();
            if (findStudentByName(name) < 0) {
                System.out.println("Not found student name, please enter again! ");
            }
        } while (findStudentByName(name) < 0);
        return name.toLowerCase();
    }

    /**
     * find student by name
     *
     * @param name to find in arraylist
     * @return
     */
    public int findStudentByName(String name) {
        for (int i = 0; i < stuList.size(); i++) {
            if (stuList.get(i).getName().toLowerCase().contains(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Update stu or delete stu
     */
    public void updateOrDelete() {
        String choice = getUserChoice();
        String id = getStuID();
        int index = findStudentByID(id);
        if (choice.equalsIgnoreCase("d")) {
            if (!sc.checkApprove("Do you want to delete? ")) {
                return;
            }
            stuList.remove(index);
            System.err.println("Delete successfully");
        } else {
            stuList.get(index).setName(normalize(sc.nextLine("Enter name: ")));
            stuList.get(index).setCourseName(getCourse(new ArrayList<>()));
            stuList.get(index).setSemester(semesterList.get(sc.checkLimit(1, semesterList.size(), "Enter semester(1.Spriring, 2.Summer, 3.Fall): ") - 1));
            System.err.println("Update successfully");
        }

    }

    /**
     * get user choice between update or delete
     *
     * @return string value
     */
    public String getUserChoice() {
        String data = "null";
        do {
            data = sc.nextLine("Do you want to update (U) or delete (D) student.\n" + "Enter your choice: ").toLowerCase();
            if (data.equalsIgnoreCase("u")) {
                return data;
            } else if (data.equalsIgnoreCase("d")) {
                return data;
            } else {
                System.out.println("Enter 'u' or 'd'");
            }
        } while (!data.equalsIgnoreCase("d") || !data.equalsIgnoreCase("u"));
        return data;
    }

    /**
     * add semester to store in array list
     */
    public void setSemester() {
        String[] temp = new String[]{"Spriring", " Summer", "Fall"};
        for (int i = 0; i < temp.length; i++) {
            semesterList.add(new Semester(temp[i]));
        }
    }

    /**
     * add course to store in array list
     */
    public void setCouseName() {
        String[] temp = new String[]{"Java", " .Net", "C/C++"};
        for (int i = 0; i < temp.length; i++) {
            courseList.add((temp[i]));
        }
    }

    /**
     * add student id
     *
     * @return String value
     */
    public String addStuID() {
        String id;
        do {
            id = sc.nextLine("Enter id: ").toLowerCase();
            if (findStudentByID(id) >= 0) {
                System.out.println("Student id is duplicate! ");
            }
            if (!id.matches("^he\\d{6}$")) {  
                System.out.println("Wrong format, please enter HExxxxxx!");
            }
            if (id.length() < 8) {
                System.out.println("Not long enought, please enter HE and 6 integer number!");
            }
        } while (findStudentByID(id) >= 0 || !id.matches("^he\\d{6}$") || id.length() < 8);
        return id;
    }

    /**
     * get student id
     *
     * @return String value
     */
    public String getStuID() {
        String id;
        do {
            id = sc.nextLine("Enter id: ");
            if (findStudentByID(id) < 0) {
                System.out.println("Student id not exist! ");
            }
        } while (findStudentByID(id) < 0);
        return id;
    }

    /**
     * find student by id
     *
     * @param id to find
     * @return String
     */
    public int findStudentByID(String id) {
        for (int i = 0; i < stuList.size(); i++) {
            if (stuList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Normalize String value
     *
     * @param inform to normalize
     * @return String value
     */
    public String normalize(String inform) {
        String[] temp = inform.split(" ");
        String result = "";
        for (String data : temp) {
            result += data.substring(0, 1).toUpperCase() + data.substring(1).toLowerCase();
        }
        return result;
    }

    /**
     * Print data from array list
     */
    public void Report() {
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", "ID", "Student Name", "Semester", "Course Name", "Quantity");
        for (int i = 0; i < stuList.size(); i++) {
            if (stuList.get(i).getCourseName().size() == 1) {
                System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", stuList.get(i).getId(), stuList.get(i).getName(), stuList.get(i).getSemester().getSemester(), stuList.get(i).getCourseName().get(0).getName(), stuList.get(i).getCourseName().get(0).getQuantity());
            } else {
                System.out.printf("%-10s%-20s%-20s%-20s%-20s%n", stuList.get(i).getId(), stuList.get(i).getName(), stuList.get(i).getSemester().getSemester(), stuList.get(i).getCourseName().get(0).getName(), stuList.get(i).getCourseName().get(0).getQuantity());
                stuList.get(i).getCourseDetail();
            }
        }
    }
}
