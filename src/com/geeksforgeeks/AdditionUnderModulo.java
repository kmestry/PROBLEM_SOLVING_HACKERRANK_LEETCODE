package com.geeksforgeeks;

public class AdditionUnderModulo {

    public static void main(String[] args) {
        long result = new AdditionUnderModulo().sumUnderModulo(8279685334796349382l, 3890369874501826197l);
        System.out.println("result = " + result);
    }

    /*    A few distributive properties of modulo are as follows:
    1. ( a + b ) % c = ( ( a % c ) + ( b % c ) ) % c
    2. ( a * b ) % c = ( ( a % c ) * ( b % c ) ) % c
    3. ( a – b ) % c = ( ( a % c ) - ( b % c ) ) % c ( see notes at bottom )
    4. ( a / b ) % c NOT EQUAL TO ( ( a % c ) / ( b % c ) ) % c
        So, modulo is distributive over +, * and - but not / .*/
    public long sumUnderModulo(long a, long b) {
        // code here
        long mod = 1000000007l;


        long first = a % mod;
        long second = b % mod;

        long sum = first + second;

        return sum % mod;

    }
}
