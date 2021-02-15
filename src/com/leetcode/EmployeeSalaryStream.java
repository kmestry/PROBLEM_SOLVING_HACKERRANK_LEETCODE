package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSalaryStream {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.stream().filter(integer -> integer > 10000).collect(Collectors.toList());


    }
}
