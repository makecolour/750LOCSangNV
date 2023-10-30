/*
 * Copyright(C) 2005,  FPTU.
 * EM :
 *  Employee Manager
 *
 * Record of change:
 * DATE                       Version             AUTHOR                       DESCRIPTION
 * 2023-10-18                 1.5                 MinhLD                       <General fixes>
 */
package Display;
import java.util.logging.Logger;

/**
 * Error logger out for debugs
 *
 * @author MinhLD
 */
public class ErrorLogger {
    /**
     * Log out error
     *
     * @param className class name current in
     * @param mess the message that will be displayed
     */
    public void Log(String className, String mess){
        Logger.getLogger(className).warning(mess);
    }
}
