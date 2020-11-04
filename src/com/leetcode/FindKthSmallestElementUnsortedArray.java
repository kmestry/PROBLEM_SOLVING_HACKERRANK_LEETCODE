package com.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class FindKthSmallestElementUnsortedArray {

    public static void main(String[] args) throws IOException {

        InputStream in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] k = bufferedReader.readLine().split("");
        String[] arrayNumbers = bufferedReader.readLine().split(" ");

        int[] array = new int[arrayNumbers.length];
        for (int i = 0; i < arrayNumbers.length; i++) {
            array[i] = Integer.valueOf(arrayNumbers[i]);
        }

        FindKthSmallestElementUnsortedArray obj = new FindKthSmallestElementUnsortedArray();
        int result = obj.findKthSmallestElement(array, Integer.valueOf(k[0]));
        System.out.println("result = " + result);

    }
    // 9 3 2 7 2 5 3 8  k == 4

    private int findKthSmallestElement(int[] inArray, int k) {

        Map<Integer, Integer> frequencyMap = new TreeMap<>(Comparator.naturalOrder());

        for (int i = 0; i < inArray.length; i++) {

            if (frequencyMap.containsKey(inArray[i])) {
                frequencyMap.put(inArray[i], frequencyMap.get(inArray[i]) + 1);
            } else {
                frequencyMap.put(inArray[i], 1);
            }
        }

        int counter = 1;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            if (counter == k) {
                return entry.getKey();
            }
            counter++;

        }

        return -1;
    }
}
