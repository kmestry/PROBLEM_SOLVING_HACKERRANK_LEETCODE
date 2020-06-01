package com.hackerrank.thirtydaysofcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapKeyValue {

    public static void main(String[] argh) {
        Map<String, Integer> telephoneMap = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            telephoneMap.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.next();
            // Write code here
            if (telephoneMap.containsKey(s)) {
                System.out.println(s + "=" + telephoneMap.get(s));
            } else {
                System.out.println("Not Found");
            }
        }
        in.close();
    }
}
