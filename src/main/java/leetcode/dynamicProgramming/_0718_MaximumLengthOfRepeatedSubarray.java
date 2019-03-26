package leetcode.dynamicProgramming;

/*
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 * 因为是子数组问题，所以：
 * 1、dp[i][j]: 以A[i]和B[j]结尾的公共子数组的长度。
 * 2、if(A[i] == B[j]) dp[i][j] = 1 + dp[i - 1][j - 1]
 * 3、else dp[i][j] = 0;
 */
public class _0718_MaximumLengthOfRepeatedSubarray {

    public int solutionUsing2DArray(int[] A, int[] B){
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for(int i = 0; i <= m; ++i){
            for(int j = 0; j <= n; ++j){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
    /*
     * space optimization
     * 对于二维数组的递推公式，如果dp[i][j] 与dp[i - 1][j]相关，
     * 在优化的时候，需要考虑逆序，否则顺序迭代的时候会有值的覆盖
     */
    public int solutionUsing1DArray(int[] A, int[] B){
        int m = A.length, n = B.length;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int a : A)
            for (int j = n - 1; j >= 0; j--) {
                dp[j + 1] = a == B[j] ? 1 + dp[j] : 0;
                max = Math.max(max, dp[j + 1]);
            }
        return max;
    }
}
