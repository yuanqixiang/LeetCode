package leetcode.twoPointers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 */
public class _0015_3Sum {
    public List<List<Integer>> solution(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < nums.length - 2; ++i){
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int lo = i + 1, hi = nums.length - 1, sum = -nums[i];
            while(lo < hi){
                if(nums[lo] + nums[hi] == sum){
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if(nums[lo] + nums[hi] < sum)
                    lo++;
                else
                    hi--;
            }
        }
        return res;
    }
}
