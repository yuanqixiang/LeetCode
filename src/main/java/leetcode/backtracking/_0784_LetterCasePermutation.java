package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/*
 * Given a string S, we can transform every letter individually to be lowercase or uppercase
 * to create another string.  Return a list of all possible strings we could create.
 *
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 *
 * Input: S = "12345"
 * Output: ["12345"]
 *
 */
public class _0784_LetterCasePermutation {
    public List<String> solution(String S){
        if(S == null)
            return new LinkedList<String>();
        List<String> list = new LinkedList<>();
        helper(S.toCharArray(), list, 0);
        return list;
    }

    private void helper(char[] chs, List<String> list, int start){
        if(start == chs.length){
            list.add(new String(chs));
            return;
        }
        if(chs[start] >= '0' && chs[start] <= '9'){
            helper(chs, list, start + 1);
            return;
        }
        chs[start] = Character.toLowerCase(chs[start]);
        helper(chs, list, start + 1);

        chs[start] = Character.toUpperCase(chs[start]);
        helper(chs, list, start + 1);
    }
}
