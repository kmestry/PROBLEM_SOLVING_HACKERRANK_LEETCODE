package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        boolean res = new ValidSudokuOptimized().isValidSudoku(new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}});

        System.out.println("res = " + res);
    }

    public boolean isValidSudoku(char[][] board) {

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (checkChar(set, board[i][j])) return false;
            }
            set.clear();
        }

        set.clear();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (checkChar(set, board[j][i])) return false;
            }
            set.clear();
        }
        set.clear();

        int colStart = 0;
        int colEnd = 3;
        while (colEnd <= 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = colStart; j < colEnd; j++) {
                    if (checkChar(set, board[i][j])) return false;
                }
            }

            colStart += 3;
            colEnd += 3;
            set.clear();

        }

        set.clear();

        int colStart1 = 0;
        int colEnd1 = 3;
        while (colEnd1 <= 9) {
            for (int i = 3; i < 6; i++) {
                for (int j = colStart1; j < colEnd1; j++) {
                    if (checkChar(set, board[i][j])) return false;
                }
            }

            colStart1 += 3;
            colEnd1 += 3;
            set.clear();

        }

        set.clear();

        int colStart2 = 0;
        int colEnd2 = 3;
        while (colEnd2 <= 9) {
            for (int i = 6; i < 9; i++) {
                for (int j = colStart2; j < colEnd2; j++) {
                    if (checkChar(set, board[i][j])) return false;
                }
            }

            colStart2 += 3;
            colEnd2 += 3;
            set.clear();

        }

        set.clear();
        return true;

    }

    private boolean checkChar(Set<Character> set, char c1) {
        if (c1 != '.') {
            if (set.contains(c1)) {
                return true;
            }
            set.add(c1);
            return false;
        }
        return false;

    }
}
