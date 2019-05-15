package leetcode.backtracking;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 *
 * For example:
 *
 * Given s = "aabb", return ["abba", "baab"].
 *
 * Given s = "abc", return [].
 *
 * Hint:
 *
 * 1、If a palindromic permutation exists, we just need to generate the first half of the string.
 * 2、To generate all distinct permutations of a (half of) string,
 * use a similar approach from: Permutations II or Next Permutation.
 */
public class _0267_PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> t = new LinkedList<>();
        StringBuilder mid = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char cha = entry.getKey();
            int count = entry.getValue();
            if (count % 2 == 1) mid.append(cha);
            for (int i = 0; i < count / 2; ++i) t.add(cha);
            if (mid.length() > 1) return res;
        }

        t.forEach(System.out::print);
        System.out.println();
        System.out.println(mid);
        permute(t, new StringBuilder(), new boolean[t.size()], mid.toString(), res);
        return res;
    }

    private void permute(List<Character> t, StringBuilder temp, boolean[] used, String mid, List<String> res) {
        if (temp.length() == t.size()) {
            res.add(temp.toString() + mid + temp.reverse());
            temp.reverse();
            return;
        }

        for (int i = 0; i < t.size(); ++i) {
            if (i > 0 && t.get(i) == t.get(i - 1) && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                temp.append(t.get(i));
                permute(t, temp, used, mid, res);
                used[i] = false;
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    @Test
    public void test() {
        String s = "aabbccc";
        List<String> res = generatePalindromes(s);
        res.forEach(System.out::println);
    }
}
