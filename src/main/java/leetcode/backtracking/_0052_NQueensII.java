package leetcode.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * the same as no.51, but return the number of solutions.
 */
public class _0052_NQueensII {
    private int N;
    private int[] arr;   //arr[i] = j <==> there is a queue at row i col j.
    private int count;

    public int totalNQueens(int n) {
        N = n;
        arr = new int[n];
        helper(0);
        return count;
    }

    private void helper(int row) {
        if(row == N) {
            ++count;
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

    public static void main(String[] args) {
        _0052_NQueensII nQueens = new _0052_NQueensII();
        int count = nQueens.totalNQueens(4);
        System.out.println(count);;
    }
}
