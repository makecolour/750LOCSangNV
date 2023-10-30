/*							
 * Copyright(C) 2023,  FPT University.							
 * Bubble Sort							
 * Sort array using Bubble Sort						
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Sorting elements in array using Bubble Sort>							
 */
package bubblesort;

import java.util.*;
import java.util.logging.Logger;
/**
 * The class is for end user/ tester to use the program without the needs to
 * look at method details
 *
 * @author Nguyen Hoang Manh
 */
public class BubbleSort {

    /**
     * Get array size from keyboard
     * Generate elements in array
     * Sort elements in array using bubble sort
     * Display both array before and after being sorted
     */
    public static void main(String[] args) {

        SortedArray sortedArray = new SortedArray();

        int arraySize = getSize();
        
        sortedArray.setSize(arraySize);

        sortedArray.generateElements();
        
        sortedArray.sort();
        
        sortedArray.display();

    }

    /**
     * Get number of elements in array from keyboard 
     * Return the number if condition (number must be positive) is met
     *
     * @return an integer. It is a  <code>java.lang.Integer </code> object.
     */
    private static int getSize() {
        Logger logger = Logger.getLogger(BubbleSort.class.getName());
        int n;

        while (true) {
            System.out.print("Input array size: ");
            Scanner scanner = new Scanner(System.in);
            try {
                n = scanner.nextInt();
                if (n > 0) {
                    return n;
                }
            } catch (InputMismatchException e) {
                logger.warning("Please input a positive integer");
                continue;
            }
            
        }
    }

}
