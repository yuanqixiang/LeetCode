package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class _0078_Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(nums, new LinkedList<Integer>(), res, 0);
        return res;
    }

    private static void helper(int[] nums, List<Integer> list, List<List<Integer>> res, int pos){
        res.add(new LinkedList<>(list));
        for(int i = pos; i < nums.length; ++i){
            list.add(nums[i]);
            helper(nums, list, res, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        List<List<Integer>> res = subsets(nums);
        res.stream().forEach(System.out::println);
    }
}
