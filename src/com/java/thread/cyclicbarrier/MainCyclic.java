package com.java.thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class MainCyclic {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CyclicBarrierFinishEvent());
        RunnableTask runnableTask1 = new RunnableTask(cyclicBarrier, 1000);
        RunnableTask runnableTask2 = new RunnableTask(cyclicBarrier, 2000);
        RunnableTask runnableTask3 = new RunnableTask(cyclicBarrier, 3000);


        new Thread(runnableTask1, "THREAD : 1").start();
        new Thread(runnableTask2, "THREAD : 2").start();
        new Thread(runnableTask3, "THREAD : 3").start();


        RunnableTask runnableTask4 = new RunnableTask(cyclicBarrier, 4000);
        RunnableTask runnableTask5 = new RunnableTask(cyclicBarrier, 5000);
        RunnableTask runnableTask6 = new RunnableTask(cyclicBarrier, 6000);


        new Thread(runnableTask4, "THREAD : 4").start();
        new Thread(runnableTask5, "THREAD : 5").start();
        new Thread(runnableTask6, "THREAD : 6").start();


    }
}
