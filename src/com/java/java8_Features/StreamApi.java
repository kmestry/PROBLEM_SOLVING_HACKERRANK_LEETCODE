package com.java.java8_Features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hp");
        list.add("dell");
        list.add("apple");

        list.parallelStream().forEach(s -> System.out.println("s = " + s));

        Stream test = Stream.generate(() -> "hello").limit(5);
        test.forEach(System.out::println);

        Stream.iterate(100, integer -> integer + 1).limit(10).forEach(System.out::println);
    }
}
