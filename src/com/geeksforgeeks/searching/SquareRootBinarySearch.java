package com.geeksforgeeks.searching;

public class SquareRootBinarySearch {

    public static void main(String[] args) {
        SquareRootBinarySearch squareRootBinarySearch = new SquareRootBinarySearch();
        // int result = squareRootBinarySearch.mySqrt(2147395599);
        int result = squareRootBinarySearch.mySqrt(2);
        System.out.println("result = " + result);
    }

    public int mySqrt(int x) {

        if (x == 1 || x == 0) return x;
        int low = 0;
        int high = x / 2;

        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long val = (long) mid * mid;
            if (val == x) {
                return mid; // found exact square root.
            } else if (val > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                result = mid; // find value which is mid * mid <= x
            }
        }
        return result;

    }
}
