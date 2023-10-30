/*
 * Copyright(C)2023, Chu Hoang Giang
 * JAVA
 * Employee management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               GiangCH            First implemention
 */
package bank_p0071;


/**
 * This class provides methods for inputting data
 *
 * @author Chu Hoang Giang
 */
public class Task {
    private int id;
    private TypeOfTask taskTypeID;
    private String name;
    private String date;
    private double workStart;
    private double workEnd;
    private String assignee;
    private String reviewer;
    /**
     * defaut constucter
     */
    public Task() {
    }
    /**
     * 
     * @param id for id attribute
     * @param taskTypeID for taskTypeID attribute
     * @param name for name attribute
     * @param date for date attribute
     * @param from for from attribute
     * @param to for to attribute
     * @param assignee for assignee attribute
     * @param reviewer for reviewer attribute
     */
    public Task(int id, TypeOfTask taskTypeID, String name, String date, double from, double to, String assignee, String reviewer) {
        this.id = id;
        this.taskTypeID = taskTypeID;
        this.name = name;
        this.date = date;
        this.workStart = from;
        this.workEnd = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }
    /**
     * 
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * 
     * @return TaskTypeID
     */
    public TypeOfTask getTaskTypeID() {
        return taskTypeID;
    }
    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * @return date
     */
    public String getDate() {
        return date;
    }
    /**
     * 
     * @return workStart
     */
    public double getFrom() {
        return workStart;
    }
    /**
     * 
     * @return workEnd
     */
    public double getTo() {
        return workEnd;
    }
    /**
     * 
     * @return assignee
     */
    public String getAssignee() {
        return assignee;
    }
    /**
     * 
     * @return reviewer
     */
    public String getReviewer() {
        return reviewer;
    }
    /**
     * 
     * @param id to setID
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * 
     * @param taskTypeID to setID
     */
    public void setTaskTypeID(TypeOfTask taskTypeID) {
        this.taskTypeID = taskTypeID;
    }
    /**
     * 
     * @param name to set name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @param date to set date
     */
    public void setDate(String date) {
        this.date = date;
    }
    /**
     * 
     * @param from to set workStart
     */
    public void setFrom(double from) {
        this.workStart = from;
    }
    /**
     * 
     * @param to to set workEnd
     */
    public void setTo(double to) {
        this.workEnd = to;
    }
    /**
     * 
     * @param assignee to set assignee
     */
    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }
    /**
     * 
     * @param reviewer to setReviewer
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

   
    
}
