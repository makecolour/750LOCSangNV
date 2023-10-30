/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Matrices calculation
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
 */
package calculatingmatrices;

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
