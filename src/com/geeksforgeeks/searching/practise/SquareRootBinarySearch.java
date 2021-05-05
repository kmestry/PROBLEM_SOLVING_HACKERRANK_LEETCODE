package com.geeksforgeeks.searching.practise;

public class SquareRootBinarySearch {
    public static void main(String[] args) {

        SquareRootBinarySearch squareRootBinarySearch = new SquareRootBinarySearch();
        int result = squareRootBinarySearch.mySqrt(1);
        System.out.println("result = " + result);
    }

    public int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }
        int low = 0;
        int high = x / 2;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long temp = (long) mid * mid;

            if (temp == x) {
                return mid;
            } else if (temp > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
                result = mid;
            }
        }
        return result;

    }
}
