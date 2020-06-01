package com.hackerrank.stack;

import java.util.Stack;

public class EqualStacks {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        Stack<Integer> s3 = new Stack();

        for (int i = h1.length - 1; i >= 0; i--) {
            sum1 += h1[i];
            s1.push(sum1);
        }
        for (int i = h2.length - 1; i >= 0; i--) {
            sum2 += h2[i];
            s2.push(sum2);
        }
        for (int i = h3.length - 1; i >= 0; i--) {
            sum3 += h3[i];
            s3.push(sum3);
        }

        while (true) {

            if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
                return 0;
            }
            int s1First = s1.peek();
            int s2First = s2.peek();
            int s3First = s3.peek();
            if (s1First == s2First && s2First == s3First) {
                return s1First;
            }


            if (s1First >= s2First && s1First >= s3First) {
                s1.pop();
            }
            if (s2First >= s1First && s2First >= s3First) {
                s2.pop();
            }
            if (s3First >= s2First && s3First >= s1First) {
                s3.pop();
            }


        }


    }

    public static void main(String[] args) {

        /*
        *    3, 2, 1, 1, 1

4, 3 ,2

1 ,1 ,4 ,1
        * */

        int[] h1 = {3, 2, 1, 1, 1};
        int[] h2 = {4, 3, 2};
        int[] h3 = {1, 1, 4, 1};
        equalStacks(h1, h2, h3);
    }
}
