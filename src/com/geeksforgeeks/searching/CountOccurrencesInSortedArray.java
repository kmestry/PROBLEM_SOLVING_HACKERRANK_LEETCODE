package com.geeksforgeeks.searching;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountOccurrencesInSortedArray {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int firstOccurrence = findFirstOccurrence(arr, x);
        if (firstOccurrence == -1) {
            return 0;
        } else {
            int lastOccurrence = findLastOccurrence(arr, x);
            return lastOccurrence - firstOccurrence + 1;
        }

    }


    private int findFirstOccurrence(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                if (mid == 0 || arr[mid] != arr[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }

            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;

    }

    private int findLastOccurrence(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                if (mid == arr.length - 1 || arr[mid] != arr[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


}

