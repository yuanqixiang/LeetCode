package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    /*
     *核心思想：遍历整个字符串的时候，需要记录每个字符‘最近’一次出现的索引，需要用一个Map来实现，
     *如果Map中已经存在该字符，就更新start值，
    */
    public int solutionUsingMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = -1;
        for(int i = 0; i < s.length(); ++i){
            if(map.get(s.charAt(i)) != null)
                start = Math.max(start, map.get(s.charAt(i)));
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - start);
        }
        return maxLen;
    }

    /*
     * maintain a sliding window, with its elements in a set,
     */
    public int solutionUsingSlidingWindows(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
