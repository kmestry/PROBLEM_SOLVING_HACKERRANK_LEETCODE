package com.java.override;

public class Test {
    public static void main(String[] args) {
        B b = new B();
        System.out.println(b instanceof B);
        System.out.println(b instanceof B && (!(b instanceof A)));
        System.out.println(b instanceof B && (!(b instanceof C)));

    }
}
