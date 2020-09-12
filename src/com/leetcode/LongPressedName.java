package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongPressedName {

    public static void main(String[] args) {

        /*
        *
        * "alex"
"aaleex"
*
* "alex"
"alexxr"
*/
        new LongPressedName().isLongPressedName("alex", "aaleex");
    }

    public boolean isLongPressedName(String name, String typed) {


        if (name.equals(typed)) return true;

        List<String> list = new ArrayList<>();

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (s.toString().equals("")) {
                s.append(c);
            } else if (s.charAt(s.length() - 1) == c) {
                s.append(c);
            } else {
                list.add(s.toString());
                s = new StringBuilder().append(c);
            }

        }
        if (s.length() > 0) {
            list.add(s.toString());
        }

        //"leelee", "lleeelee"
        int position = 0;
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            char c = str.charAt(0);
            int length = str.length();
            int inLength = 0;
            for (int j = position; j < typed.length(); j++) {

                final char c1 = typed.charAt(j);
                if (c == c1) {
                    inLength++;
                } else if (c != c1) {
                    if (inLength < length) {
                        return false;
                    } else {
                        position = j;

                        break;
                    }
                }
            }
        }
        return position != typed.length() - 1 || typed.charAt(position) == name.charAt(name.length() - 1);


    }
}
