package com.geeksforgeeks.searching.practise;

public class SquareRootPractise {

    public int mySqrt(int x) {

        long i = 0;

        while (i * i <= x) {
            i++;
        }

        return (int) i - 1;

        //0 1 2 3 4 5 6 7
    }
}
