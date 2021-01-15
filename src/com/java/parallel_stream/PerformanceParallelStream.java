package com.java.parallel_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class PerformanceParallelStream {

    public static void main(String[] args) {

        List<Integer> data = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            data.add(i);
        }
/*
        System.out.println("================");
        System.out.println("Parallel stream 1");
        System.out.println("================");
        long sum1 =data.parallelStream()
                .map(i -> (int) Math.sqrt(i))
                .map(PerformanceParallelStream::performComputation)
                .peek( (i) -> {
                    System.out.println("Processing with "+Thread.currentThread().getName()+" "+ i);

                })
                .reduce(0, Integer::sum);

        System.out.println("Sum: "+sum1);*/

       /* System.out.println("================");
        System.out.println("Parallel stream 2");
        System.out.println("================");

        long sum2 = data.parallelStream()
                .map(i -> ((int) Math.sqrt(i)*10))
                .map(number -> performComputation(number))
                .peek( (i) -> {
                    System.out.println("Processing with "+Thread.currentThread().getName()+"== "+ i);

                })
                .reduce(0, Integer::sum);

        System.out.println("Sum: "+sum2);*/

       /* System.out.println("================");
        System.out.println("Parallel stream with custom thread pool 1");
        System.out.println("================");

        ForkJoinPool fjp1 = new ForkJoinPool(2);
        long sumFJ1 = 0;

        Callable<Integer> callable1 = () -> data.parallelStream()
                .map(i -> (int) Math.sqrt(i)*23+Math.sqrt(30)*342)
                .map(PerformanceParallelStream::performComputation)
                .peek( (i) -> {
                    System.out.println("Processing with "+Thread.currentThread().getName()+" == "+ i);

                })
                .reduce(0, Integer::sum);

        try {
            sumFJ1 = fjp1.submit(callable1).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Sum: "+sumFJ1);*/

        System.out.println("================");
        System.out.println("Parallel stream with custom thread pool 2");
        System.out.println("================");

        Callable<Integer> callable2 = () -> data.parallelStream()
                .map(i -> (int) Math.sqrt(i) * 10)
                .map(number -> performComputation(number))
                .peek((i) -> {
                    System.out.println("Processing with " + Thread.currentThread().getName() + " ===" + i);

                })
                .reduce(0, Integer::sum);

        long sumFJ2 = 0;

        ForkJoinPool fjp2 = new ForkJoinPool(1);

        try {
            sumFJ2 = fjp2.submit(callable2).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("Sum: " + sumFJ2);
    }

    public static int performComputation(Integer number) {
        int sum = 0;
        for (int i = 1; i < 100000; i++) {
            int div = number / i;
            sum += div;

        }
        return sum;
    }
}
 