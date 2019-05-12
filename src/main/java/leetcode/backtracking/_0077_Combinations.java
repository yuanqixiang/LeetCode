package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/*
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 */
public class _0077_Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        doCombine(n, k, new LinkedList<>(), res, 1);
        return res;
    }

    private static void doCombine(int n, int k, List<Integer> list, List<List<Integer>> res, int start) {
        if(k == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        //这里的优化点是剪枝，i <= n - k + 1，而不是i <= n，
        //从n个数中选取k个，第一个数从1到n-k+1
        for(int i = start; i <= n - k + 1; ++i) {
            //System.out.println("k = " + k);
            //System.out.println("start = " + start + ", stop = " + (n - k + 1));
            list.add(i);
            doCombine(n, k - 1, list, res, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5, k = 2;
        List<List<Integer>> res = combine(n, k);
    }
}
