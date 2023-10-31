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
import java.util.logging.Logger;

/**
 * This class is the most important one, perform all main features of the
 * program
 *
 * @author quyen
 */
public class TaskManager {

    private static final Logger LOG = Logger.getLogger(TaskManager.class.getName());

    TaskList tl = new TaskList();
    private final Input input = new Input();

    /**
     * Add new Task, auto generate task ID
     */
    void addTask() {
        int id = tl.lastID + 1;
        TaskType type = new TaskType();
        String requirementName = input.getString("Requirement Name: ");
        type.setTaskType();
        String date = input.getDate("Date: ");
        double planFrom = 0;
        double planTo = 0;
        while (true) {
            planFrom = input.getDouble("From: ", 8, 17.5);
            planTo = input.getDouble("To: ", 8, 17.5);
            if (planTo > planFrom) {
                break;
            }
            LOG.warning("From must comes before to");
        }
        String assignee = input.getString("Assignee: ");
        String reviewer = input.getString("Reviewer: ");

        tl.list.add(new Task(id, type, requirementName, date, planFrom, planTo, assignee, reviewer));
        tl.lastID++;
    }

    /**
     * This class was first designed to add new task in the deleted task's id,
     * until i realise that's bullshit
     */
//    int handleID()
//    {
//        if(tl.list.isEmpty())
//        {
//            return 1;
//        }
//        else
//        {
//            for(int i = 0; i<tl.list.size(); i++)
//            {
//                if(tl.list.get(i).getId()>tl.list.)
//            }
//        }
//    }
    /**
     * Find and Delete Tasks
     */
    void deleteTask() {
        if (tl.list.isEmpty()) {
            LOG.warning("Empty task list");
            return;
        }
        int id;
        Task delTask;
        String choice;
        System.out.println("----------DelTask----------");
        id = input.getInt("ID: ", 1, tl.lastID);
        delTask = findByID(id);
        if (delTask == null) {
            LOG.warning("Task not found");
            return;
        } else {
            while (true) {
                choice = input.getString("Confirm deletion " + id + " Y/N: ");
                if (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y') {
                    tl.list.remove(delTask);
                    System.out.println("Successful");
                    return;
                } else if (choice.charAt(0) == 'n' || choice.charAt(0) == 'N') {
                    return;
                }
            }
        }
    }

    /**
     * Find Task by its ID
     *
     * @param id
     * @return null or Task
     */
    private Task findByID(int id) {
        for (Task t : tl.list) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    /**
     * Display all available tasks
     */
    void displayTask() {
        if (tl.list.isEmpty()) {
            LOG.warning("No task found");
            return;
        }
        System.out.println("----------------------------------------------------Task----------------------------------------------------");
        System.out.println("ID              NameTask                Type                Time                Asignee             Reviewer");
        for (Task t : tl.list) {
            String time = Double.toString(t.getPlanTo() - t.getPlanFrom());
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", Integer.toString(t.getId()), t.getRequirementName(), t.getType().getTypeName(), t.getDate(), time, t.getAssignee(), t.getReviewer());
        }
    }
}
