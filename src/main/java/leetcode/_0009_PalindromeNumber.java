package leetcode;

import java.util.Stack;

/*
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 * 121: true
 * -121: false
 * 10: false
 */
public class _0009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        int t = x;
        if(t < 0)
            return false;
        int result = 0;
        while(t / 10 != 0){
            result = result * 10 + t % 10;
            t /= 10;
        }
        result = result * 10 + t;
        return result == x;
    }

    boolean solution2(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        int sum = 0;
        while(x > sum) {
            sum = sum * 10 + x % 10;
            x = x / 10;
        }
        return x == sum || x == sum / 10;
    }
}
