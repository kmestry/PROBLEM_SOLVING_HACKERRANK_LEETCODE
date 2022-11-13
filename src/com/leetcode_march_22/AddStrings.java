package com.leetcode_march_22;

public class AddStrings {

    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        int pt1 = num1.length() - 1;
        int pt2 = num2.length() - 1;

        int carry = 0;
        while (pt1 >= 0 && pt2 >= 0) {

            int tot = (num1.charAt(pt1) - '0') + (num2.charAt(pt2) - '0') + carry;
            // System.out.println(tot);

            carry = tot / 10;
            sb.append(tot % 10);


            pt1--;
            pt2--;
        }
        // System.out.println(sb);


        while (pt1 >= 0) {
            int tot = (num1.charAt(pt1) - '0') + carry;
            carry = tot / 10;
            sb.append(tot % 10);
            pt1--;
        }

        while (pt2 >= 0) {
            int tot = (num2.charAt(pt2) - '0') + carry;
            carry = tot / 10;
            sb.append(tot % 10);
            pt2--;
        }

        if (carry > 0) sb.append(carry);

        return sb.reverse().toString();

    }


    //  123
    //  11

}
