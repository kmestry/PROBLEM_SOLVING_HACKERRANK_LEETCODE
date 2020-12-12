package com.java;

public class StaticTest {


    static {
        System.out.println("1 = " + 1);
    }

    public static void printNum() {
        System.out.println("true = " + true);
    }

    public static void main(String[] args) {
        StaticTest.printNum();
        System.out.println("args = " + args);
    }
}
