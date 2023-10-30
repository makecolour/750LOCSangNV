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
 * This class contains the main method for implementing the matrices calculation
 * project
 *
 * @author Nguyen Ba Duc Minh
 */
public class MatrixMain {

    /**
     * Ask user for inputting choice additionMatrix subtractionMatrix
     * multiplicationMatrix
     *
     * @param args
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        int userChoice;
        do {
            userChoice = menu.getUserChoice();
            switch (userChoice) {
                case 1:
                    MatrixCalculator.additionMatrix();
                    break;
                case 2:
                    MatrixCalculator.subtractionMatrix();
                    break;
                case 3:
                    MatrixCalculator.multiplicationMatrix();
                    break;
                case 4:
                    System.out.println("Quit");
            }
        } while (userChoice != 4);
    }
}
