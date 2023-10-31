/*							
 * Copyright(C) 2023,  FPT University.							
 * Task Management							
 * Manage information of task					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-10-22>       <1.0>          <Nguyen Thuong Quyen>     <Manage information of taks using List>							
 */
package j1.s.p0071;

import java.util.ArrayList;

/**
 * This class contains list of available tasks and save the last task ID
 *
 * @author quyen
 */
public class TaskList {

    ArrayList<Task> list = new ArrayList<>();
    int lastID; //ID of the newest task added

    /**
     * Constructor for task list and start its last ID
     */
    public TaskList() {
        if (list.isEmpty()) {
            lastID = 0;
        }
    }

}
