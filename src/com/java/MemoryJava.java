package com.java;

public class MemoryJava {

    public static void decreaseNum(int n) {
        if (n >= 0) {
            decreaseNum(n - 1);
        }
        System.out.println("number :" + n);
    }

    public static void main(String[] args) {
        decreaseNum(2);
    }
}

