/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Subscribe to see which companies asked this question.

*/

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
      map<char, int> m;
      int maxLen = 0;
      int start = -1;
      for(int i = 0; i < s.size(); ++i)
      {
          if(m.count(s[i]) != 0)
          {
              start = max(start, m[s[i]]);
          }
          
          m[s[i]] = i;
          maxLen = max(maxLen, i - start);
      }
      return maxLen;
    }
};
