package com.java.Compare;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Drink implements Comparable {
    String name;

    public static void main(String[] args) {
        Drink one = new Drink();
        Drink two = new Drink();

        one.name = "Tea";
        two.name = "Coffee";

        TreeSet set = new TreeSet();
        set.add(one);
        set.add(two);

        List list = (List) set.stream().collect(Collectors.toList());
        System.out.println(list);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


}
