package com.hackerrank.morgan_coding;

import java.util.Arrays;
import java.util.List;

public class TaskQueue {

    public static void main(String[] args) {
        long time = TaskQueue.minTime(Arrays.asList(3, 2, 5, 7),
                Arrays.asList(5, 4, 10, 12), Arrays.asList(10, 6, 10, 5));
        System.out.println(time);
    }

    public static long minTime(List<Integer> batchSize,
                               List<Integer> processingTime,
                               List<Integer> numTasks) {
        // Write your code here
        // 4,3
        // 6,5
        // 8,8

        long timeRequired = 0;
        for (int i = 0; i < batchSize.size(); i++) {
            int maxBatchTasks = batchSize.get(i);
            int totalTasks = numTasks.get(i);
            int time = processingTime.get(i);

            long factor = (long) Math.ceil((double) totalTasks / (double) maxBatchTasks);
            long totalTimeForQueueProcessing = time * factor;
            timeRequired = Math.max(timeRequired, totalTimeForQueueProcessing);
        }

        return timeRequired;

    }
}
