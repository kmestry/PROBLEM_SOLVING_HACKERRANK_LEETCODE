package com.datastructure_2_studyplan_leetcode.day6;

public class AddStrings {


    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        addStrings.addStrings("584", "18");
    }
    //  584
    //   18

    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        while (i >= 0 && j >= 0) {

            int first = num1.charAt(i) - '0';
            int second = num2.charAt(j) - '0';


            int tot = first + second + carry;

            sb.append(tot % 10);
            carry = tot / 10;
            i--;
            j--;

        }


        while (i >= 0) {

            int first = num1.charAt(i) - '0';

            int tot = first + carry;

            sb.append(tot % 10);
            carry = tot / 10;
            i--;
        }


        while (j >= 0) {
            int second = num2.charAt(j) - '0';
            int tot = second + carry;
            sb.append(tot % 10);
            carry = tot / 10;
            j--;
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();


    }
}
