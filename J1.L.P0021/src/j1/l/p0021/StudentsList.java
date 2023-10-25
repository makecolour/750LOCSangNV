/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author quyen
 */
public class StudentsList {

    private ArrayList<Student> students = new ArrayList();

    /**
     *
     */
    public StudentsList() {
        Collections.sort(students, Comparator.comparing(Student::getId));
    }

    /**
     *
     * @return
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     *
     * @param students
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

}
