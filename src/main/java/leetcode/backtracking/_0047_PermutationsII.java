package leetcode.backtracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1, 1, 2]
 * Output:
 * [
 *   [1, 1, 2],
 *   [1, 2, 1],
 *   [2, 1, 1]
 * ]
 *
 */
public class _0047_PermutationsII {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        doPermute(nums, new LinkedList<>(), res, new boolean[nums.length]);
        return res;
    }

    private void doPermute(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] used) {
        if(list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }

        for(int i = 0; i < nums.length; ++i) {
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            list.add(nums[i]);
            used[i] = true;
            doPermute(nums, list, res, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        helper(nums, new LinkedList<>(), res, new boolean[nums.length]);
        return res;
    }

    private static void helper(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] used){
        if(list.size() == nums.length){
            res.add(new LinkedList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; ++i){
            if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            list.add(nums[i]);
            used[i] = true;
            helper(nums, list, res, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> solutionUsingSwap(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        dfs(nums, 0, res);
        return res;
    }

    private static void dfs(int[] nums, int start, List<List<Integer>> res) {
        if(start == nums.length){
            List<Integer> list = new LinkedList<>();
            for (int a : nums) list.add(a);
            res.add(list);
            return;
        }
        for (int i = start + 1; i < nums.length - 1; ++i) {
            if(hasDuplicate(nums, start, i)) {
                continue;
            }
            swap(nums, i, start);
            dfs(nums, start + 1, res);
            swap(nums, i, start);
        }
    }

    private static boolean hasDuplicate(int[] nums, int start, int end) {
        for(int i = start; i < end; i++) {
            if(nums[i] == nums[end]) return true;
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        List<List<Integer>> res = solutionUsingSwap(nums);
        res.forEach(System.out::println);
    }
}