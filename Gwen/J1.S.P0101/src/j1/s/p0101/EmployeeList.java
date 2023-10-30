/*							
 * Copyright(C) 2023,  FPT University.							
 * Employee management system							
 * Manage information of Employees					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-23>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of employee using List>							
 */
package j1.s.p0101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class included List of Employee 
 * @author quyen
 */
public class EmployeeList {

    private ArrayList<Employee> list = new ArrayList();

    public ArrayList<Employee> getList() {
        return list;
    }

    public void setList(ArrayList<Employee> list) {
        this.list = list;
    }

    public EmployeeList() {
        //Test
        list.add(new Employee("1", "Thuong Quyen", "Nguyen", "0335610213", "quyennguyen083004@gmail.com", "Ha Dong, Ha Noi", "30-08-2004", true, 10000, "FPT Group"));
        list.add(new Employee("2", "Thien Nga", "Nguyen", "0335390209", "nganthe186502@fpt.edu.vn", "Bac Giang", "12-11-2004", false, 1, "FPT University"));
        list.add(new Employee("3", "Hoang Manh", "Nguyen", "03388789965", "hoangmanhnguyen204@gmail.com  ", "Ha Dong, Ha Noi", "09-10-2004", true, 100, "FPT University"));
        Collections.sort(list, Comparator.comparing(Employee::getId));
    }

}
