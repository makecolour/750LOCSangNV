/*							
 * Copyright(C) 2023,  FPT University.							
 * Matrices Caculation							
 * Add, substract and mutiply two matrices				
 *							
 * Record of change:							
 * DATE              Version             AUTHOR                       DESCRIPTION							
 * <2023-09-11>       <1.0>          <Nguyen Hoang Manh>     <Add, substract and mutiply two matrices>							
 */
package program;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * This class contains method to calculate the addition, subtraction,
 * multiplication of two matrices
 *
 * @author Nguyen Hoang Manh
 */
public class CalculateMatrices {

    private static int[][] matrix1;
    private static int[][] matrix2;

    private final static Logger logger = Logger.getLogger(CalculateMatrices.class.getName());

    /**
     * Check input for integer value
     *
     * @param mess message to print to screen. It is a
     * <code>java.lang.String</code> object
     * @return an integer after conditions are met. It is a
     * <code>java.lang.Integer</code> object
     */
    public static int inputInteger(String mess) {
        int input = Integer.MIN_VALUE;

        while (true) {
            System.out.print(mess);
            Scanner scn = new Scanner(System.in);
            try {
                input = scn.nextInt();

                return input;

            } catch (InputMismatchException e) {
                logger.warning("Please input an integer");
                continue;
            }
        }
    }

    /**
     * Input matrix and validate the conditions corresponding to the operation
     *
     * @param numberOfMatrices number of matrices. It is an
     * <code>java.lang.Integer</code> object
     * @param operation operation. It is an <code>java.lang.String</code> object
     */
    public static void inputMatrix(int numberOfMatrices, String operation) {

        int num = 0;
        int[][] matrix = null;

        while (num < numberOfMatrices) {
            int row = inputInteger("Enter Row Matrix " + (num + 1) + ": ");
            int col = inputInteger("Enter Column Matrix " + (num + 1) + ": ");

            if (num == numberOfMatrices - 1) {
                matrix1 = matrix;
                //Number of row and column of the first matrix should equals to the number of row and column of the second matrix
                if ((row != matrix1.length || col != matrix1[0].length) && (operation.contains("Addition") || operation.contains("Substraction"))) {
                    logger.warning("Number of row and column of the first matrix should equals to the number of row and column of the second matrix");
                    continue;
                    //Number of column of the first matrix should equals to the number of row of the second matrix 
                } else if (col != matrix1.length && operation.contains("Multiplication")) {
                    logger.warning("The number of column of the first matrix should equals to the number of row of the second matrix ");
                    continue;
                }
            }

            matrix = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = inputInteger("Enter Matrix [" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                }
            }

            num += 1;

            if (num == numberOfMatrices) {
                matrix2 = matrix;
            }
        }
    }

    /**
     * Display matrix to screen
     *
     * @param matrix 2d matrix. It is an <code>java.lang.Integer</code> object
     */
    public static void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    /**
     * Add two matrices and print result to screen.
     */
    public static void additionMatrix() {
        System.out.println("--------Result--------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        int row = matrix1.length;
        int col = matrix1[0].length;
        
        int[][] matrixResult = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixResult[i][j] = (matrix1[i][j] + matrix2[i][j]);
            }
            
        }
        
        displayMatrix(matrixResult);
    }

    /**
     * Subtract two matrices and print result to screen.
     */
    public static void subtractionMatrix() {
        System.out.println("--------Result--------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        int row = matrix1.length;
        int col = matrix1[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + (matrix1[i][j] - matrix2[i][j]) + "]");
            }
            System.out.println();
        }
    }

    /**
     * Multiply two matrices and print result to screen.
     */
    public static void multiplicationMatrix() {

        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;

        System.out.println("--------Result--------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");

        int[][] matrixResult = new int[row1][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        displayMatrix(matrixResult);
    }

}
