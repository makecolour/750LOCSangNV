/*
 * Copyright(C) 2023,  Montserrat.
 * BSA:
 *  Bubble Sort Algorithm
 *
 * Record of change:
 * DATE              Version             AUTHOR                       DESCRIPTION
 *2023/09/11       0.01 Alpha          Montserrat                     First Implement
 */
package bubble.sort.algorithm;
import java.util.*;

/**
 * Class xử lí thuật toán cho chương trình
 * @author quyen
 */
public class SortedArray {
    private List<Integer> list = new ArrayList<>();
    private boolean sorted = false;
    
    public SortedArray() {
    }
    
    /**
     * Generate n random number in the range of given number n, add them to list of integer
     * no return
     * It is a java.lang.Void obj.
     */
    void add(int range){
        Random rand = new Random();
        for (int count = 0; count < range; count++) {
            list.add(rand.nextInt(range));
        }
    }
    
    /**
     * Sort the ArrayList of Integer Ascending
     * no return
     * It is a java.lang.Void obj.
     */
    void sort() {
        int temp;
        for (int firstLoc = 0; firstLoc < list.size(); firstLoc++) {
            for (int secLoc = firstLoc + 1; secLoc < list.size(); secLoc++) {
                if (list.get(firstLoc) > list.get(secLoc)) {
                    temp = list.get (firstLoc);
                    list.set(firstLoc, list.get(secLoc));
                    list.set(secLoc, temp);
                }
            }
        }
        
    }
    
    /**
     * Display the ArrayList of Integer, based on the phase of $sorted variable
     * no return
     * It is a java.lang.Void obj.
     */
    void display()
    {
        if (sorted == false) {
            System.out.printf("Unsorted array: [");
        } else {
            System.out.printf("Sorted array: [");
        }
        for (int count = 0; count < list.size()-2; count++) {
            System.out.printf("%d, ", list.get(count));
        }
        System.out.printf("%d]\n", list.get(list.size()-1));
    }
    
    
}
