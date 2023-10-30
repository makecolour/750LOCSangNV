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

/**
 * This class represents Students' List
 *
 * @author quyen
 */
public class StudentsList {

    private ArrayList<Student> students = new ArrayList();

    /**
     * Constructor of List
     */
    public StudentsList() {
        Collections.sort(students, Comparator.comparing(Student::getId));
    }

    /**
     * Getter of List
     *
     * @return
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Setter of List
     *
     * @param students
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

}
