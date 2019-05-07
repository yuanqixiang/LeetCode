package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

public class _0560_SubarraySumEqualsK {
    public int solutionUsingBruteForce(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; ++i) {
            int sum = 0;
            for(int j = i; j < nums.length; ++j) {
                sum += nums[j];
                if(sum == k)
                    count++;
            }
        }
        return count;
    }


    public int solutionUsingMap(int[] nums, int target) {
        int count = 0, sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (preSum.containsKey(sum - target))
                count += preSum.get(sum - target);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
