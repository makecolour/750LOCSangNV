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

/**
 * array list interaction
 * 
 * @author admin
 */
public class Task {

    private int id;
    private String taskTypeId;
    private String requirementName;
    private String date;
    private String planFrom;
    private String planTo;
    private String assign;
    private String reviewer;

    /**
     * task constructor
     */
    public Task() {
    }

    /**
     * the task default value
     */
    public Task(int id, String taskTypeId, String requirementName, String date, String planFrom, String planTo, String assign, String reviewer) {
        this.id = id;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    /**
     * Return the ID
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * change the id
     * @param id to be changed
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return the task type ID
     * @return task type ID
     */
    public String getTaskTypeId() {
        return taskTypeId;
    }

    /**
     * change the task type ID
     * @param taskTypeId to be changed
     */
    public void setTaskTypeId(String taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    /**
     * return the assignment name
     * @return requirementName
     */
    public String getRequirementName() {
        return requirementName;
    }

    /**
     * change the name
     * @param requirementName to be changed
     */
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    /**
     * return the assignment date
     * @return assignment date
     */
    public String getDate() {
        return date;
    }

    /**
     * change the assignment date
     * @param date to be changed
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * return the starting time
     * @return
     */
    public String getPlanFrom() {
        return planFrom;
    }

    /**
     * change the starting time
     * @param planFrom to be changed
     */
    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    /**
     * return the expected time
     * @return planTo
     */
    public String getPlanTo() {
        return planTo;
    }

    /**
     * change the starting time
     * @param planTo to be changed
     */
    public void setPlanTo(String planTo) {
        this.planTo = planTo;
    }

    /**
     * return the assigned
     * @return assigned
     */
    public String getAssign() {
        return assign;
    }

    /**
     * change the assigned
     * @param assign to be changed
     */
    public void setAssign(String assign) {
        this.assign = assign;
    }

    /**
     * return the reviewer
     * @return reviewer
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * change the reviewer
     * @param reviewer to be changed
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

}

