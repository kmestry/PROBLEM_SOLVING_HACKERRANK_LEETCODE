package com.geeksforgeeks.recursion;

public class Print1ToNTailRecursive {


    public static void main(String[] args) {
        Print1ToNTailRecursive print1ToNTailRecursive = new Print1ToNTailRecursive();
        print1ToNTailRecursive.print1ToNTailRecursive(5, 1);
    }

    //tail recursion. more efficient than normal recursion.
    private void print1ToNTailRecursive(int number, int start) {

        if (number == 0) {
            return;
        }
        System.out.println("start = " + start);


        print1ToNTailRecursive(number - 1, start + 1);
    }
}
