package com.java.override;

public class Test {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
        // b = c;
        newPrint(b);

      /*  System.out.println(b instanceof B);
        System.out.println(b instanceof B && (!(b instanceof A)));
        System.out.println(b instanceof B && (!(b instanceof C)));*/

    }

    private static void newPrint(A a) {
        a.printName();
    }
}
