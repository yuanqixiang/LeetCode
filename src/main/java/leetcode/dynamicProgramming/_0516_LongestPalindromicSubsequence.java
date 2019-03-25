package leetcode.dynamicProgramming;

/*
 * dp[i][j]: length of longest palindromic subsequence ranges at[i, j].
 * dp[i][i] = 1.
 * if s[i] = s[j]: dp[i][j] = dp[i + 1][j - 1] + 2;
 * if s[i] != s[j]: dp[i][j] = max(dp[i][j - 1], dp[i + 1][j]);
 *
 * Notice that the length of range[i, j] should be ascending.
 */
public class _0516_LongestPalindromicSubsequence {
    public int solutionUsingDP(String s){
        int n;
        if(s == null || (n = s.length()) == 0)
            return 0;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; ++i)
            dp[i][i] = 1;

        for(int len = 2; len <= n; ++len){   //the length of range[i, j] should be ascending.
            for(int start = 0; start < n - len + 1; ++start){
                int end = start + len - 1;
                if(s.charAt(start) == s.charAt(end)){
                    dp[start][end] = dp[start + 1][end - 1] + 2;
                } else {
                    dp[start][end] = Math.max(dp[start][end - 1], dp[start + 1][end]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
