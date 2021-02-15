package com.leetcode;

public class AddBinaryOptimized {


    public static void main(String[] args) {
        new AddBinaryOptimized().addBinary("1110", "1111");
    }


    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';

            // System.out.println("sum " + sum);

            sb.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;

        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();


    }
}
