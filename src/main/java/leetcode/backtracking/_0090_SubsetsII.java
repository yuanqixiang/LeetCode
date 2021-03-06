package leetcode.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _0090_SubsetsII {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        helper(nums, new LinkedList<>(), res, 0);
        return res;
    }

    private static void helper(int[] nums, List<Integer> list, List<List<Integer>> res, int pos){
        res.add(new LinkedList<>(list));
        for(int i = pos; i < nums.length; ++i){
            if(i > pos && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            helper(nums, list, res, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
