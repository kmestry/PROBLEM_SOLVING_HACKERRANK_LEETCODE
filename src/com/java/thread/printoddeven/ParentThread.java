package com.java.thread.printoddeven;

public class ParentThread {
    int max;
    boolean isOdd;
    int startingNum;


    public ParentThread() {

    }

    public ParentThread(int max, boolean isOdd, int startingNum) {
        this.max = max;
        this.isOdd = isOdd;
        this.startingNum = startingNum;
    }
}
