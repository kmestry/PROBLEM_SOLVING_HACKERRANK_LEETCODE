package com.java;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CustomListSorting {

    public static void main(String[] args) {

        List<Pair> list = new CustomListSorting().createPairs();
        Collections.sort(list, Comparator.comparingInt(Pair::getValue).thenComparing(Pair::getKey));

        StringBuilder sb = new StringBuilder();

        for (Pair p : list) {
            sb.append(p.getKey()).append(",");
        }

        System.out.println("sb.deleteCharAt(sb.length() - 1) = " + sb.deleteCharAt(sb.length() - 1));

    }

    private List<Pair> createPairs() {
        List<Pair> list = new ArrayList<>();
        Pair p1 = new Pair("turtle", 1);
        Pair p2 = new Pair("bat", 1);
        Pair p3 = new Pair("dog", 6);
        Pair p4 = new Pair("cat", 4);
        Pair p5 = new Pair("rat", 6);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        return list;

    }

    class Pair {
        String key;
        Integer value;

        public Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

}



