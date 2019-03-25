package leetcode.dynamicProgramming;

/*
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 *
 */
public class _0494_TargetSum {
    private int count = 0;

    public int solutionUsingRecursion(int[] nums, int S){
        helper(nums, S, 0, nums.length);
        return count;
    }

    private void helper(int[] nums, int S, int start, int end){
        if(start < end){
            helper(nums, S - nums[start], start + 1, end);
            helper(nums, S + nums[start], start + 1, end);
        }
        if(start == end && S == 0)
            count++;
    }

    /*
     * sum(+) - sum(-) = S
     * sum(+) + sum(-) = sum(all)
     * sum(+) = [S + sum(all)] / 2;
     * pick some numbers from array nums, so that sum of them equals [S + sum(all)] / 2;
     * the same as "_0416_PartitionEqualSubsetSum": 0-1 knapsack problem.
     */
    public int dpSolutionUsing2DArray(int[] nums, int S){
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum < S) return 0;
        sum += S;
        if((sum & 1) == 1) return 0;
        sum /= 2;
        int m = nums.length;
        int[][] dp = new int[m + 1][sum + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= sum; ++i)
            dp[0][i] = 0;
        for(int i = 1; i <= m; ++i){
            for(int j = 0; j <= sum; ++j){
                dp[i][j] = dp[i - 1][j];
                if(j >= nums[i - 1])
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[m][sum];
    }

    /*
     * space optimization.
     */
    public int dpSolutionUsing1DArray(int[] nums, int S){
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum < S) return 0;
        sum += S;
        if((sum & 1) == 1) return 0;
        sum /= 2;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for(int num : nums){
            for(int j = sum; j >= num; --j){
                dp[j] += dp[j - num];
            }
        }
        return dp[sum];
    }
}
