package leetcode.dynamicProgramming;

/*
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 * 完全背包问题
 */
public class _0518_CoinChange2 {

    public int solutionUsing2DArray(int[] coins, int amount){
        int m = coins.length;
        int[][] dp = new int[m + 1][amount + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= amount; ++i)
            dp[0][i] = 0;
        for(int i = 1; i <= m; ++i)
            dp[i][0] = 1;

        for(int i = 1; i <= m; ++i){
            for(int j = 0; j <= amount; ++j){
                if(j >= coins[i - 1])
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[m][amount];
    }

    public int solutionUsing1DArray(int[] coins, int amount){
        int m = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for(int coin : coins){
            for(int j = coin; j <= amount; ++j){
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
