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
 * Type of task class. 
 * Including task id and task description.
 * @author Nguyen Hoang Manh
 */
public class TaskType {
    private int id;
    private String description;

    /**
     * Constructor without parameter.
     * Allow this class to be initialized
     */
    public TaskType(){    
    }
    
    /**
     * Constructor with parameter
     * @param id task id.It is an <code>java.lang.Integer</code> object
     * @param description task description. <code>java.lang.String</code> object
     */
    public TaskType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * Get id and return
     * @return id. 
     */
    public int getId() {
        return id;
    }

    /**
     * Get description of the task and return
     * @return task's description. It is <code>java.lang.String</code> object
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the task id to the given id.
     * @param id task id. It is <code>java.lang.Integer</code> object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set the task description to the given parameter
     * @param description task description. It is <code>java.lang.Integer</code> object
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}
