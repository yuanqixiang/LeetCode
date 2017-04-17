/*
DP:
维护一个二维数组dp，其中dp[i][j]表示字符串区间[i, j]是否为回文串，
当i = j时，只有一个字符，肯定是回文串，如果i = j + 1，说明是相邻字符，
此时需要判断s[i]是否等于s[j]，如果i和j不相邻，即i - j >= 2时，
除了判断s[i]和s[j]相等之外，dp[j + 1][i - 1]若为真，就是回文串，通过以上分析，可以写出递推式如下：

dp[i, j] = 1                 if i == j

         = (s[i] == s[j])    if j = i + 1

         = (s[i] == s[j]) && (dp[i + 1][j - 1])    if j > i + 1      
*/

class Solution {
public:
    string longestPalindrome(string s) 
    {
        int dp[s.size()][s.size()] = {0};
        int left = 0, right = 0, len = 0;
        for(int i = 0; i < s.size(); ++i)
        {
            for(int j = 0; j < i; ++j)
            {
                dp[j][i] = s[i] == s[j] && ((i - j) == 1 || dp[j + 1][i - 1]); 
                if(dp[j][i] && len < i - j + 1)
                {
                    left = j;
                    right = i;
                    len = right - left + 1;
                }
            }
            dp[i][i] = 1;
        }
        return s.substr(left, right - left + 1);
    }
};


/*
以某个元素为中心，分别计算偶数长度的回文最大长度和奇数长度的回文最大长度。时间复杂度O(n^2)，空间O（1）
*/
class Solution {
public:
    string longestPalindrome(string s) {
        const int len = s.size();
        if(len <= 1)return s;
        int start, maxLen = 0;
        for(int i = 1; i < len; i++)
        {
            //寻找以i-1,i为中点偶数长度的回文
            int low = i-1, high = i;
            while(low >= 0 && high < len && s[low] == s[high])
            {
                low--;
                high++;
            }
            if(high - low - 1 > maxLen)
            {
                maxLen = high - low -1;
                start = low + 1;
            }
             
            //寻找以i为中心的奇数长度的回文
            low = i- 1; high = i + 1;
            while(low >= 0 && high < len && s[low] == s[high])
            {
                low--;
                high++;
            }
            if(high - low - 1 > maxLen)
            {
                maxLen = high - low -1;
                start = low + 1;
            }
        }
        return s.substr(start, maxLen);
    }
};
