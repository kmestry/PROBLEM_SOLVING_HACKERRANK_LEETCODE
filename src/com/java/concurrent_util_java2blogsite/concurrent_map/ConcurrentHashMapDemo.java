package com.java.concurrent_util_java2blogsite.concurrent_map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {

        Country c1 = new Country("India", 121221231);
        Country c2 = new Country("France", 545453);
        Country c3 = new Country("Germany", 2345435);

        ConcurrentHashMap<Country, String> map = new ConcurrentHashMap<>();
        map.put(c1, "DELHI");
        map.put(c2, "PARIS");
        map.put(c3, "BERLIN");

        map.keySet().forEach(System.out::println);
    }
}
