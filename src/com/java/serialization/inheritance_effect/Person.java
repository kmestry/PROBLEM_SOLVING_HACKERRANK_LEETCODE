package com.java.serialization.inheritance_effect;

public class Person {

    String name = "DEFAULT";

    public Person() {
        System.out.println("Person Default Constructor!!");
    }

    public Person(String name) {
        this.name = name;
    }

}
