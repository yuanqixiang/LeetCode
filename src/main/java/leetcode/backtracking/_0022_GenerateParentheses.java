package leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _0022_GenerateParentheses {
    public static List<String> solution(int m){
        List<String> res = new LinkedList<>();
        helper(res, "", m, 0);
        return res;
    }

    // m 代表还有m个‘(’没有使用，n代表目前已组成的str还需要多少个‘)’，所以刚开始调用的时候m = m, n = 0
    private static void helper(List<String> res, String str, int m, int n){
        if(m == 0 && n == 0){
            res.add(str);
            return;
        }
        if(m > 0)
            helper(res, str + '(', m - 1, n + 1);
        if(n > 0)
            helper(res, str + ')', m, n - 1);
    }

    public static List<String> solution2(int n){
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    //open代表str中含有多少个'('，close代表str中含有多少个')',max代表最多有多少个‘(’
    private static void backtrack(List<String> list, String str, int open, int close, int max){
        if(str.length() == max * 2){
            System.out.println(str);
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str + "(", open + 1, close, max);
        if(close < open)
            backtrack(list, str + ")", open, close + 1, max);
    }

    public static void main(String[] args) {
        solution2(4);
    }
}
