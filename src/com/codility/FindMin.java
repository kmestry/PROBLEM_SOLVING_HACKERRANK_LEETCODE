package com.codility;

public class FindMin {

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int[] result = findMin.solution(1000);

        int minVal = findMin.findMin(result);
        System.out.println("minVal = " + minVal);
    }


    private int findMin(int[] A) {
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            if (ans > A[i]) {
                ans = A[i];
            }
        }
        return ans;
    }


    public int[] solution(int N) {
        // write your code in Java SE 8

        int[] result = new int[N];

        int dummy = 1;
        for (int i = 0; i < N; i++) {
            result[i] = dummy;
            dummy += 3;
        }


        return result;
    }
}
