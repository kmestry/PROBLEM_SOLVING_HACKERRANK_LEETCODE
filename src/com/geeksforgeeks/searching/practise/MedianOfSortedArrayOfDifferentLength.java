package com.geeksforgeeks.searching.practise;

public class MedianOfSortedArrayOfDifferentLength {

    public static void main(String[] args) {
        // int[] x = {1, 3, 8, 9, 15};  // 5
        // int[] y = {7, 11, 19, 21, 18, 25};  // 6

        int[] x = new int[]{3, 4};
        int[] y = new int[]{1, 2};
        MedianOfSortedArrayOfDifferentLength mm = new MedianOfSortedArrayOfDifferentLength();
        mm.findMedianSortedArrays(x, y);
    }

    public double findMedianSortedArrays(int[] input1, int[] input2) {
        int x = input1.length;
        int y = input2.length;

        int low = 0;    // 0
        int high = x;  //  5

        while (low <= high) {
            int partitionX = (low + high) / 2;  //2
            int partitionY = (x + y + 1) / 2 - partitionX;  //

            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : input1[partitionX - 1];
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightX = partitionX == x ? Integer.MAX_VALUE : input1[partitionX];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    int sum = Math.max(maxLeftX, maxLeftY) + Math.min(minRightY, minRightX);
                    return (double) sum / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException();
    }
}
