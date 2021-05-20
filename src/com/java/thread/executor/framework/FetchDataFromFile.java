package com.java.thread.executor.framework;


import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FetchDataFromFile implements Runnable {

    private final String fileName;

    public FetchDataFromFile(String fileName) {
        super();
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            FetchDataFromFile fdff = new FetchDataFromFile("File " + i);
            System.out.println("A new file has been added to read : " + fdff.getFileName());
            threadPoolExecutor.execute(fdff);
        }
        threadPoolExecutor.shutdown();
    }

    @Override
    public void run() {
        try {
            System.out.println("Fetching data from " + fileName + " by " + Thread.currentThread().getName());
            Thread.sleep(5000); // Reading file
            System.out.println("Read file successfully: " + fileName + " by " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }
}
