package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        helper(0, 0, "", n);
        return list;
    }

    private void helper(int open, int close, String str, int n) {

        if (str.length() == 2 * n) {
            list.add(str);
            return;
        }

        if (open < n) {
            helper(open + 1, close, str + "(", n);
        }
        if (close < open) {
            helper(open, close + 1, str + ")", n);
        }
    }
}
