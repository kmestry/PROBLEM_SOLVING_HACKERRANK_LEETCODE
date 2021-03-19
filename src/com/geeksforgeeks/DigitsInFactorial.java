package com.geeksforgeeks;

public class DigitsInFactorial {

    public static void main(String[] args) {

        int result = new DigitsInFactorial().digitsInFactorial(120);
        System.out.println("result = " + result);
    }

    //formula
    // log(a*b) = log(a) + log(b)
    // log(n!) = log(1*2*3*4..n) = log(1) + log(2) + log(3) + ... + log(n)
    private int digitsInFactorial(int N) {

        double result = 0;
        for (int i = 1; i <= N; i++) {
            result += Math.log10(i);
        }
        return (int) (Math.floor(result) + 1);


    }


}
