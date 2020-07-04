package com.leetcode;

import java.util.Arrays;

public class RandomPickWeight {
    static int[] auxArray;
    static int sumCounter = 0;
    int[] w;
    int sumOfArray = 0;
    int counter = 0;

    public RandomPickWeight(int[] w) {
        this.w = w;
        auxArray = new int[w.length];
        this.sumOfArray = Arrays.stream(w).sum();
        Arrays.sort(w);

    }

    public static void main(String[] args) {
        RandomPickWeight randomPickWeight = new RandomPickWeight(new int[]{1, 3});
        System.out.println(randomPickWeight.pickIndex());
        System.out.println(randomPickWeight.pickIndex());
        System.out.println(randomPickWeight.pickIndex());
        System.out.println(randomPickWeight.pickIndex());
        System.out.println(randomPickWeight.pickIndex());
        System.out.println(randomPickWeight.pickIndex());
    }

    public int pickIndex() {

        for (int i = 0; i < w.length; i++) {
            while (w[i] != auxArray[i]) {
                auxArray[i] = counter + 1;
                counter++;
                if (counter == w[i]) {
                    counter = 0;
                }
                sumCounter++;
                if (sumCounter == sumOfArray) {
                    auxArray = new int[w.length];
                    sumCounter = 0;
                }
                return i;
            }
        }
        return 0;
    }
}
