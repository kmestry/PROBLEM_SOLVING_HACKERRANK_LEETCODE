package com.hackerrank.thirtydaysofcode;

import java.io.IOException;

public class RecurssionFactorial {

    // Complete the factorial function below.
    // 3!
    static int factorial(int n) {

        if (n > 1) {
            int result = n * factorial(n - 1);
            return result;
        } else {
            return 1;
        }


    }


    public static void main(String[] args) throws IOException {
        System.out.println(factorial(4));

    }
}
