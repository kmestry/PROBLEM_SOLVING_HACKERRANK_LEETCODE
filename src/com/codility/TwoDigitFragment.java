package com.codility;

public class TwoDigitFragment {

    public static void main(String[] args) {
        TwoDigitFragment twoDigitFragment = new TwoDigitFragment();
        int result = twoDigitFragment.solution("88");
        System.out.println(result);
    }

    //50552
    public int solution(String S) {
        // write your code in Java SE 8
        int largestNumber = Integer.MIN_VALUE;

        for (int i = 0; i < S.length(); i++) {
            StringBuilder fragment = new StringBuilder();
            for (int j = i; j < S.length() && j <= i + 1; j++) {
                fragment.append(S.charAt(j));
            }
            largestNumber = Math.max(largestNumber, Integer.parseInt(fragment.toString()));
        }

        return largestNumber;
    }
}
