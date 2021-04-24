package com.geeksforgeeks.recursion;

public class PrintAllPermutationsString {

    public static void main(String[] args) {

        PrintAllPermutationsString printAllPermutationsString = new PrintAllPermutationsString();
        String str = "ABC";
        boolean[] visited = new boolean[str.length()];
        printAllPermutationsString.printAllPermutations(str, new StringBuilder(), visited);
    }

    private void printAllPermutations(String str, StringBuilder sb, boolean[] visited) {


        if (sb.length() == str.length()) {
            System.out.printf("sb.toString() = %s%n", sb);
            return;
        }


        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) continue;
            sb.append(str.charAt(i));
            visited[i] = true;
            printAllPermutations(str, sb, visited);
            sb.setLength(sb.length() - 1);
            visited[i] = false;
        }
    }
}
