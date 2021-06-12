package com.hackerrank.morgan_coding;

public class ExceptionTest {
    public static void main(String[] args) {
        /*try {
            new B().process();
        }catch (IOException e){
            System.out.println("Exception");
        }*/
    }

}

class A {
    public void process() {
        System.out.println("A,");
    }
}

class B extends A {
    //'process()' in 'com.hackerrank.morgan_coding.B' clashes with 'process()' in 'com.hackerrank.morgan_coding.A';
    // overridden method does not throw 'java.io.IOException'
   /* public void process() throws IOException{
        super.process();
        System.out.println("B,");
        throw new IOException();
    }*/
}
