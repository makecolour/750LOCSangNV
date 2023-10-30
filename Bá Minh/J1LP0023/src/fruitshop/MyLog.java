/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Fruit shop management
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
*/
package fruitshop;

import java.util.logging.Logger;
/**
 * This class provide an method to log out an Exception
 * @author Dell
 */
public class MyLog {
    
    /**
     * Get a logger
     * @return a static logger instance
     */
     public static Logger getLogger() {
        return Logger.getLogger("MyLogger");
    }
}
