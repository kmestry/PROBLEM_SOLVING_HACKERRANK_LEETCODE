package com.hackerrank.interview_companies_mrgan;

import java.util.LinkedList;
import java.util.List;

public class GenericsTest {
    public static void main(String[] args) {
        Child c = new Child();
        c.say(new LinkedList<String>());
    }
}

class Parent {
    void say(List<String> list) {
        System.out.println("parent");
    }
}

class Child extends Parent {
    void say(List list) {
        System.out.println("child");
    }
}