package com.leetcode;

public class CommonPrefix {

    public static void main(String[] args) {

        String result = new CommonPrefix().longestCommonPrefix(new String[]{"flow", "flower"});
        System.out.println("result = " + result);
    }

    //bangalore
    //mangalore
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        int right = 0;

        int length = strs[0].length(); //take length of any string  as if its smallest common prefix will always be the smallest string,
        //if its largest or not smallest, we get the length less than smallest string in array

        StringBuilder sb = new StringBuilder();
        while (right < length) {

            char ch = strs[0].charAt(right);

            int counter = 0;
            for (int j = 1; j < strs.length; j++) {
                if (right >= strs[j].length()) {
                    return sb.toString();
                } else if (ch == strs[j].charAt(right)) {
                    counter++;
                } else {
                    return sb.toString();
                }
            }

            if (counter == strs.length - 1) {
                sb.append(ch);
            }
            right++;

        }

        return sb.toString();

    }
}
