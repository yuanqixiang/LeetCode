package leetcode.backtracking;

import com.sun.org.apache.xml.internal.utils.Trie;

/*
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 */
public class _0079_WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j){
                if(helper(board, word, i, j, 0, used)) return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, int index, boolean[][] used) {
        if(index == word.length()) return true;
        int m = board.length, n = board[0].length;
        if (i < 0 || j < 0 || i == m || j == n) return false;
        if(used[i][j]) return false;
        if(board[i][j] != word.charAt(index)) return false;
        used[i][j] = true;
        boolean isExist = helper(board, word, i + 1, j, index + 1, used)
                || helper(board, word, i - 1, j, index + 1, used)
                || helper(board, word, i, j + 1, index + 1, used)
                || helper(board, word, i, j - 1, index + 1, used);
        used[i][j] = false;
        return isExist;
    }

    public static void main(String[] args) {
        _0079_WordSearch wordSearch = new _0079_WordSearch();
        char[][] board = new char[][]{{'A','B','C','E'},
                                      {'S','F','C','S'},
                                      {'A','D','E','E'}};
        boolean isExist = wordSearch.exist(board, "ABCCED");
        System.out.println(isExist);
    }
}
