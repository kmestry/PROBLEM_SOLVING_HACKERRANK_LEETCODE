package com.blind_list_75.matrix;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        wordSearch.exist(new char[][]{{'A', 'B', 'C', 'E'}
                , {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCED");
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && helper(board, 0, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, int indexW, int i, int j, String word) {

        //base condition.
        if (indexW == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(indexW) != board[i][j]) {
            return false;
        }

        board[i][j] = '0';

        if (helper(board, indexW + 1, i, j - 1, word) ||
                helper(board, indexW + 1, i, j + 1, word) ||
                helper(board, indexW + 1, i - 1, j, word) ||
                helper(board, indexW + 1, i + 1, j, word)) {
            return true;
        }


        board[i][j] = word.charAt(indexW);

        return false;
    }
}
