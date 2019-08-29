package leetcode;

/*
 * Given an unsorted array of integers,
 * find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
 * Therefore its length is 4.
 */


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class _0128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int longest = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                int currentLongest = 1;
                int current = num;
                while (set.remove(current - 1))
                    --current;
                currentLongest += num - current;

                current = num;
                while (set.remove(current + 1))
                    ++current;
                currentLongest += current - num;
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }

    @Test
    public void test() {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        _0128_LongestConsecutiveSequence solution = new _0128_LongestConsecutiveSequence();
        System.out.println(solution.longestConsecutive(nums));
    }
}
