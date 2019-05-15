package leetcode.hashTable;

import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/*
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 *
 * Hint:
 *
 * Consider the palindromes of odd vs even length. What difference do you notice?
 * Count the frequency of each character.
 * If each character occurs even number of times, then it must be a palindrome.
 * How about character which occurs odd number of times?
 *
 */
public class _0266_PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (Character c : s.toCharArray()) {
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }

        return set.size() <= 1;
    }

    public boolean solutionUsingBitSet(String s) {
        BitSet bitSet = new BitSet(256);
        for (Character c : s.toCharArray()) {
            bitSet.flip(c);
        }

        return bitSet.cardinality() < 2;
    }

    @Test
    public void test() {
        boolean res = solutionUsingBitSet("carerac");
        Assert.assertTrue(res);

        res = solutionUsingBitSet("codedoc");
        Assert.assertTrue(res);
    }
}
