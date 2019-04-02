package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _0022_GenerateParentheses {
    public List<String> solution(int m){
        List<String> res = new LinkedList<>();
        helper(res, "", m, 0);
        return res;
    }

    private void helper(List<String> res, String str, int m, int n){
        if(m == 0 && n == 0){
            res.add(str);
            return;
        }
        if(m > 0)
            helper(res, str + '(',  m - 1, n + 1);
        if(n > 0)
            helper(res, str + ')',  m, n - 1);
    }

    public List<String> solution2(int n){
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max * 2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if(close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }
}
