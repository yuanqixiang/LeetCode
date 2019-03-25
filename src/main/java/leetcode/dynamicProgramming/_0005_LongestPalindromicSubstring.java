package leetcode.dynamicProgramming;

public class _0005_LongestPalindromicSubstring {
   /*
    * DP:
    * 维护一个二维数组dp，其中dp[i][j]表示字符串区间[i, j]是否为回文串，
    * 当i = j时，只有一个字符，肯定是回文串，如果i = j + 1，说明是相邻字符，
    * 此时需要判断s[i]是否等于s[j]，如果i和j不相邻，即i - j >= 2时，
    * 除了判断s[i]和s[j]相等之外，dp[j + 1][i - 1]若为真，就是回文串，通过以上分析，可以写出递推式如下：
    *
    *     dp[i, j] = 1                                       if i == j
    *
    *              = (s[i] == s[j])                          if j = i + 1
    *
    *              = (s[i] == s[j]) && (dp[i + 1][j - 1])    if j > i + 1
    */
    public String solutionUsingDP(String s){
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[j + 1][i - 1]);
                if (dp[j][i] && (res.equals("") || i - j + 1 > res.length()))
                    res = s.substring(j, i + 1);
            }
        }
        return res;
    }

    /*
     * solution 2:
     * 以某个元素为中心，分别计算偶数长度的回文最大长度和奇数长度的回文最大长度。时间复杂度O(n^2)，空间O（1）
     */
    private int low = 0;
    private int maxLen = 0;
    public String solutionUsingHelper(String s){
        int n = s.length();
        if(n < 2) return s;
        for (int i = 0; i < n; i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return s.substring(low, low + maxLen);
    }

    private void helper(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if(maxLen < j - i - 1){
            low = i - 1;
            maxLen = j - i - 1;
        }
    }
}
