package com.hackerrank.algorithms.searching;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HackerLandRadioTransmitter {

    //
/*      7 2
        9 5 4 2 6 15 12*/

    private static final Scanner scanner = new Scanner(System.in);
    static int anInt = 0;

    // Complete the hackerlandRadioTransmitters function below.
    static int hackerlandRadioTransmitters(int[] x, int k) {
        Set<Integer> resultArray = new TreeSet<>();
        for (int j = 0; j < x.length; j++) {
            resultArray.add(x[j]);
        }

        if (resultArray.size() == 1) {
            return 1;
        }

        Arrays.sort(x);
        List<List<Integer>> listOfTransmitterCoverage = new ArrayList<>();

        for (int i = 0; i < x.length; i++) {
            int leftElement = x[i] - k;
            int rightElement = x[i] + k;
            List<Integer> innerList = new ArrayList<>();


            for (int j = leftElement; j <= rightElement; j++) {
                int indexOfElement = binarySearch(x, j);
                if (indexOfElement != -1) {
                    innerList.add(x[indexOfElement]);
                }

            }
            listOfTransmitterCoverage.add(innerList);
        }


        int counter = 1;
        for (anInt = 0; anInt < listOfTransmitterCoverage.size(); anInt++) {
            List<Integer> innerList = listOfTransmitterCoverage.get(anInt);
            int elementToFindInSuccessorList = innerList.get(innerList.size() - 1);  // last element of inner List
            int indexOfElement = binarySearch(x, elementToFindInSuccessorList);
            if (indexOfElement == x.length - 1) {
                return counter;
            }
            for (int j = anInt + 1; j < listOfTransmitterCoverage.size(); j++) {

                List<Integer> innerListSuccessor = listOfTransmitterCoverage.get(j);


                int nextElementToFind = x[indexOfElement + 1];

                if (nextElementToFind == innerListSuccessor.get(0)) {
                    counter++;
                    anInt = j - 1;
                    break;
                }


            }


        }
        return counter;
    }

    static int binarySearch(int[] array, int elementToFind) {
        int low = 0;
        int high = array.length - 1;


        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (elementToFind < array[mid]) {
                high = mid - 1;
            } else if (elementToFind > array[mid]) {
                low = mid + 1;
            } else if (elementToFind == array[mid]) {
                return mid;
            }


        }
        return -1;


    }

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = hackerlandRadioTransmitters(x, k);
        System.out.println(result);

       /* int index = binarySearch(new int[]{2, 4, 5, 6, 7, 9, 11, 12}, 20);
        System.out.println("index = " + index);*/


        scanner.close();
    }
}
