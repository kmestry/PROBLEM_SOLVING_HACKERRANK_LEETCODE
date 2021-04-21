package com.geeksforgeeks.recursion;

import java.util.HashMap;
import java.util.Map;

public class RopeCuttingProblem {

    // n == 5 , a 2  b  5 c 1
    // Time Complexity is O(3^n)
    Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        RopeCuttingProblem ropeCuttingProblem = new RopeCuttingProblem();
        int max = ropeCuttingProblem.maxPieces(5, 2, 5, 1, 0, 0);
        //int max = ropeCuttingProblem.maxPieces(23, 12, 9, 11, 0, 0);
        // int max = ropeCuttingProblem.maxPieces(5, 4, 2, 6, 0, 0);
        // int max = ropeCuttingProblem.maxPieces(9, 2, 2, 2, 0, 0);
        System.out.println("max = " + max);
    }

    private int maxPieces(int n, int a, int b, int c, int totalSum, int count) {

        if (totalSum > n) {
            return 0;
        }
        if (totalSum == n) {
            return count;
        }

        String key = totalSum + "_" + count;
        if (map.containsKey(key)) {
            return map.get(key);
        }


        int A = 0, B = 0, C = 0;
        A += maxPieces(n, a, b, c, totalSum + a, count + 1);
        B += maxPieces(n, a, b, c, totalSum + b, count + 1);
        C += maxPieces(n, a, b, c, totalSum + c, count + 1);

        int max = Math.max(A, Math.max(B, C));
        map.put(key, max);
        return max;

    }
}
