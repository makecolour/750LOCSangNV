/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0021;

/**
 *
 * @author quyen
 */
public class Student {

    private String id;
    private String name;
    private int semester;
    private CoursesList cl = new CoursesList();

    /**
     *
     */
    public Student() {
    }

    /**
     *
     * @param id
     * @param name
     * @param semester
     */
    public Student(String id, String name, int semester) {
        this.id = id;
        this.name = name;
        this.semester = semester;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public int getSemester() {
        return semester;
    }

    /**
     *
     * @return
     */
    public CoursesList getCl() {
        return cl;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param semester
     */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
     *
     * @param cl
     */
    public void setCl(CoursesList cl) {
        this.cl = cl;
    }

}
