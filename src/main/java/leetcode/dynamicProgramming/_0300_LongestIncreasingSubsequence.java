package leetcode.dynamicProgramming;

import java.util.LinkedList;

/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 */
public class _0300_LongestIncreasingSubsequence {
    public int LISUsingDP(int[] nums){
        int n = nums.length;
        if(n == 0 || n == 1) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLen = 1;
        int res = 1;
        for(int i = 1; i < n; ++i){
            int tempMax = 0;
            for(int j = i - 1; j >= 0; --j){
                if (nums[i] > nums[j])
                    tempMax = Math.max(tempMax, dp[j]);
            }
            dp[i] = tempMax + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int LISUsingBinarySearch(int[] nums){
        int n = nums.length;
        if(n == 0 || n == 1)
            return n;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(nums[0]);
        for (int num : nums) {
            if (num < list.get(0))
                list.set(0, num);
            else if (num > list.getLast())
                list.add(num);
            else {
                int start = 0, end = list.size();
                while (start < end) {
                    int mid = start + (end - start) / 2;
                    if (list.get(mid) < num)
                        start = mid + 1;
                    else
                        end = mid;
                }
                list.set(end, num);
            }
        }
        return list.size();
    }
}
