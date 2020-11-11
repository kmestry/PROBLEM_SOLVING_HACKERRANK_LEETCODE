package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSquare {

    public static void main(String[] args) {
        //[0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]

        new ValidSquare().validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1});
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(findDistance(p1, p2));
        set.add(findDistance(p1, p3));
        set.add(findDistance(p1, p4));
        set.add(findDistance(p2, p3));
        set.add(findDistance(p2, p4));
        set.add(findDistance(p3, p4));

        if (set.contains(0)) return false;
        return set.size() == 2;


    }

    public int findDistance(int[] x, int[] y) {
        return (x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]);
    }
}
