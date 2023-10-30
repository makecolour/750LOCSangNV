/**
 * Copyright(C) 2023,  <La Dieu Minh HE180677>.
 * <ProjectCode/Short Name of Application> : p0071
 *  <Task Manager>
 *
 * Record of change:
 * DATE              Version             AUTHOR             DESCRIPTION
 * <2023-10-12>      <2.3>              <La Dieu Minh>      <Base version>
 */
package Manager;

import Program.Input;
import Program.MyLog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Task manager that will perform add, delete , find or print out tasks
 *
 * @author MinhLD
 */
public class TaskManager {

    private static final MyLog log = new MyLog();
    private static final Input input = new Input();
    private static final String className = Input.class.getName();

    /**
     * This method will create task with info from user
     *
     * @param lt the task list
     */
    public void addTask(ArrayList<Task> lt) {

        int id = 1;
        boolean idAdded = false;
        if (!lt.isEmpty()) {
            if (lt.size() >= 2) {
                //check if missing more than 1 item between 2 undelete value
                for (int i = 0; i < lt.size() - 1; i++)
                    if (lt.get(i + 1).getId() - lt.get(i).getId() > 1) {
                        id = lt.get(i).getId() + 1;
                        idAdded = true;
                    }
            }
            if (!idAdded) {
                id = lt.get(lt.size() - 1).getId() + 1;
            }
        }
        
        System.out.print("Enter Requirement Name: ");
        String requirementName = input.checkInputString("Enter Requirement Name: ");
        System.out.println("Types: 1. Code, 2. Test, 3. Design, 4. Review");
        System.out.print("Enter Task Type: ");
        String taskTypeId = input.checkInputTaskTypeId();
        System.out.print("Enter Date: ");
        String date = input.checkInputDate("Enter Date: ");
        System.out.print("Enter From: ");
        String planFrom = input.checkInputPlan(8, 17, "Enter From: ");
        System.out.print("Enter To: ");
        String planTo = input.checkInputPlan(Double.parseDouble(planFrom) + 0.5, 17.5, "Enter To: ");
        System.out.print("Enter Assignee: ");
        String assign = input.checkInputString("Enter Assignee: ");
        System.out.print("Enter Reviewer: ");
        String reviewer = input.checkInputString("Enter Reviewer: ");
        lt.add(new Task(id, taskTypeId, requirementName, date, planFrom, planTo, assign, reviewer));
        System.out.println("Add Task Success.");
    }

    /**
     * delete task using the id provided
     * 
     * @param lt the task array
     */
    public void deleteTask(ArrayList<Task> lt) {
        int findId = findTaskExist(lt);
        if (lt.isEmpty()) {
            log.Log(className, "List is empty, Please add atleast one");
            return;
        }
        while (findId == -1){
            findId = findTaskExist(lt);
        }
        
        if (findId != -1) {
            if (input.checkInputYesNo()){
                lt.remove(findId);
                log.Log(className, "Delete success.");
            }
            else {
                log.Log(className, "Delete Cancelled");
                return;
            }
        }
    }

    /**
     * check to see if task exist or not
     * 
     * @param lt the task array
     * @return the id or null depending on the result
     */
    public int findTaskExist(ArrayList<Task> lt) {
        System.out.print("Enter id: ");
        int id = input.checkInputInt("Enter id: ");
        for (int i = 0; i < lt.size(); i++) {
            if (lt.get(i).getId() == id) {
                return i;
            }
        }
        log.Log(className, "Not found.");
        return -1;
    }

    /**
     * print out the array list 
     * 
     * @param lt the array list
     */
    public void print(ArrayList<Task> lt) {
        if (lt.isEmpty()) {
            log.Log(className, "List empty.");
            return;
        }
        SortByID(lt);
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        for (int i = 0; i < lt.size(); i++) {
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                lt.get(i).getId(),
                lt.get(i).getRequirementName(),
                lt.get(i).getTaskTypeId(),
                lt.get(i).getDate(),
                Double.parseDouble(lt.get(i).getPlanTo()) - Double.parseDouble(lt.get(i).getPlanFrom()),
                lt.get(i).getAssign(),
                lt.get(i).getReviewer()
            );
        }
    }

    /**
     * Sort the array though ID
     * 
     * @param lt the array list to be sorted
     */
    public void SortByID(ArrayList<Task> lt) {
        lt.sort(
            new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getId()- o2.getId();
                }
            }
        );
    }
    
    private String checkInputString(){
        //Check for user input
        Scanner sc = new Scanner(System.in);
        
        //check if empty 
        while (true){
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Please re enter. Has to be non empty");
            } else {
                return result;
            }
        }
    }
}