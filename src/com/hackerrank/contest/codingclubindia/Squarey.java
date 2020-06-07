package com.hackerrank.contest.codingclubindia;

import java.util.Scanner;

public class Squarey {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner src = new Scanner(System.in);
        int numberOfSquaresToPrint = src.nextInt();
        printSquares(numberOfSquaresToPrint);

    }

    static void printSquares(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.print((int) Math.pow(i, 2) + " ");
        }
    }
}
