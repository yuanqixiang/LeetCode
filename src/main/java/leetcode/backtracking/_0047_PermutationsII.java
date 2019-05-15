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

        //当我们枚举第start个位置的元素时，若要把后面第i个元素和start交换，
        //则先要保证[start…i-1]范围内没有和位置i相同的元素。具体实现可以在每次需要交换时进行顺序查找。
        //hasDuplicate返回true，意味着i之前存在一个元素和nums[i]相等
        //例如，[1，2，2]，1和第一个2可以交换，但是对于第二个2，之前存在一个相等的2已经和1交换过，所以这一个2不需要和1交换
        for (int i = start; i < nums.length; ++i) {
            if(i == start || !hasDuplicate(nums, start, i)) {
                swap(nums, i, start);
                dfs(nums, start + 1, res);
                swap(nums, i, start);
            }
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
        int[] nums = new int[] {2, 2, 3};
        List<List<Integer>> res = solutionUsingSwap(nums);
        res.forEach(System.out::println);
    }
}
