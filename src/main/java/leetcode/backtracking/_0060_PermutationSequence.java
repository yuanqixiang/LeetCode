package leetcode.backtracking;

import java.util.LinkedList;
import java.util.List;

/*
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 *
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 *
 * Example 1:
 *
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 *
 */
public class _0060_PermutationSequence {
    public String solution(int n, int k) {
        List<Integer> numbers = new LinkedList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        int sum = 1;
        factorial[0] = sum;
        for(int i = 1; i <= n; ++i) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        for (int i = 1; i <= n; ++i)
            numbers.add(i);
        // numbers = {1, 2, 3, 4}

        k--;

        for (int i = 1; i <= n; ++i) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k = k - index * factorial[n - i];
        }

        return  sb.toString();
    }

    public static void main(String[] args) {
        _0060_PermutationSequence permutationSequence = new _0060_PermutationSequence();
        String str = permutationSequence.solution(4, 14);
        System.out.println(str);
    }

}
