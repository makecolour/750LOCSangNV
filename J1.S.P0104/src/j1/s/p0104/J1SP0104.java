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

import java.io.File;
import java.util.Scanner;

/**
 * The class is for end user/tester to use the program without the needs to look
 * at method details
 *
 * @author Nguyen Thuong Quyen
 */
public class J1SP0104 {

    /**
     * Get directory and query from keyboard Check directory's path, Display
     * words that contain query
     *
     * @param args
     */
    public static void main(String[] args) {
        String dir;
        String query;
        Scanner sc = new Scanner(System.in);
        Files f = new Files();
        do {
            System.out.print("Please enter directory of file:  ");
            dir = sc.nextLine();
            System.out.println(dir);
        } while (dir.isEmpty() || f.search(dir));
        do {
            System.out.print("Please enter string to search: ");
            query = sc.nextLine();
        } while (query.isEmpty());
        f.find(dir, query);
    }
}
