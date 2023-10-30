/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Bubble sort algorithm
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
 */
package bubblesort;

import java.util.Scanner;

/**
 * This class contains the main method for implementing the bubble sort
 * algorithm project
 *
 * @author Nguyen Ba Duc Minh
 */
public class BubbleSortMain {

    /**
     * Ask user for inputting array size and implement the bubble sort
     *
     * @param args
     */
    public static void main(String[] args) {
        int arraySize;
        arraySize = getArraySize("Enter number of array: ", "You must enter a positive decimal number.");
        BubbleSort bubbleSort = new BubbleSort(arraySize);
        bubbleSort.sort();
        bubbleSort.printResultToScreen();
    }

    /**
     * Validating user input
     *
     * @param mess The message ask user for inputting data
     * @param warn The warning if user input is invalid
     * @return an integer
     */
    private static int getArraySize(String mess, String warn) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(mess);
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number > 0) {
                    return number;
                } else {
                    MyLog.getLogger().warning(warn);
                }
            } catch (Exception e) {
                MyLog.getLogger().warning(warn);
            }
        }
    }
}
