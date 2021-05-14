package com.geeksforgeeks;

public class TwoRepeatedElementsExtraSpace {

    public Pair twoRepeated(int[] arr, int N) {
        Pair pair = new Pair();
        // Your code here
        int[] counter = new int[N + 2];

        for (int i = 0; i < arr.length; i++) {
            counter[arr[i]]++;

            if (counter[arr[i]] == 2 && pair.first == 0) {
                pair.first = arr[i];
            } else if (counter[arr[i]] == 2 && pair.first != 0) {
                pair.second = arr[i];
            }
        }

        return pair;
    }

    class Pair {
        int first;
        int second;
    }
}
