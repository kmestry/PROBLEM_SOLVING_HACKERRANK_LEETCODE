package com.java.generics;

import java.util.Arrays;
import java.util.List;

public class GenericClass<T> {

    private T data;

    public static void main(String[] args) {
        GenericClass<String> genericClass = new GenericClass();
        genericClass.setData("1");

        System.out.println(genericClass.getData());

        GenericClass.printData(new Integer[]{1, 2, 3});
        GenericClass.printData(new String[]{"kuk", "sew"});

        GenericClass.printList(Arrays.asList(1, 1.2, 23.34f));

        GenericClass.printListSuper(Arrays.asList("32", 23, 23.342, new Object()));

    }

    public static void printListSuper(List<? super Number> list) {
        System.out.println(list.toString());
    }

    public static void printList(List<? extends Number> list) {
        System.out.println(list.toString());
    }

    public static <E> void printData(E[] objects) {
        for (E obj : objects) {
            System.out.println("==" + obj);
        }

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
