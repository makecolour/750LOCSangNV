/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Bubble sort algorithm
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
 */
package bubblesort;

import java.util.logging.Logger;

/**
 * This class provide a method to create a logger
 *
 * @author Nguyen Ba Duc MInh
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
