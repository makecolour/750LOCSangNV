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

/**
 * This class contains the main method for implementing the matrices calculation
 *
 * @author Nguyen Hoang Manh
 */
public class MatrixProgram {

    private final static int MAX_MATRIX_INPUT = 2;

    /**
     * Print out menu. Allow user to add, subtract or multiply two matrices.
     *
     * @param args
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.add("Addition Matrix");
        menu.add("Substraction Matrix");
        menu.add("Multiplication Matrix");
        menu.add("Quit");

        int userChoice;

        do {
            System.out.println("===== Calculator program =====");
            userChoice = menu.getUserChoice();
            if (userChoice != menu.size()) {
                System.out.println("---" + menu.get(userChoice - 1) + "---");
                CalculateMatrices.inputMatrix(MAX_MATRIX_INPUT, menu.get(userChoice - 1));
            }

            switch (userChoice) {
                case 1:
                    CalculateMatrices.additionMatrix();
                    break;
                case 2:
                    CalculateMatrices.subtractionMatrix();
                    break;
                case 3:
                    CalculateMatrices.multiplicationMatrix();
                    break;
                case 4:
            }
        } while (userChoice != menu.size());
    }
}
