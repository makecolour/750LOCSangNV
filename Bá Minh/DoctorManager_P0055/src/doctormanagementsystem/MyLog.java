/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Doctor management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0                           First implemention
 */
package doctormanagementsystem;

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
