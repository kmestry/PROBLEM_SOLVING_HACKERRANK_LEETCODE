package com.java.concurrent_util_java2blogsite.cyclic_barrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CyclicBarrierFinishEvent());

        RunnableTask task1 = new RunnableTask(cyclicBarrier, 1000);
        RunnableTask task2 = new RunnableTask(cyclicBarrier, 2000);
        RunnableTask task3 = new RunnableTask(cyclicBarrier, 3000);
        RunnableTask runnableTask4 = new RunnableTask(cyclicBarrier, 4000);
        new Thread(task1, "Thread 1").start();
        new Thread(task2, "Thread 2").start();
        new Thread(task3, "Thread 3").start();
        new Thread(runnableTask4, "Thread-4").start();


        RunnableTask runnableTask5 = new RunnableTask(cyclicBarrier, 5000);
        RunnableTask runnableTask6 = new RunnableTask(cyclicBarrier, 6000);

        // Create and start 3 more threads

        new Thread(runnableTask5, "Thread-5").start();
        new Thread(runnableTask6, "Thread-6").start();

    }
}
