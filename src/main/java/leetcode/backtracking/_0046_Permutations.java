package leetcode.backtracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a collection of distinct integers, return all possible permutations.
 */
public class _0046_Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(nums, new LinkedList<>(), res);
        return res;
    }

    private static void helper(int[] nums, List<Integer> list, List<List<Integer>> res){
        if(list.size() == nums.length){
            res.add(new LinkedList<>(list));
            return;
        }
        for(int num : nums){
            if(list.contains(num))
                continue;
            list.add(num);
            helper(nums, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> solutionUsingSwap(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        for (int a : nums)
            list.add(a);
        dfs(list, 0, res);
        return res;
    }

    private static void dfs(List<Integer> list, int start, List<List<Integer>> res) {
        if(start >= list.size()){
            res.add(new LinkedList<>(list));
        }
        for (int i = 0; i < list.size(); ++i) {
            Collections.swap(list, i, start);
            dfs(list, start + 1, res);
            Collections.swap(list, i, start);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> res = solutionUsingSwap(nums);
        res.forEach(System.out::println);
    }
}
