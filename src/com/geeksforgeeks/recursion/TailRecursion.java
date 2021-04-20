package com.geeksforgeeks.recursion;

public class TailRecursion {


    public static void main(String[] args) {

        TailRecursion tailRecursion = new TailRecursion();
        tailRecursion.printNTo1(5);
    }

    //function is tail recursion function when the last thing the method line is the recursive call.
    // faster execution in modern compilers for tail recursion.
    //modern compilers do tail call elimination to optimize the code.
    // no auxillary space of stack required like normal recursion method, which has O(N) auxillary space.
    private void printNTo1(int number) {

        if (number == 0) {
            return;
        }

        System.out.println("number = " + number);
        printNTo1(number - 1); // last line. is call to same method. hence tail recursion.
    }
}
