package leetcode.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class _0051_NQueens {
    private int N;
    private int[] arr;   //arr[i] = j <==> there is a queue at row i col j.
    private List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        N = n;
        arr = new int[n];
        helper(0);
        return res;
    }

    private void helper(int row) {
        if(row == N) {
            print();
            return;
        }

        for (int i = 0; i < N; ++i) {
            if(check(row, i)) {
                arr[row] = i;
                helper(row + 1);
            }
        }
    }

    private boolean check(int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (arr[i] == col || Math.abs(row  - i) == Math.abs(col - arr[i]))
                return false;
        }
        return true;
    }

    private void print() {
        List<String> temp = new LinkedList<>();
        for (int i = 0; i < N; ++i) {
            char[] chs = new char[N];
            Arrays.fill(chs, '.');
            chs[arr[i]] = 'Q';
            temp.add(String.valueOf(chs));
        }
        res.add(temp);
    }

    public static void main(String[] args) {
        _0051_NQueens nQueens = new _0051_NQueens();
        List<List<String>> res = nQueens.solveNQueens(4);
        res.forEach(System.out::println);
    }
}
