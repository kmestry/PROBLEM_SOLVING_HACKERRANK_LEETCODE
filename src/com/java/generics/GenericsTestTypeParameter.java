package com.java.generics;

public class GenericsTestTypeParameter {

    public static void main(String[] args) {
        Integer result = GenericsTestTypeParameter.findSmaller(12, 1);
        System.out.println("result = " + result);

        String smallerString = GenericsTestTypeParameter.findSmaller("ABC", "KUNA");

        System.out.println("smallerString = " + smallerString);

    }


    public static <T extends Comparable<T>> T findSmaller(T first, T second) {
        if (first.compareTo(second) < 0) {
            return first;
        } else {
            return second;
        }
    }
}
