/*							
 * Copyright(C) 2023,  FPT University.							
 * Doctor management program. 							
 * Manage information of Doctor					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-27>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of Doctor using List>							
 */
package j1.s.p0055;

import java.util.ArrayList;

/**
 * This class's only use is to contain list of doctor
 *
 * @author quyen
 */
public class DoctorsList {

    private ArrayList<Doctor> list = new ArrayList();

    /**
     * Constructor
     */
    public DoctorsList() {
        list.add(new Doctor("DOC 1", "Nghia", "Orthopedics", 3));
        list.add(new Doctor("DOC 3", "Phuong", "Obstetrics", 2));
        list.add(new Doctor("DOC 4", "Lien", "orthodontic", 1));
    }

    /**
     * Getter of the list
     * @return
     */
    public ArrayList<Doctor> getList() {
        return list;
    }

    /**
     * Setter of the list
     * @param list
     */
    public void setList(ArrayList<Doctor> list) {
        this.list = list;
    }

}
