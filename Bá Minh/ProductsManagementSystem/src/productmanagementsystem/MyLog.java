/*				
 * Copyright(C) 2023,  <FPT University>.				
 * <Products management system> :				
 * <Program allow user manage employee information on screen>				
 *				
 * Record of change:				
 * DATE             Version     AUTHOR           DESCRIPTION				
 * <2023-09-20>      <8.2>     <MinhNBD>        <Write a program allow user to input and manage products information on screen.>				
 */
package productmanagementsystem;

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
