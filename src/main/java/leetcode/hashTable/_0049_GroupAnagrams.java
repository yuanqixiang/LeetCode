package leetcode.hashTable;

import java.util.*;

/*
 *Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 */
public class _0049_GroupAnagrams {
    public List<List<String>> solutionUsingHashMap(String[] strs){
        List<List<String>> res = new LinkedList<>();
        if(strs.length == 0) return res;
        Map<String, List<String>> ans = new HashMap<>();
        for(String s : strs){
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = String.valueOf(chs);
            if(!ans.containsKey(key))
                ans.put(key, new LinkedList<String>());
            ans.get(key).add(s);
        }
        return new LinkedList(ans.values());
    }
}
