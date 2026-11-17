package org.example.lab6.lab6_3;

public class EquationSolver {
    public static double solve(double a) {
        double left = 0.0;
        double right = Math.max(1.0, a);


        for (int i = 0; i < 100; i++) {
            double mid = (left + right) / 2.0;

            if (f(mid) < a) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (left + right) / 2.0;
    }

    private static double f(double x) {
        return x * x - x + Math.sqrt(x);
    }
}