package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumDominoRotationsForEqualRow {

    public static void main(String[] args) {
        new MinimumDominoRotationsForEqualRow().minDominoRotations(new int[]{3, 5, 1, 2, 3}
                , new int[]{3, 6, 3, 3, 4});
    }

    // A = [2,1,2,4,2,2],
    // B = [5,2,6,2,3,2]
    public int minDominoRotations(int[] A, int[] B) {

        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();

        int maxA = -1; // the count of maximum repeated element in A.
        int maxB = -1; // the count of maximum repeated element in B.
        for (int i = 0; i < A.length; i++) {

            if (mapA.containsKey(A[i])) {
                final int countA = mapA.get(A[i]) + 1;
                mapA.put(A[i], countA);
                maxA = Math.max(countA, maxA);
            } else {
                mapA.put(A[i], 1);
                maxA = Math.max(1, maxA);
            }

            if (mapB.containsKey(B[i])) {
                final int countB = mapB.get(B[i]) + 1;
                mapB.put(B[i], countB);
                maxB = Math.max(countB, maxB);
            } else {
                mapB.put(B[i], 1);
                maxB = Math.max(1, maxB);
            }

        }

        boolean doesAHaveMaxRepeatedDominoNumber = maxA >= maxB;  // greedy approach , if maxA >= maxB we compare A with
        // B else B with A.

        int minRotations = 0;
        if (doesAHaveMaxRepeatedDominoNumber) {
            minRotations = getMinRotations(A, B, mapA, maxA);


            //this check was added to check all the possibilities but it works without the below code!
            //it checks B with A when A with B comparison returns -1 .
//            if (minRotations == -1) {
//                minRotations = getMinRotations(B, A, mapB, maxB);
//            }

        } else {
            //compare B with A.
            minRotations = getMinRotations(B, A, mapB, maxB);
//            if (minRotations == -1) {
//                minRotations = getMinRotations(A, B, mapA, maxA);
//            }
        }
        return minRotations;
    }

    private int getMinRotations(int[] firstArray, int[] secondArray, Map<Integer, Integer> map, int max) {
        int maxRepeatedValue = -1;

        int minRotations = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //map key is element and value is its frequency.
            //find the key of the most repeated element.
            if (entry.getValue() == max) {
                maxRepeatedValue = entry.getKey();
                break;
            }

        }

        //compare A and B array. to make the A have same element as the maxRepeated element. B should have
        //element == maxRepeated element when A does not have element equal to maxRepeated Element.
        //Else when A[i] != maxRepeatedValue and B[i] != maxRepeated value even with swapping B value .
        //All A elements will not have same value, so we break early. and return -1.
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != maxRepeatedValue && secondArray[i] == maxRepeatedValue) {
                minRotations++;
            } else if (firstArray[i] != maxRepeatedValue && secondArray[i] != maxRepeatedValue) {
                minRotations = -1;
                break;
            }
        }

        return minRotations;
    }
}
