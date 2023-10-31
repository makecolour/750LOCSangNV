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
 * This class represent of tasktype attribute
 *
 * @author quyen
 */
public class TaskType {

    String typeName;

    /**
     * Constructor of tasktype
     */
    public TaskType() {
    }

    /**
     * Getter of Type name
     *
     * @return
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Let user choose task type
     */
    void setTaskType() {
        int type;
        Input input = new Input();
        System.out.println("========== Choose task type ==========");
        System.out.println("1. Code");
        System.out.println("2. Test");
        System.out.println("3. Design");
        System.out.println("4. Review");
        type = input.getInt("Task Type: ", 1, 4);
        switch (type) {
            case 1:
                typeName = "Code";
                break;
            case 2:
                typeName = "Test";
                break;
            case 3:
                typeName = "Design";
                break;
            case 4:
                typeName = "Review";
                break;
        }
    }
}
