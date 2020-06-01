package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Conditions {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        isWeird(N);


        scanner.close();
    }

    private static void isWeird(int n) {
        int remainder = n % 2;
        if (remainder != 0) {
            System.out.println("Weird");
        }
        if (remainder == 0 && (n >= 2 && n <= 5)) {
            System.out.println("Not Weird");
        }
        if (remainder == 0 && (n >= 6 && n <= 20)) {
            System.out.println("Weird");
        }
        if (remainder == 0 && n > 20) {
            System.out.println("Not Weird");
        }
    }
}



