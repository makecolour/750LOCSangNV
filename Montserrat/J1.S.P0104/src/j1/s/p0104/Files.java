/*							
 * Copyright(C) 2023,  FPT University.							
 * Find String in File							
 * Input text file directory, read and find string from text file.						
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-28>       <1.0>          <Nguyen Thuong Quyen>   <Input text file directory, read and find string from text file.>							
 */
package j1.s.p0104;

import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.util.logging.Logger;

/**
 * The class is for developer/programmer to write function for the program:
 * Check directory's path, search for file and words
 *
 * @author Nguyen Thuong Quyen
 */
public class Files {

    static final Logger log = Logger.getLogger(Files.class.getName());

    /**
     * Check if dir's path is valid
     *
     * @param dir
     * @return
     */
    boolean search(String dir) {
        File file;
        try {
            file = new File(dir);

            if (file.isFile() == false) {
                log.warning("File not found");
                return true;
            }
        } catch (Exception e) {
            log.warning("File not found");
            return true;
        }
        return false;
    }

    /**
     * Find and print strings that contain query in the file
     *
     * @param dir
     * @param query
     */
    void find(String dir, String query) {
        File file;
        int count = 0;
        try {
            file = new File(dir);
            Scanner input = new Scanner(file);
            System.out.println("Search results: ");
            while (input.hasNext()) {
                String word = input.next();
                if (word.contains(query)) {
                    System.out.println("    " + word);
                    count++;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            log.warning("File not found");
            return;
        }
        if (count == 0) {
            log.warning("    Not found");
        }
    }
}
