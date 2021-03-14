package com.geeksforgeeks;

import java.util.Arrays;
import java.util.List;

public class SieveOfEratosthenes {


    // O(n loglog n) sieve approach almost O(n)
    // O(n * root n) == O(n ^ 3/2)
    public static void main(String[] args) {

        new SieveOfEratosthenes().printAllPrimesTillNumber(16);
    }

    private void printAllPrimesTillNumber(int number) {
        boolean[] visited = new boolean[number + 1];

        List<Integer> multipleList = Arrays.asList(2, 3, 5);
        for (Integer i : multipleList) {
            markVisited(visited, i);
        }

        for (int i = 2; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println("prime factor is  = " + i);
            }
        }
    }

    private void markVisited(boolean[] visited, int multiple) {

        int start = multiple * multiple;


        for (int i = start; i < visited.length; i += multiple) {
            if (!visited[i]) {
                visited[i] = true;
            }
        }

    }
}
