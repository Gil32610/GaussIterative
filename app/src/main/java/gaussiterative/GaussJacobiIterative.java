package main.java.gaussiterative;

import javax.lang.model.element.VariableElement;

public class GaussJacobiIterative {
    public static boolean isSolution(double[] result, double[] solution) {
        boolean equal = false;
        for (int i = 0; i < solution.length; i++) {
            if (result[i] != solution[i])
                return equal;
        }
        return !equal;
    }

    public static double[] findSolution(double[][] matrix, double[] result) {
        double[] variables = { 0, 0, 0 };

        for (int j = 0; !isSolution(result, varaibles); j++) {
            int currentPos = j % varaibles.length;

            switch (currentPos) {
                case 0 -> variables[currentPos] = (-variables[1]*matrix[0][1] - variables[2]*matrix[0][2] + result[0]) / matrix[0][0];
                case 1 -> variables[currentPos] = (-variables[0]*matrix[1][0] - variables[2]*matrix[1][2] + result[1]) / matrix[1][1];
                case 2 -> variables[currentPos] = (-variables[0]*matrix[2][0] - variables[1]*matrix[2][1] + result[2]) / matrix[2][2];
                default -> variables = null;
            }
        }
        return variables;

    }
}
