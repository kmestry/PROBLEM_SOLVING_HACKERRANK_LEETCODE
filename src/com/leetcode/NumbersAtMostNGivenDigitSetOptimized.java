package com.leetcode;

public class NumbersAtMostNGivenDigitSetOptimized {

    public static void main(String[] args) {
        int result = new NumbersAtMostNGivenDigitSetOptimized().atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 5367);
        System.out.println("result = " + result);
    }

    public int atMostNGivenDigitSet(String[] D, int N) {
        String S = String.valueOf(N);
        int K = S.length();

        int answer = 0;
        boolean searchNextDigit = true;
        for (int i = 0; i < K && searchNextDigit; ++i) {
            int max = S.charAt(i) - '0';
            searchNextDigit = false;
            for (String d : D) {
                if (Integer.valueOf(d) < max) {
                    answer += Math.pow(D.length, K - 1 - i);
                } else if (Integer.valueOf(d) == max) {
                    searchNextDigit = true;
                    if (i == K - 1) {
                        ++answer;
                    }
                    break;
                }
            }
        }

        for (int i = 1; i < K; ++i) {
            answer += Math.pow(D.length, i);
        }
        return answer;
    }
}

