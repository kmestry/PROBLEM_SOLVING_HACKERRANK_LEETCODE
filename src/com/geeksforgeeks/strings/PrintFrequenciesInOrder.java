package com.geeksforgeeks.strings;

public class PrintFrequenciesInOrder {
    public static void main(String[] args) {
        PrintFrequenciesInOrder printFrequenciesInOrder = new PrintFrequenciesInOrder();
        printFrequenciesInOrder.printFrequencies("geeksforgeeks");

        // String test = "geeks";

        // System.out.println( 'g' == test.charAt(1));


    }

    private void printFrequencies(String s) {

        char[] ch = new char[128];

        for (int i = 0; i < s.length(); i++) {
            ch[s.charAt(i)]++;
        }

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] > 0) {
                System.out.println("character : " + (char) i + " ,frequency is: " + (int) ch[i]);
            }
        }
    }
}
