package com.geeksforgeeks.recursion;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {


    public static void main(String[] args) {
        TowerOfHanoi.shiftPile(2, 2);
    }

    static List<Integer> shiftPile(int N, int n) {
        // code here

        List<Pair> list = new ArrayList<>();

        helper(N, list, 1, 2, 3);

        List<Integer> result = new ArrayList<>();
        Pair pair = list.get(n - 1);
        result.add(pair.x);
        result.add(pair.y);

        System.out.println("result = " + result);
        return result;


    }

    private static void helper(int numberOfPlates, List<Pair> list
            , int A, int B, int C) {
        if (numberOfPlates == 1) {

            list.add(new Pair(A, C));
            return;
        }

        helper(numberOfPlates - 1, list, A, C, B);

        list.add(new Pair(A, C));

        helper(numberOfPlates - 1, list, B, A, C);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
