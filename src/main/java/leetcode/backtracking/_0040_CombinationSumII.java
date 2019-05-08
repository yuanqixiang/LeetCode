package leetcode.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class _0040_CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        //for (int a : candidates) {
        //    System.out.print(a);
        //}
        //System.out.println();
        helper(candidates, new LinkedList<Integer>(), res, 0, target);
        return res;
    }

    private static void helper(int[] nums, List<Integer> list, List<List<Integer>> res, int start, int remain){
        if(remain < 0) return;
        if(remain == 0){
            res.add(new LinkedList<>(list));
            return;
        }
        for(int i = start; i < nums.length; ++i){
            if(i > start && nums[i] == nums[i - 1]){
                //System.out.println("i:" + i + " num: " + nums[i]);
                continue;
            }
            list.add(nums[i]);
            //list.forEach(System.out::print);
            //System.out.println();
            helper(nums, list, res, i + 1, remain - nums[i]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 1, 2, 7, 6, 1, 5};
        int target = 8;
        combinationSum2(nums, target);
    }
}
