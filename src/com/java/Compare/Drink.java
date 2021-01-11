package com.java.Compare;

import java.util.TreeSet;

public class Drink implements Comparable {
    String name;

    public static void main(String[] args) {
        Drink one = new Drink();
        Drink two = new Drink();

        one.name = "Tea";
        two.name = "Coffee";

        TreeSet<Drink> set = new TreeSet();
        set.add(one);
        set.add(two);

        System.out.println(set);

        for (Drink obj : set) {
            System.out.println(obj.name);
        }
//        List list = (List) set.stream().collect(Collectors.toList());
//        System.out.println(list);
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }


}
