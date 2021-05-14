package com.geeksforgeeks.searching;

public class TwoRepeatedElementsNoExtraSpace {

    public static void main(String[] args) {
        TwoRepeatedElementsNoExtraSpace twoRepeatedElementsNoExtraSpace = new TwoRepeatedElementsNoExtraSpace();
        twoRepeatedElementsNoExtraSpace.twoRepeated(new int[]{1, 2, 1, 3, 4, 3}, 6);
    }

    public Pair twoRepeated(int[] arr, int N) {
        Pair pair = new Pair();

        for (int i = 0; i < arr.length; i++) {

            if (arr[Math.abs(arr[i])] < 0 && pair.first == 0) {
                pair.first = Math.abs(arr[i]);
            } else if (arr[Math.abs(arr[i])] < 0 && pair.first > 0) {
                pair.second = Math.abs(arr[i]);
                return pair;
            }

            arr[Math.abs(arr[i])] = -1 * arr[Math.abs(arr[i])];

        }

        return null;
    }

    class Pair {
        int first;
        int second;
    }
}
