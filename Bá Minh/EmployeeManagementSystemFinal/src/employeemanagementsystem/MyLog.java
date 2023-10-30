/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Employee management system> :				
 * <program allow user manage employee information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-14>      <8.2>     <MinhNBD>        <Write a program allow user manage employee information on screen.>				
 */
package employeemanagementsystem;

import java.util.logging.Logger;

/**
 * This class provide an method to log out an Exception
 *
 * @author Nguyen Ba Duc Minh
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
