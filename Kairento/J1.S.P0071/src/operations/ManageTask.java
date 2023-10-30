/*							
 * Copyright(C) 2023,  FPT University.							
 * Task Management							
 * Manage information of taks					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage information of taks using List>							
 */
package operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import objects.Task;
import objects.TaskType;

/**
 * Manage information of the task
 * Allow user to add, remove or print task.
 * 
 * @author Nguyen Hoang Manh
 */
public class ManageTask {

    private final static Logger logger = Logger.getLogger(ManageTask.class.getName());
    private Validation validation = new Validation();

    /**
     * Get task type and save to the object
     */
    public void getTaskType(TaskType taskType) {

        ArrayList<String> TaskArray = new ArrayList<>(Arrays.asList("Code", "Test", "Design", "Learn"));

        printTasks(TaskArray);
        int choice = validation.inputInt("    Task type: ", 1, TaskArray.size());
        taskType.setId(choice);
        taskType.setDescription(TaskArray.get(choice-1));
    }

    /**
     * Print out the available task
     *
     * @param TaskArray task array. Is is a <code>java.util.ArrayList</code>
     * object
     */
    private void printTasks(ArrayList<String> TaskArray) {
        int option = 1;
        System.out.print("    AVAILABLE TASK: ");
        for (String TaskName : TaskArray) {
            System.out.print(option + "-" + TaskName + " ");
            option += 1;
        }
        System.out.println();
    }

    /**
     * Add task to task list
     *
     * @param taskList list of taskList. It is a <code>java.util.List</code>
     * object
     */
    public void addTask(List<Task> taskList) {
        int ID;
        if (taskList.isEmpty()) {
            ID = 1;
        } else {
            ID = taskList.get(taskList.size() - 1).getId() + 1;
        }

        String requirementName = normalize(validation.inputString("    Enter requirement name: ", "[A-Za-z0-9\\s]+"));

        TaskType taskType  = new TaskType();
        getTaskType(taskType);

        String date = validation.inputDate("    Enter Date: ");

        double planFrom = validation.inputDouble("    Enter plan From: ", 8, 17.5);

        double planTo = validation.inputDouble("    Enter plan To: ", planFrom + 0.5, 17.5);

        String assign = normalize(validation.inputString("    Enter assign: ", "[A-Za-z0-9\\s]+"));

        String reviewer = normalize(validation.inputString("    Enter reviewer: ", "[A-Za-z0-9\\s]+"));

        taskList.add(new Task(ID, taskType, requirementName, date, planFrom, planTo, assign, reviewer));

        System.out.println("Task added successfully!");
    }

    /**
     * Normalize for the sake of aesthetic Return the name of that has been
     * normalized
     *
     * @param fullname student's name. Is is a <code>java.lang.String</code>
     * object
     * @return normalized student's name. Is is a <code>java.lang.String</code>
     * object
     */
    private String normalize(String fullname) {
        String name = fullname.trim();
        name = name.replaceAll("[\\s\\s]+", " ");
        String[] arrayOfString = name.split("\\s+");

        for (int i = 0; i < arrayOfString.length; i++) {
            arrayOfString[i] = arrayOfString[i].substring(0, 1).toUpperCase() + arrayOfString[i].substring(1).toLowerCase();
        }
        fullname = String.join(" ", arrayOfString);

        return fullname;
    }

    /**
     * Remove task from task list
     *
     * @param taskList task list. It is a <code>java.util.List</code> object
     */
    public void removeTask(List<Task> taskList) {
        int ID = validation.inputInt("    Enter ID: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        for (Task task : taskList) {
            if (task.getId() == ID) {
                System.out.print("Task found. Are you sure to delete task (Y/N): ");
                boolean delete =  Validation.checkInputYN();
                if(delete) {
                    taskList.remove(task);
                    System.out.println("Delete successfully.");
                    return;
                } else {
                    System.out.println("Cancel delete");
                    return;
                }          
            }   
        }
        
        logger.warning("ID does not exist!");
    }

    /**
     * Display taskList in task list
     *
     * @param taskList task list. It is a <code>java.util.List</code> object
     */
    public void display(List<Task> taskList) {
        if (taskList.isEmpty()) {
            logger.warning("No task to display");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (Task task : taskList) {
            double time = task.getPlanTo() - task.getPlanFrom();
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    task.getId(),
                    task.getRequirementName(),
                    task.getTaskType().getDescription(),
                    task.getDate(),
                    time,
                    task.getAssign(),
                    task.getReviewer()
            );
        }
    }
}
