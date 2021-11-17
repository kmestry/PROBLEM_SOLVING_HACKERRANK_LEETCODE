package com.java.java8_Features;

import java.util.stream.Stream;

public class StreamLazyExample {


    public static void main(String[] args) {
        Stream<String> cars = Stream.of("honda", "hero", "toyota");

        Stream<String> nameStartingWithHCars = cars.map(String::toUpperCase)
                .peek(s -> System.out.println("s = " + s))
                .filter(s -> s.startsWith("H"));

        System.out.println("Calling terminal operation!!!");

        long count = nameStartingWithHCars.count();
        System.out.println("count = " + count);
    }


}
