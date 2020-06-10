package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

interface AdvancedArithmetics {
    int divisorSum(int n);
}

class Calculators implements AdvancedArithmetics {
    public int divisorSum(int n) {
        int sumOfDivisors = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0)
                sumOfDivisors += i;
        }
        return sumOfDivisors + n;
    }
}

class Interfaces {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetics myCalculator = new Calculators();
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
        System.out.println(sum);
    }
}
