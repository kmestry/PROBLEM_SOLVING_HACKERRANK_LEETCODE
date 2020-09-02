package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LargestTimeForGivenDigit {
    List<List<Integer>> resultList = new ArrayList<>();

    public static void main(String[] args) {
        String result = new LargestTimeForGivenDigit().largestTimeFromDigits(new int[]{0, 0, 3, 0
        });

        System.out.println("result = " + result);
    }

    public String largestTimeFromDigits(int[] numArray) {

        if (numArray[0] == 0 && numArray[1] == 0 && numArray[2] == 0 && numArray[3] == 0) return "00:00";

        String result = "";
        boolean[] visited = new boolean[numArray.length];
        findPermutation(numArray, new ArrayList<>(), visited);
        int maxNum = Integer.MIN_VALUE;
        int firstDigit = -1;
        int secondDigit = -1;
        int thirdDigit = -1;
        int fourthDigit = -1;

        int f = 0;
        int s = 0;
        int t = 0;
        int fo = 0;
        boolean isVisited = false;
        for (List<Integer> list : resultList) {

            firstDigit = list.get(0);
            secondDigit = list.get(1);
            thirdDigit = list.get(2);
            fourthDigit = list.get(3);
            int num = firstDigit * 1000 + secondDigit * 100 + thirdDigit * 10 + fourthDigit;
            if (num <= 2359 && thirdDigit < 6 && num > maxNum) {
                isVisited = true;
                maxNum = num;
                f = list.get(0);
                s = list.get(1);
                t = list.get(2);
                fo = list.get(3);
            }

        }

        if (isVisited)
            result = f + "" + s + ":" + t + "" + fo;
        else
            result = "";
        return result;


    }

    private void findPermutation(int[] numArray, List<Integer> currList, boolean[] visited) {

        if (currList.size() == numArray.length) {
            resultList.add(new ArrayList<>(currList));
            return;
        }

        for (int i = 0; i < numArray.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            currList.add(numArray[i]);
            findPermutation(numArray, currList, visited);
            currList.remove(currList.size() - 1);
            visited[i] = false;
        }
    }


}
