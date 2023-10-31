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

/**
 * This class represents of task object
 *
 * @author quyen
 */
public class Task {

    private int id;
    private TaskType type;
    private String requirementName;
    private String date;
    private double planFrom;
    private double planTo;
    private String assignee;
    private String reviewer;

    /**
     * Constructor
     */
    public Task() {
    }

    /**
     * Constructor
     *
     * @param id
     * @param type
     * @param requirementName
     * @param date
     * @param planFrom
     * @param planTo
     * @param assignee
     * @param reviewer
     */
    public Task(int id, TaskType type, String requirementName, String date, double planFrom, double planTo, String assignee, String reviewer) {
        this.id = id;
        this.type = type;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    /**
     * Getter
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Getter
     *
     * @return
     */
    public TaskType getType() {
        return type;
    }

    /**
     * Getter
     *
     * @return
     */
    public String getRequirementName() {
        return requirementName;
    }

    /**
     * Getter
     *
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Getter
     *
     * @return
     */
    public double getPlanFrom() {
        return planFrom;
    }

    /**
     * Getter
     *
     * @return
     */
    public double getPlanTo() {
        return planTo;
    }

    /**
     * Setter
     *
     * @return
     */
    public String getAssignee() {
        return assignee;
    }

    /**
     * Setter
     *
     * @return
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * Setter
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Setter
     *
     * @param type
     */
    public void setType(TaskType type) {
        this.type = type;
    }

    /**
     * Setter
     *
     * @param requirementName
     */
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    /**
     * Setter
     *
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Setter
     *
     * @param planFrom
     */
    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    /**
     * Setter
     *
     * @param planTo
     */
    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    /**
     * Setter
     *
     * @param assignee
     */
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    /**
     * Setter
     *
     * @param reviewer
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

}
