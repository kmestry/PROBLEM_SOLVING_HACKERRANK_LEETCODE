package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangements {

    //backtracking to create a list of all permutations of 1 to n
    int counter = 0;

    public static void main(String[] args) {
        int result = new BeautifulArrangements().countArrangement(10);
        System.out.println("result = " + result);
    }

    public int countArrangement(int n) {
        permutations(n, new ArrayList<>(), new boolean[n + 1]);

        return counter;
    }

    private void permutations(int n, List<Integer> list, boolean[] visited) {

        if (list.size() > n) {
            return;
        }

        if (list.size() == n) {
            boolean isBeautifulArrangement = checkArrangement(list);
            if (isBeautifulArrangement) {
                counter++;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            list.add(i);
            visited[i] = true;
            permutations(n, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    private boolean checkArrangement(List<Integer> list) {

        boolean firstCondition = true;

        var index1 = 1;
        for (int element : list) {
            if (element % index1 == 0 || index1 % element == 0) {
                index1++;
            } else {
                firstCondition = false;
                break;
            }

        }

        return firstCondition;
    }
}
