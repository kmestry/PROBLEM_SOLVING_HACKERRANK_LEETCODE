package com.hackerrank.algorithms.slidingwindow;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaximumElementSubArray {

  /*  Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
    Output: [3,3,5,5,6,7]*/

    public static void main(String[] args) throws IOException {
        int[] result = maxSlidingWindowOptimizeTry1(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

       /* BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArray = bufferedReader.readLine().split(",");
        int[] input = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            input[i] = Integer.parseInt(inputArray[i]);
        }

        String windowSize = bufferedReader.readLine();

        int[] result = maxSlidingWindowOptimizeTry1(input, Integer.parseInt(windowSize));*/
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ",");
        }

        //


        //  maxSlidingWindow(new int[]{1}, 1);


    }

    //1, 3, -1, -3, 0,5, 3, 6, 7
    //max element will always be in front of queue
    public static int[] maxSlidingWindowOptimizeTry1(int[] nums, int k) {

        Deque<Integer> integerQueue = new ArrayDeque<>();
        int windowSize = k;

        if (windowSize == 1) {
            return nums;
        }
        int arrayIndexCounter = 1;
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < windowSize; i++) {
            addToQueue(nums, integerQueue, i, k);
        }
        result[0] = integerQueue.getFirst();
        integerQueue.remove(nums[0]);  // always remove first element as this is the first window and we are done with max of first window.

        int pointer = 1;
        for (int i = windowSize; i < nums.length; i++) {

            addToQueue(nums, integerQueue, i, k);

            result[arrayIndexCounter] = integerQueue.getFirst();

            System.out.println("integerQueue = " + integerQueue);
            integerQueue.remove(nums[pointer]);
            pointer++;
            arrayIndexCounter++;
        }


        return result;
    }

    private static void addToQueue(int[] nums, Deque<Integer> integerQueue, int i, int k) {
        if (integerQueue.isEmpty()) {
            integerQueue.addFirst(nums[i]);
        } else if (nums[i] >= integerQueue.getFirst()) {
            integerQueue.addFirst(nums[i]);
        } else {
           /* Set<Integer> setElementsLowerThanCurrent = integerQueue.stream().filter(integer -> integer < nums[i]).collect(Collectors.toSet());
            integerQueue.removeAll(setElementsLowerThanCurrent);*/

          /*  while (!integerQueue.isEmpty() && i >0 ) {
                if (integerQueue.peekLast() < nums[i]) {
                    integerQueue.removeLast();
                }
                k--;
            }*/

            while (integerQueue.size() > 0 && integerQueue.peekLast() < nums[i]) {
                integerQueue.pollLast();
            }

            integerQueue.add(nums[i]);
        }

    }


    public static int[] maxSlidingWindow(int[] nums, int k) {

        int originalWindow = k;
        List<Integer> result = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        int leftWindow = 0;


        while (k <= nums.length) {
            while (leftWindow <= nums.length - originalWindow) {
                for (int j = leftWindow; j < k; j++) {
                    innerList.add(nums[j]);
                }
                int maxSubArray = maximum(innerList);
                innerList.clear();
                result.add(maxSubArray);
                k++;
                leftWindow++;
                break;
            }


        }

        System.out.println("result = " + result);
        return result.stream().mapToInt(value -> value).toArray();
    }

    static int maximum(List<Integer> array) {
        return array.stream().max(Integer::compareTo).get();
    }
}
