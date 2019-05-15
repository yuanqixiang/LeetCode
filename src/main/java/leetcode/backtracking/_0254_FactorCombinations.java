package leetcode.backtracking;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/*
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 * Note:
 *
 * Each combination's factors must be sorted ascending, for example:
 * The factors of 2 and 6 is [2, 6], not [6, 2].
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 *
 *
 * Examples:
 * input: 1
 * output:
 * []
 *
 * input: 37
 * output:
 * []
 *
 * input: 12
 * output:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 *
 * input: 32
 * output:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 *
 */
public class _0254_FactorCombinations {
    public List<List<Integer>> factorCombine(int n) {
        List<List<Integer>> res = new LinkedList<>();
        helper(n, 2, 1, new LinkedList<>(), res);
        return res;
    }

    private void helper(int n, int start, int product, List<Integer> list, List<List<Integer>> res) {
        if(start > n || product > n) return;
        if (product == n) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < n; ++i) {
            if (i * product > n) break;
            if (n % i == 0) {
                list.add(i);
                helper(n, i, i * product, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int n = 12;
        List<List<Integer>> res = factorCombine(n);
        res.forEach(System.out::println);
    }
 }
