package com.hackerrank.thirtydaysofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BinaryNumbers {

    private static final Scanner scanner = new Scanner(System.in);

    //5
    static int findNumberOfConsecutiveOnes(int number) {
        Stack<Integer> stack = new Stack();
        int counter = 0;
        while (number > 0) {
            int remainder = number % 2;
            number = number / 2;
            stack.push(remainder);
        }
        List<Integer> resultList = new ArrayList<>();
        while (!stack.isEmpty()) {
            if (stack.peek() == 1) {
                counter++;
                stack.pop();
            } else {
                stack.pop();
                resultList.add(counter);
                counter = 0;
            }
        }
        resultList.add(counter);

        return resultList.stream().max(Integer::compareTo).get();
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        findNumberOfConsecutiveOnes(n);

        scanner.close();


    }
}
