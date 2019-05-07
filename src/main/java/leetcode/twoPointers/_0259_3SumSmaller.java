package leetcode.twoPointers;

import java.util.Arrays;

/*
 * Given an array of n integers nums and a target, find the number of index triplets i, j, k,
 * with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 *
 * Return 2.
 * Because there are two triplets which sums are less than 2:
 *
 * [-2, 0, 1]
 * [-2, 0, 3]
 *
 * Follow up:
 * Could you solve it in O(n2) runtime?
 */
public class _0259_3SumSmaller {
    public int solution(int[] nums, int target) {
        int length = nums.length;
        if(nums.length < 3) return 0;
        int result = 0;
        int low = 0, high = 0;

        Arrays.sort(nums);
        for(int i = 0; i < length - 2; ++i) {
            low = i + 1;
            high = length - 1;
            while (low < high) {
                int temp = nums[i] + nums[low] + nums[high];
                if(temp < target) {
                    // 这里面有个trick就是当判断三个数之和小于目标值时，此时结果应该加上right-left，
                    // 因为数组排序了以后，如果加上num[right]小于目标值的话，那么加上一个更小的数必定也会小于目标值，
                    result += high - low;
                    low++;
                } else
                    high--;
            }
        }

        return result;
    }
}
