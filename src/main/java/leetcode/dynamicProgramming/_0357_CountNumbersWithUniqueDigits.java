package leetcode.dynamicProgramming;

/*
 *Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 */
public class _0357_CountNumbersWithUniqueDigits {
    public int solution(int n) {
        if (n == 0) return 1;
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}
