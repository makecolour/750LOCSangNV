/*
 * Copyright(C) 2023,  <La Dieu Minh HE180677>.
 * <ProjectCode/Short Name of Application> : p0055
 *  <J1.s.p0055>
 *
 * Record of change:
 * DATE              Version             AUTHOR             DESCRIPTION
 * <2023-09-09>      <2.0>              <La Dieu Minh>      <Updated for clarity version>
 */
package Main;

import java.util.logging.Logger;

/**
 * Simple error logger
 *
 * @author La Dieu Minh
 */
public class ErrorLogger {

    /**
     * simple error logger
     *
     * @param className error in class
     * @param mess displayed message
     */
    public void Log(String className, String mess) {
        Logger.getLogger(className).warning(mess);
    }
}
