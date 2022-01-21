package com.datastructure_2_studyplan_leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("kunal");
        list.add("mes");

        List<String> checkList = new ArrayList<>();

        System.out.println(list.containsAll(checkList));
    }
}
