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
 *
 * @author quyen
 */
public class BubbleSortAlgorithm {
 /**
 * The class contains method find update, delete, insert staff information from
 * Staff table in database. In the update or insert method, all data will be normalized (trim space) before update/insert into database
 * The method wil throw an object  of <code>java.lang.Exception</code> class if there is any error occurring when finding, inserting, or updating data
 * <p>Bugs: Still have some issues related to search staff by address
 *
 * @author Montserrat
 */

    private static int getInput() {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        boolean check = false;
        do {
        System.out.println("Enter number of array: ");
        check = true;
        try {
            input = sc.nextInt();
        } catch(Exception e) {
            check = false;
        }
        if (input <= 0) {
            check = false;
        }
        }while (check == false);
        return input;
    }
    
    public static void main(String[] args) {
        SortedArray arr = new SortedArray();
        int input = getInput();
        arr.add(input);
        arr.display();
        arr.sort();
        arr.display();
    }
    
}
