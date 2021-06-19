package com.hackerrank.altrik.live.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Given a list of digits and a higher bound, build the highest number you //
        can from those digits that is smaller than or equal to the higher bound. //
        Examples:*/
// * Digits: 8, 7, 1; higher bound: "10000"
// * Answer: "871"
// * Digits: 8, 7, 1; higher bound: "200"
// * Answer: "187"
public class TestClass {

    List<Integer> numbersList = new ArrayList<>();

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        int result = testClass.largestNumber(Arrays.asList(0, 7, 1, 2), 1000);

        System.out.println(result);

    }

    // highest number will be formed by highest digit, followed by second highest
    //and so on.
    private int largestNumber(List<Integer> list, int higherBound) {

        //find the all possible numbers from the given list.
        helper(list, list.size(), new ArrayList<>(), new boolean[list.size()]);

        System.out.println(numbersList);
        for (int i = higherBound; i >= 0; i--) {
            if (numbersList.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    private void helper(List<Integer> list, int maxSize, List<Integer> currList, boolean[] visited) {


        if (currList.size() == maxSize) {
            //create number from list
            StringBuilder sb = new StringBuilder();
            for (Integer i : currList) {
                sb.append(i);
            }
            numbersList.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < maxSize; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            currList.add(list.get(i));
            helper(list, maxSize, currList, visited);
            currList.remove(currList.size() - 1);
            visited[i] = false;
        }

    }
}
