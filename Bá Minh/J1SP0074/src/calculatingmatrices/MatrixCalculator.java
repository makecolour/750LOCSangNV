/*
 * Copyright(C)2023, Nguyen Ba Duc Minh
 * JAVA
 * Matrices calculation
 *
 * Record of change:
 * Date          VERSION           AUTHOR             DESCRIPTION
 * 2023-09-15    1.0               MinhNBD            First implemention
 */
package calculatingmatrices;

/**
 * This class contains method to calculate the addition, subtraction,
 * multiplication of two matrices
 *
 * @author Nguyen Ba Duc Minh
 */
public class MatrixCalculator {

    private static double[][] matrixA;
    private static double[][] matrixB;
    private static double[][] result;

    /**
     * Calculate the addition of the two integer matrices
     */
    public static void additionMatrix() {
        System.out.println("-----------Addition-------------");
        boolean check = true;
        do {
            matrixA = createMatrix();
            matrixB = createMatrix();
            if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
                MyLog.getLogger().warning("Length of row or column in two matrix not equal!\nPlease re-enter two matrices again!");
            } else {
                check = false;
            }
        } while (check);
        result = new double[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        printResultToScreen("+");
    }

    /**
     * Calculate the subtraction of the two integer matrices
     */
    public static void subtractionMatrix() {
        System.out.println("-----------Subtraction-------------");
        do {
            matrixA = createMatrix();
            matrixB = createMatrix();
            if (matrixA.length != matrixB.length || matrixA[0].length != matrixB[0].length) {
                MyLog.getLogger().warning("Length of row or column in two matrix not equal!\nPlease re-enter two matrices again!");
            } else {
                break;
            }
        } while (true);
        result = new double[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[0].length; j++) {
                result[i][j] = matrixA[i][j] - matrixB[i][j];
            }
        }
        printResultToScreen("-");
    }

    /**
     * Calculate the multiplication of the two integer matrices
     */
    public static void multiplicationMatrix() {
        System.out.println("-----------Multiplication-------------");
        do {
            matrixA = createMatrix();
            matrixB = createMatrix();
            if (matrixA[0].length != matrixB.length) {
                MyLog.getLogger().warning("Length of row in the first matrix is not equal to length of column in the second matrix !\nPlease re-enter two matrices again!");
            } else {
                break;
            }
        } while (true);
        result = new double[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixB[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < matrixA[0].length; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        printResultToScreen("*");
    }

    /**
     * Create a matrix
     *
     * @return an integer matrix
     */
    private static double[][] createMatrix() {
        double[][] matrix;
        int column;
        int row;
        row = UserInput.getInt("Enter Row Matrix: ", "Row value must be Integer!");
        column = UserInput.getInt("Enter Column Matrix: ", "Column value must be Integer!");
        matrix = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = UserInput.getDouble("Enter Matrix[" + i + "][" + j + "]: ", "Value must be a number!");
            }
        }
        return matrix;
    }

    /**
     * Print the result to screen
     *
     * @param operator show operator to display
     */
    private static void printResultToScreen(String operator) {
        System.out.println("-----------Result-------------");
        display(matrixA);
        System.out.println(operator);
        display(matrixB);
        System.out.println("=");
        display(result);
    }

    /**
     * Display the matrix
     *
     * @param matrix The matrix to be displayed
     */
    private static void display(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }
}
