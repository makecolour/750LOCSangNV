/*
 * Copyright(C) 2005,  <FPTU>.
 * <0023> :
 *  <Fruit Shop Management System>
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * <26/10/2023>                <1>              <la Minh>                       <base>
 */
package Display;

import java.util.logging.Logger;

/**
 * A simple error logger for debugging
 *
 * @author La Minh
 */
public class ErrorLog {
    
    /**
     * simple error logger
     * @param className the class name used to check for error
     * @param mess the displayed message
     */
    public void Log(String className, String mess){
        Logger.getLogger(className).warning(mess);
    }
}
