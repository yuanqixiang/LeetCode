package leetcode.dynamicProgramming;

/*
 * There is an array with strings consisting of only 0s and 1s.
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s.
 * Each 0 and 1 can be used at most once.
 *
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 *
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s,
 * which are "10", "0001", "1", "0".
 *
 * Also 0-1 knapsack problem.
 */
public class _0474_OnesAndZeros {
    public int solutionUsing3DArrays(String[] strs, int m, int n){
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for(int i = 0; i <= m; ++i){
            for(int j = 0; j <= n; ++j){
                dp[0][i][j] = 0;
            }
        }
        for(int i = 1; i <= len; ++i){
            int ones = count(strs[i - 1], '1');
            int zeros = count(strs[i - 1], '0');
            for(int j = 0; j <= m; ++j){
                for(int k = 0; k <= n; ++k){
                    if(zeros <= j && ones <= k)
                        dp[i][j][k] = Math.max(dp[i - 1][j - zeros][k - ones] + 1, dp[i - 1][j][k]);
                    else
                        dp[i][j][k] = dp[i - 1][j][k];
                }
            }
        }
        return dp[len][m][n];
    }

    public int solutionUsing2DArrays(String[] strs, int m, int n){
        int[][] dp = new int[m + 1][n + 1];
        for(String str : strs){
            int zeros = count(str, '0');
            int ones = count(str, '1');
            for(int i = m; i >= zeros; --i){
                for(int j = n; j >= ones; --j){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int count(String s, char ch){
        int sum = 0;
        for(char c : s.toCharArray())
            if(c == ch)
                sum++;
        return sum;
    }
}
