package main.java.gaussiterative;

import javax.lang.model.element.VariableElement;

public class GaussJacobiIterative {
    private int converge;
    private double[] result;
    private double[][] matrix;
    private double[] variables;

    private boolean isSolution(double[] result, double[] solution) {
        boolean equal = false;
        for (int i = 0; i < solution.length; i++) {
            if (result[i] != solution[i])
                return equal;
        }
        return !equal;
    }

    public void setResult(double[] result) {
        this.result = result;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public double[] getVariables() {
        findSolution();
        return variables;
    }

    private void findSolution() {
        double[] variables = { 0, 0, 0 };

        for (int j = 0; !isSolution(result, varaibles); j++) {
            int currentPos = j % varaibles.length;
            converge = j;
            switch (currentPos) {
                case 0 ->
                    variables[currentPos] = (-variables[1] * matrix[0][1] - variables[2] * matrix[0][2] + result[0])
                            / matrix[0][0];
                case 1 ->
                    variables[currentPos] = (-variables[0] * matrix[1][0] - variables[2] * matrix[1][2] + result[1])
                            / matrix[1][1];
                case 2 ->
                    variables[currentPos] = (-variables[0] * matrix[2][0] - variables[1] * matrix[2][1] + result[2])
                            / matrix[2][2];
                default -> variables = null;
            }
        }
        this.variables = variables;
    }

    private String variables(double[] variables) {
        String tripleVar = "";
        if (variables != null) {
            tripleVar += "(";
            for (int i = 0; i < variables.length; i++) {
                if (i == variables.length - 1)
                    tripleVar += variables[i] + ")";
                tripleVar += variables[i] + ", ";
            }
        }
        return tripleVar;
    }

    private String matrixToString(double[][] table) {
        String system = "";
        if (table != null) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[0].length; j++) {
                    system += (!(j == table[0].length - 1) ? table[i][j] + "  " : table[i][j] + "\n");
                }
            }
        }
        return system;
    }

    public String toString() {
        return "Matrix: \n" + matrixToString(matrix) + "\nSystem result: \n" + variables(result) + "\nSolution: \n"
                + variables(variables)+ "\nThe result converged at " + converge + " iteration.";
    }
}
