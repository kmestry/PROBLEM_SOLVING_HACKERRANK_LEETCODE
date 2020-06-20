package com.hackerrank.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaximumElement {

    static int maximum = 0;

    public static void main(String[] args) throws IOException {
        InputStream in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String numberOfQueries = bufferedReader.readLine();
        int numberOfQueriesInteger = Integer.parseInt(numberOfQueries);
        Stack<Integer> integerStack = new Stack<>();
        for (int i = 0; i < numberOfQueriesInteger; i++) {
            String[] arrayOfValues = bufferedReader.readLine().trim().split(" ");
            printResultOfQueries(arrayOfValues, integerStack);

        }
    }


    static void printResultOfQueries(String[] array, Stack<Integer> integerStack) {
        int typeOfQuery = Integer.parseInt(array[0]);

        if (typeOfQuery == 3) {
            System.out.println(maximum);
        } else if (typeOfQuery == 1) {
            int elementToPush = Integer.parseInt(array[1]);
            if (elementToPush > maximum) {
                maximum = elementToPush;
            }
            integerStack.push(elementToPush);

        } else {
            integerStack.pop();
            maximum = integerStack.parallelStream().max(Integer::compareTo).orElse(0);

        }
    }
}
