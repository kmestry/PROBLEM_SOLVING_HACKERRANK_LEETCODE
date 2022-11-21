package com.neetcode.io;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoko {

    public static void main(String[] args) {
        boolean res = new ValidSudoko().isValidSudoku(new char[][]{
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

        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!set.add(c + "present in row" + i)
                            || !set.add(c + "present in col" + j)
                            || !set.add(c + "present in row-col" + i / 3 + "-" + j / 3)) {
                        return false;

                    }
                }
            }
        }

        return true;
    }
}
