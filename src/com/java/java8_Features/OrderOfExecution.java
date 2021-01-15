package com.java.java8_Features;

import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;

public class OrderOfExecution {

    public static void main(String[] args) {
       Stream<String> cars =  Stream.of("Honda" , "Hero" , "Suzuki" , "Sega").map(s -> {
           System.out.println("s = " + s);
           return s.toUpperCase(Locale.ROOT);
       }).filter(s -> {
           System.out.println("s = " + s);
           return  s.startsWith("S");

       });

        Optional<String> result = cars.findAny();
        System.out.println("result = " + result.get());
    }

    /*Here order of operations might be surprising. A common approach will be to perform
    intermediate operation on all
    elements and then perform next operation, but instead each element moves vertically.*/
}
