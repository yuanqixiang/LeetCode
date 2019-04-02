package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

public class _0046_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(nums, new LinkedList<Integer>(), res);
        return res;
    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> res){
        if(list.size() == nums.length){
            res.add(new LinkedList<>(list));
        }
        for(int num : nums){
            if(list.contains(num))
                continue;
            list.add(num);
            helper(nums, list, res);
            list.remove(list.size() - 1);
        }
    }
}
