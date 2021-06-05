package com.geeksforgeeks.coding_test;

public class GenericTest<T> {

    public static void main(String[] args) {
        GenericTest<Number> genericTest = new GenericTest<>();
        genericTest.add(new Integer(1));
        genericTest.add(new Double(1.0));
    }

    void add(T t) {
        System.out.println("in add" + t);

    }
}
