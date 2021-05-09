package com.geeksforgeeks.searching;

public class SquareRootOfNumber {

    long floorSqrt(long x) {
        // Your code here
        long low = 1;
        long high = x / 2;

        long result = 1;  // we need floor of square root. we can set default value as 1

        while (low <= high) {
            long mid = low + (high - low) / 2;

            long square = mid * mid;

            if (square == x) {
                return mid;
            } else if (square > x) {
                high = mid - 1;
            } else {
                result = mid;
                low = mid + 1;
            }
        }
        return result;
    }
}
