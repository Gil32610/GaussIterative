package main.java.gaussiterative;

public class GaussJacobiIterative {
    public static boolean isSolution(double[] result, double[] solution) {
        boolean equal = false;
        for (int i = 0; i < solution.length; i++) {
            if(result[i]!=solution[i]) return equal;
        }
        return !equal;
    }
}
