package leetcode.slidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 *
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 */
public class _0076_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if(sLen == 0 || tLen == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < tLen; ++i)
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);

        //print
        map.entrySet().forEach(System.out::println);

        int l = 0, r = 0;
        int required = map.size();
        Map<Character, Integer> windowsCount = new HashMap<>();
        int[] ans = {-1, 0, 0};
        int formed = 0;
        while(r < sLen) {
            char c = s.charAt(r);
            windowsCount.put(c, windowsCount.getOrDefault(c, 0) + 1);
            if(map.containsKey(c) && windowsCount.get(c).equals(map.get(c))) formed++;

            while( l <= r && formed == required) {
                c = s.charAt(l);
                if(ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowsCount.put(c, windowsCount.get(c) - 1);
                if(map.containsKey(c) && windowsCount.get(c) < map.get(c)) --formed;
                ++l;
            }
            ++r;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public String minWindow3(String s, String t) {
        int begin = 0, end = 0, cnt = t.length();
        int maxLen = s.length() + 1;
        int []count = new int [128];
        String result = "";
        //用数组记录t串字符出现的次数
        for(int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }

        while(end < s.length()) {
            char curr = s.charAt(end);
            count[curr]--;
            if(count[curr] >= 0) --cnt;

            while (begin <= end && count[s.charAt(begin)] < 0) {
                count[s.charAt(begin)]++;
                ++begin;
            }

            if (cnt == 0 && maxLen > end - begin + 1) {
                maxLen = end - begin + 1;
                result = s.substring(begin, end + 1);
            }
            end++;
        }
        return result;
    }

    @Test
    public void test() {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow3(s, t));
    }

}
