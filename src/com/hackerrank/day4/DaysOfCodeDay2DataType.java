package com.hackerrank.day4;

import java.util.Scanner;

public class DaysOfCodeDay2DataType {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */

        int myInt = 0;
        double myDouble = 0.0;
        String myString = "";
        /* Read and save an integer, double, and String to your variables.*/
        myInt = scan.nextInt();
        myDouble = scan.nextDouble();

        myString += scan.next();
        myString += scan.nextLine();
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

        /* Print the sum of both integer variables on a new line. */
        System.out.println(i + myInt);

        /* Print the sum of the double variables on a new line. */

        System.out.println(d + myDouble);

        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
        System.out.println(s + myString);
        scan.close();
    }
}

