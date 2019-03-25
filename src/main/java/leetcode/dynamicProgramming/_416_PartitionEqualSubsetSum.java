package leetcode.dynamicProgramming;

import java.util.Arrays;

/*
 * Description:
 *      Given a non-empty array containing only positive integers,
 *      find if the array can be partitioned into two subsets
 *      such that the sum of elements in both subsets is equal.
 * Analysis:
 *      0-1 背包: 对于一个数组，选择几个数使sum = sum(all elements)
 */
public class _416_PartitionEqualSubsetSum {
    public boolean dpSolutionUsing2DArray(int[] nums){
        int sum = 0;
        for(int num : nums)
            sum += num;
        if((sum & 0x01) == 1)
            return false;

        sum /= 2;
        int m = nums.length;
        boolean[][] dp = new boolean[m + 1][sum + 1];
        for(int i = 0; i <= m; ++i)
            Arrays.fill(dp[i], false);
        for(int i = 0; i <= m; ++i)
            dp[i][0] = true;
        for(int i = 1; i <= sum; ++i)
            dp[0][i] = false;

        for(int i = 1; i <= m; ++i){
            for(int j = 1; j <= sum; ++j){
                dp[i][j] = dp[i - 1][j];
                if(nums[i - 1] <= j)
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[m][sum];
    }
}
