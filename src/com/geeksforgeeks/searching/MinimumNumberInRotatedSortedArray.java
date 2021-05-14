package com.geeksforgeeks.searching;

public class MinimumNumberInRotatedSortedArray {

    public static void main(String[] args) {
        MinimumNumberInRotatedSortedArray minimumNumberInRotatedSortedArray = new MinimumNumberInRotatedSortedArray();
        /*int result = minimumNumberInRotatedSortedArray.minNumber(new int[]{60, 10, 20, 30, 40, 50},
                0, 5);*/
      /*  int result = minimumNumberInRotatedSortedArray.minNumber(new int[]{2, 3, 4 ,5 ,6 ,7, 8, 9 ,10 ,1},
                0, 9);*/

        int[] arr = new int[]{429, 491, 502, 511, 580, 591, 592, 600, 607, 621, 622, 665, 692, 697, 708, 717, 720, 752, 758, 759, 771, 780, 801, 811, 828, 834, 865, 873, 885, 944, 955, 1, 14, 18, 29, 53, 70, 71, 77, 120, 129, 166, 169, 176, 184, 222, 224, 255, 326, 355, 379, 393, 398, 409, 417};
        int result = minimumNumberInRotatedSortedArray.minNumber(arr, 0, arr.length - 1);

        System.out.println("result = " + result);
    }

    int minNumber(int[] arr, int low, int high) {
        // Your code here

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid > 0 && arr[mid - 1] > arr[mid])) {
                return arr[mid];
            } else if (mid < arr.length - 1 && arr[mid + 1] < arr[mid]) {
                return arr[mid + 1];
            } else if (arr[mid] < arr[low]) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return arr[0];
    }
}
