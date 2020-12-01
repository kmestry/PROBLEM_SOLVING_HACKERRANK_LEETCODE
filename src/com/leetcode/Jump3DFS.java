package com.leetcode;

public class Jump3DFS {

    public boolean canReach(int[] arr, int start) {

        if (start < arr.length && start > -1 && arr[start] >= 0) {
            if (arr[start] == 0) {
                return true;
            }

            arr[start] = -arr[start]; // make negative to mark index as visited.
            return canReach(arr, start + arr[start])
                    || canReach(arr, start - arr[start]);
        }

        return false;

    }
}
