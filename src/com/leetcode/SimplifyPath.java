package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {

    public static void main(String[] args) {
        String result = new SimplifyPath().simplifyPathTrial("/a/./b/../../c/");
        System.out.println("result = " + result);
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        for (String token : path.split("/")) {
            if (!stack.isEmpty() && "..".equals(token))
                stack.pop();
            else if (!Arrays.asList(".", "", "..").contains(token))
                stack.push(token);
        }

        return "/" + String.join("/", stack);
    }

    public String simplifyPathTrial(String path) {
        Stack<String> stack = new Stack();
        for (String token : path.split("/")) {
            if (!stack.isEmpty() && "..".equals(token))
                stack.pop();
            else if (!Arrays.asList(".", "", "..").contains(token))
                stack.push(token);
        }

        return "/" + String.join("/", stack);
    }
}