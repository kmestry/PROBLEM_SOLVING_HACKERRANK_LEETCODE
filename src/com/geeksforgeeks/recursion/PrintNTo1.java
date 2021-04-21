package com.geeksforgeeks.recursion;

public class PrintNTo1 {
    public static void main(String[] args) {

        PrintNTo1 printNTo1 = new PrintNTo1();
        printNTo1.printNTo1Recursion(5);
    }


    private void printNTo1(int number) {
        System.out.println("number = " + number);
        if (number == 1)
            return;
        printNTo1(number - 1);


    }

    private void printNTo1Recursion(int number) {

        if (number == 0)
            return;
        System.out.println("number = " + number);
        printNTo1Recursion(number - 1);


    }
}
