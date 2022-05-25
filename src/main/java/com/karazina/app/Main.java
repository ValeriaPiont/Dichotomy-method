package com.karazina.app;

import com.karazina.exception.CountException;
import com.karazina.math.DichotomyMethod;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter degrees for function f(x) = a*x^3 + b*x^2 + c*x + d:");

        double[] coefficients = new double[3 + 1];
        System.out.println("Enter values for:");
        for (int i = 0; i < coefficients.length; i++) {
            System.out.print((char)(i + 97) + ": ");
            coefficients[coefficients.length - i - 1] = input.nextDouble();
        }

        System.out.println("Enter upper and lower bounds: ");
        System.out.print("Upper bound: ");
        double upperBound = input.nextDouble();
        System.out.print("Lower bound: ");
        double lowerBound = input.nextDouble();

        // PolynomialFunction is immutable representation of a real polynomial function with real coefficients.
        // parameters are taken as an array of doubles, in order of increasing degree. i.e., [x^0, x^1, x^2 ... x^n-1]
        PolynomialFunction function = new PolynomialFunction(coefficients);

        //check if f(a) * f(b) >= 0
        if (function.value(upperBound) * function.value(lowerBound) >= 0) {
            throw new CountException("No root exists within the given interval.");
        }

        DichotomyMethod.count(function, upperBound, lowerBound);

    }

}
