package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/*
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 *
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class _0216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res, new LinkedList<>(), k, n, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int count, int remain, int start) {
        if(count == 0 && remain == 0) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i <= 9; ++i) {
            if(i > remain) break;
            list.add(i);
            helper(res, list, count - 1, remain - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
