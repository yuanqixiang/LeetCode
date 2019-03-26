package leetcode.dynamicProgramming;

import java.util.Arrays;

/*
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * 完全背包问题
 */
public class _0322_CoinChange {

    public int solutionUsingDp(int[] coins, int amount){
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 1; i <= amount; ++i){
            int min = Integer.MAX_VALUE;
            for(int j = n - 1; j >= 0; --j){
                int r = i - coins[j];
                if(r >= 0 && dp[r] >= 0){
                    min = Math.min(min, dp[r]);
                }
            }
            if(min == Integer.MAX_VALUE) continue;
            dp[i] = min + 1;
        }
        return dp[amount];
    }
}
