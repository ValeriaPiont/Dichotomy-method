package com.karazina.math;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

public class DichotomyMethod {

    private static final int MAX = 100;// max number of iterations for bisection method

    private static final double DELTA = 0.0001;// accuracy level

    public static void count(PolynomialFunction function, double a, double b) {
        double midpoint;
        for (int i = 0; i < MAX; i++) {
            midpoint = (a + b) / 2;
            if (function.value(midpoint) == 0 || Math.abs((a - b)) / 2 < DELTA) {
                System.out.println("x = " + midpoint + " is a root of the function within the given interval");
                return;
            }
            System.out.println("Iteration " + (i + 1) + ". Value of midpoint: " + midpoint);
            //compare f(a), f(b) and f(midpoint) and create a new interval
            if (function.value(a) * function.value(midpoint) >= 0) { //if f(a) and f(midpoint) are of the same sign
                a = midpoint;
            } else { // if f(a) and f(midpoint) are of the same sign
                b = midpoint;
            }
        }
    }

}
