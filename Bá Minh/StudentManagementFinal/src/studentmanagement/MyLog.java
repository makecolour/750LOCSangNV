/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Student management system> :				
 * <Create a Java console program to manage students.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <>        <Write a program to manage information of student.>				
 */
package studentmanagement;

import java.util.logging.Logger;

/**
 * This class provide an method to log out an Exception
 *
 * @author 
 */
public class MyLog {

    /**
     * Get a logger
     *
     * @return a static logger instance
     */
    public static Logger getLogger() {
        return Logger.getLogger("MyLogger");
    }
}
