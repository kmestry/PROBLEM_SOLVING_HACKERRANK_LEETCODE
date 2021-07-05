package com.blind_list_75.array;

public class FindSecondMax {

    public static void main(String[] args) {
        FindSecondMax findSecondMax = new FindSecondMax();
        print2largest(new int[]{18, 20, 19, 2, 1, 19, 11, 6, 12, 16, 8, 1, 1, 8, 20, 1, 6, 7, 9}, 19);
    }

    public static int print2largest(int[] A, int N) {
        //CODE HERE
        int firstMax = -1;
        int secondMax = -1;

        for (int i = 0; i < N; i++) {

            int num = A[i];
            if (num == firstMax) continue;

            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;

            } else if (num > secondMax) {
                secondMax = num;
            }
        }
        return secondMax;
    }
}
