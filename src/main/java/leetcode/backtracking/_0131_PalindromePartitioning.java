package leetcode.backtracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class _0131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        helper(s, res, new LinkedList<>(), 0);
        return res;
    }

    private void helper(String s, List<List<String>> res, List<String> list, int start) {
        if(start == s.length()) {
            res.add(new LinkedList<>(list));
            return;
        }

        for (int i = start; i < s.length(); ++i) {
            if (isPalindromic(s, start, i)) {
                if (start == i)
                    list.add(Character.toString(s.charAt(i)));
                else
                    list.add(s.substring(start, i + 1));
                helper(s, res, list, i + 1);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isPalindromic(String s, int start, int end) {
        if(start == end) return true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    @Test
    public void test() {
        List<List<String>> res = partition("aabccba");
        res.forEach(System.out::println);
    }

}
