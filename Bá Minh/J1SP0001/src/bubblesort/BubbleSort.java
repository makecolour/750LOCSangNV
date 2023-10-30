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

import java.util.Arrays;
import java.util.Random;

/**
 * This class has methods to createArray, sort the array and printResultToScreen
 *
 * @author Nguyen Ba DUc Minh
 */
public class BubbleSort {

    private int[] unsortedArray;
    private int[] sortedArray;

    /**
     * Default constructor
     */
    public BubbleSort() {
    }

    /**
     * parameter constructor
     *
     * @param size size to set
     */
    public BubbleSort(int size) {
        unsortedArray = this.generateElements(size);
        sortedArray = new int[unsortedArray.length];
        System.arraycopy(unsortedArray, 0, sortedArray, 0, sortedArray.length);
    }

    /**
     * Create an integer array
     *
     * @param size The size of an array to be created
     * @return an integer array
     */
    private int[] generateElements(int size) {
        int[] array = new int[size];
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(size);
        }
        return array;
    }

    /**
     * Print the final result to screen
     */
    public void printResultToScreen() {
        System.out.print("Unsorted array: " + Arrays.toString(unsortedArray));
        System.out.print("\nSorted array: " + Arrays.toString(sortedArray));
    }

    /**
     * Sort an integer array by using bubble sort method
     */
    public void sort() {
        int temp;
        for (int i = 0; i < sortedArray.length - 1; i++) {
            for (int y = sortedArray.length - 1; y > i; y--) {
                if (sortedArray[y] < sortedArray[y - 1]) {
                    temp = sortedArray[y];
                    sortedArray[y] = sortedArray[y - 1];
                    sortedArray[y - 1] = temp;
                }
            }
        }
    }
}
