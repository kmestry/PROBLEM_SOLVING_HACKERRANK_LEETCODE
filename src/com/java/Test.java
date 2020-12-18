package com.java;

public class Test {

    public static void main(String[] args) {

        try {
            int n = 15;

            int res = (int) Math.ceil((double) n / 2.0);
            System.out.println("res = " + res);
            //System.exit(1);
            throw new Exception();
        } catch (Exception e) {
            System.out.println("e = " + e);
            // System.exit(1);
        } finally {
            System.out.println(" = finally ===");
        }
    }


}
