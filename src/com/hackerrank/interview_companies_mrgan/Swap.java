package com.hackerrank.interview_companies_mrgan;

public class Swap {

    public static void main(String[] args) {
        Animal a1 = new Animal("Lion");
        Animal a2 = new Animal("Crocodile");

        System.out.println("Before swap: a1" + a1 + ":a2:" + a2);
        swap(a1, a2);
        System.out.println("Before swap: a1" + a1 + ":a2:" + a2);
    }

    public static void swap(Animal a1, Animal a2) {
        Animal temp = new Animal("");
        //temp = a1;
        a1 = temp;
        a2 = temp;
    }


}

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}