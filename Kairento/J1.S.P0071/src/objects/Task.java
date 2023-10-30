/*							
 * Copyright(C) 2023,  FPT University.							
 * Task Management							
 * Manage information of taks					
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Manage information of taks using List>							
 */
package objects;

/**
 * This class contains all the information of a task
 *
 * @author Nguyen Hoang Manh
 */
public class Task {

    private int id;
    private TaskType taskType;
    private String requirementName;
    private String date;
    private double planFrom;
    private double planTo;
    private String assign;
    private String reviewer;

    /**
     * Constructor with parameter
     *
     * @param id task id, auto generated when add a task. It is a
     * <code>java.lang.Integer</code> object
     * @param taskType taskType. <code>java.lang.Object</code> object
     * @param requirementName requirement name . It is a
     * <code>java.lang.String</code> object.
     * @param date task date. It is a <code>java.lang.String</code> object.
     * @param planFrom plan from. It is a <code>java.lang.Double</code> object
     * @param planTo plan to. It is a <code>java.lang.Double</code> object
     * @param assign task assignee. It is a <code>java.lang.String</code> object
     * @param reviewer task reviewer. It is a <code>java.lang.String</code>
     * object
     */
    public Task(int id, TaskType taskType, String requirementName, String date, double planFrom, double planTo, String assign, String reviewer) {
        this.id = id;
        this.taskType = taskType;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    /**
     * Get task id and return
     *
     * @return the id. It is a <code>java.lang.Integer</code> object
     */
    public int getId() {
        return id;
    }

    /**
     * Set id to the given parameter
     *
     * @param id task id. It is a <code>java.lang.Integer</code> object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get task type and return
     *
     * @return task type. It is a <code>java.lang.String</code> object
     */
    public TaskType getTaskType() {
        return taskType;
    }

    /**
     * Set set task type to given parameter
     *
     * @param taskTypeId task type. It is a <code>java.String</code> object
     */
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    /**
     * Get requirement name and return
     *
     * @return requirement name. It is a <code>java.String</code> object
     */
    public String getRequirementName() {
        return requirementName;
    }

    /**
     * Set requirement to the given parameter
     *
     * @param requirementName requirement name. It is a <code>java.String</code>
     * object
     */
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    /**
     * Get date and return
     *
     * @return date. It is a <code>java.String</code> object
     */
    public String getDate() {
        return date;
    }

    /**
     * Set date to the given parameter
     *
     * @param date task date. It is a <code>java.String</code> object
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get plan from and return
     *
     * @return plan from. It is a <code>java.Double</code> object
     */
    public double getPlanFrom() {
        return planFrom;
    }

    /**
     * Set plan from to the given parameter
     *
     * @param planFrom plan from. It is a <code>java.Double</code> object
     */
    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    /**
     * Get plant to and return
     *
     * @return plan to. It is a <code>java.Double</code> object
     */
    public double getPlanTo() {
        return planTo;
    }

    /**
     * Set plan to to the given parameter
     *
     * @param planTo plan to. It is a <code>java.Double</code> object
     */
    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    /**
     * Get assignee and return.
     *
     * @return assignee. It is a <code>java.String</code> object
     */
    public String getAssign() {
        return assign;
    }

    /**
     * Set assignee to the given parameter.
     *
     * @param assign assignee. It is a <code>java.String</code> object
     */
    public void setAssign(String assign) {
        this.assign = assign;
    }

    /**
     * Get reviewer and return
     *
     * @return reviewer. It is a <code>java.String</code> object
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * Set reviewer to the given parameter
     *
     * @param reviewer reviewer. It is a <code>java.String</code> object
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

}
