package com.geeksforgeeks;

public class AllDivisorsOfANumber {

    public static void main(String[] args) {
        AllDivisorsOfANumber allDivisorsOfANumber = new AllDivisorsOfANumber();
        allDivisorsOfANumber.printAllDivisorsOptimized(15);
    }

    //naive solution
    //Divisor always appear in pairs. and pairs multiplied give the number
    private void printAllDivisors(int number) {

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.println("divisor is  = " + i);
            }
        }
    }

    private void printAllDivisorsOptimized(int number) {

        int i;
        for (i = 1; i * i < number; i++) {
            if (number % i == 0) {
                System.out.println("divisor is = " + i);

            }
        }
        for (int j = i; j >= 1; j--) {
            if (number % j == 0) {
                System.out.println("divisor is = " + number / j);
            }
        }


    }
}
