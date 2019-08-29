package leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 * Given an array nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 */
public class _0239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n;
        if(nums == null || (n = nums.length) == 0) return new int[0];
        //结果数组的长度是n - k + 1。
        int[] res = new int[n - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; ++i) {
            //i >= k时，说明窗口向右移动了一格，将窗口最左端的数字除去。
            if(i >= k) queue.remove(nums[i - k]);
            //新加入窗口的元素进入优先级队列
            queue.offer(nums[i]);
            //queue中最前端数字就是最大元素
            if(i + 1 >= k) res[i + 1 - k] = queue.peek();
        }
        return res;
    }

    public int[] solutionUsingDeque(int[] nums, int k) {
        int n;
        if(nums == null || (n = nums.length) == 0) return new int[0];
        //结果数组的长度是n - k + 1。
        int[] res = new int[n - k + 1];
        LinkedList<Integer> deque = new LinkedList<>();

        for(int i = 0; i < n; ++i) {
            // 每当新数进来时，如果发现队列头部的数的下标是窗口最左边数的下标，则扔掉
            if (!deque.isEmpty() && deque.peekFirst() == i - k) deque.poll();
            // 把队列尾部所有比新数小的都扔掉，保证队列是降序的
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.removeLast();
            // 加入新数
            deque.offerLast(i);
            // 队列头部就是该窗口内第一大的
            if (i + 1 >= k) res[i + 1 - k] = nums[deque.peek()];
        }
        return res;
    }
}
