package leetcode.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 *
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */
public class _0039_CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        helper(candidates, new LinkedList<>(), res, 0, target);
        return res;
    }

    private static void helper(int[] nums, List<Integer> list, List<List<Integer>> res, int start, int remain){
        if(remain < 0) return;
        if(remain == 0){
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < nums.length; ++i) {
            list.add(nums[i]);
            helper(nums, list, res, i, remain - nums[i]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        int target = 7;
        combinationSum(nums, target);
    }
}
