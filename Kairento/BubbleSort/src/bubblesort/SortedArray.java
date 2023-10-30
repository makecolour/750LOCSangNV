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

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * The class is for developer/programmer to write function for the program:
 * Bubble Sort Add, sort and display array
 *
 * @author Nguyen Hoang Manh
 */
public class SortedArray {

    private int size;
    private int[] array;
    private int[] sortedArray;

    //Initialize array size value
    public SortedArray(int size) {
        this.size = size;
    }
    
    //This method allow this class to be called from other class
    public SortedArray() {
        super();
    }

    /**
     * Set value for variable size
     * Set size for both array and unsorted array
     * 
     */
    public void setSize(int size) {
        this.size = size;
        this.array = new int[size];
        this.sortedArray = new int[size];
    }
    
    /**
     * Generate random value for each element in the array from 1 to the size of
     * array Save the generated elements to both array and sortedArray for later
     * uses.
     *
     */
    public void generateElements() {
        int min = 0;
        for (int i = 0; i < size; i++) {
            //generate random number between min and given number
            sortedArray[i] = array[i] = (int) (min + Math.random() * ((array.length - min) + 1)); 
        }
    }

    /**
     * Sort the array using bubble sort Result contains an array of elements
     * that have been all sorted.
     */
    public void sort() {
        for (int i = 0; i < size -1; i++) {
            for (int j = size - 1; j > i ; j--) {
                if (sortedArray[j - 1] > sortedArray[j]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j - 1];
                    sortedArray[j - 1] = temp;
                }
            }
        }
    }

    /**
     * Display both unsorted and sorted array
     *
     */
    public void display() {

        System.out.print("Unsorted array: ");
        System.out.println(Arrays.toString(array));

        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(sortedArray));

    }

}
