/**				
 * Copyright(C) 2023,  <FPT University>.				
 * <Student management system> :				
 * <Create a Java console program to manage students.>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <1.0>     <MinhLD>        <Write a program to manage information of student.>
 */
package Display;

import java.util.logging.Logger;

/**
 * This class provide a method to log out an Exception
 *
 * @author La Dieu Minh
 */
public class LoggerOut {

    /**
     * Get a logger to log out error
     *
     * @param className class name to be called
     * @param mess the message to display
     * @return logger to log error
     */
    public void Log(String className, String mess){
        Logger.getLogger(className).warning(mess);
    }
}
