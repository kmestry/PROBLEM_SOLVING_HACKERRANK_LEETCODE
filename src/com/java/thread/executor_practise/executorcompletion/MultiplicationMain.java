package com.java.thread.executor_practise.executorcompletion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiplicationMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Multiplication multiplication1 = new Multiplication(23, 12, 1000, "TASK1");
        Multiplication multiplication2 = new Multiplication(3232, 1122, 20000, "TASK2");
        Multiplication multiplication3 = new Multiplication(76, 87, 500, "TASK3");
        Multiplication multiplication4 = new Multiplication(98, 7, 6000, "TASK4");

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        CompletionService<Integer> executorCompletionService = new ExecutorCompletionService<>(executorService);
        List<Future<Integer>> list = new ArrayList<>();
        list.add(executorCompletionService.submit(multiplication1));
        list.add(executorCompletionService.submit(multiplication2));
        list.add(executorCompletionService.submit(multiplication3));
        list.add(executorCompletionService.submit(multiplication4));

        for (Future<Integer> f : list) {
            Integer result = executorCompletionService.take().get();
            System.out.println("result:" + result);
        }
    }
}
