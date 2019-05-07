package leetcode.twoPointers;

import java.util.Arrays;

/*
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */
public class _0016_3SumClosest {
    public int solutionUsingTwoPointers(int[] nums, int target) {
        int length = nums.length;
        if(nums.length < 3) return 0;
        int closet = nums[0] + nums[1] + nums[2];
        int low, high;

        Arrays.sort(nums);
        for(int i = 0; i < length - 2; ++i) {
            low = i + 1;
            high = length - 1;
            while (low < high) {
                int temp = nums[i] + nums[low] + nums[high];
                if(temp == target) return target;
                if(Math.abs(closet - target) > Math.abs(temp - target))
                    closet = temp;
                if(temp > target)
                    high--;
                else
                    low++;
            }
        }

        return closet;
    }
}
