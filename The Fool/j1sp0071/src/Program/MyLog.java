/**
 * Copyright(C) 2023,  <La Dieu Minh HE180677>.
 * <ProjectCode/Short Name of Application> : p0071
 *  <Task Manager>
 *
 * Record of change:
 * DATE              Version             AUTHOR             DESCRIPTION
 * <2023-10-12>      <2.3>              <La Dieu Minh>      <Base version>
 */
package Program;

import java.util.logging.Logger;

/**
 * simple logger out for error checking
 * @author admin
 */
public class MyLog {

    /**
     * simple logger out to check for error
     * @param className the class name to display out
     * @param mess the message that will be displayed
     */
    public void Log(String className, String mess){
        Logger.getLogger(className).warning(mess);
    }
}
