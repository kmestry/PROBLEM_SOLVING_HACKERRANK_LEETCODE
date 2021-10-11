package com.leetcode_restart;

import com.leetcode.ValidSudokuOptimized;

import java.util.HashSet;
import java.util.Set;

public class ValidaSudoko {

    public static void main(String[] args) {

        boolean res = new ValidaSudoko().isValidSudoku(new char[][]{
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}});
    }

    public boolean isValidSudoku(char[][] board) {

        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!seen.add(c + " +row+" + i)
                            || !seen.add(c + "+col+" + j)
                            || !seen.add(c + "box row" + i / 3 + "box col" + j / 3)) {
                        return false;
                    }
                }

            }
        }

        return true;
    }

}
