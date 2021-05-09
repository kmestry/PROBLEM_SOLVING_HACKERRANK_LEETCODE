package com.coding.practise.mcq;

public class Car<T> {
    public static void main(String[] args) {
        Car<String> cString = new Car<>();
        Car c = cString;
    }

    void set(T t) {

    }
}
