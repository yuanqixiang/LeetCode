package leetcode.tree;

import leetcode.dataStructures.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 *
 *      1、The root is the maximum number in the array.
 *      2、The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 *      3、The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 *
 */
public class _0654_MaximumBinaryTree {
    public TreeNode solution(int[] nums){
        return constructMaximumBinaryTree0(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree0(int[] nums, int start, int end){
        if(start == end)
            return new TreeNode(nums[start]);
        else if(start < end) {
            int maxIndex = start, max = nums[start];
            for (int i= start; i <= end; ++i) {
                if(nums[i] > max) {
                    max = nums[i];
                    maxIndex = i;
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = constructMaximumBinaryTree0(nums, start, maxIndex - 1);
            root.right = constructMaximumBinaryTree0(nums, maxIndex + 1, end);
            return root;
        }
        return null;
    }

    public TreeNode solutionUsingDeque(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for (int num : nums) {
            TreeNode curr = new TreeNode(num);
            while (!stack.isEmpty() && stack.peek().val < num) {
                curr.left = stack.pop();
            }
            if (!stack.isEmpty())
                stack.peek().right = curr;
            stack.push(curr);
        }
        return stack.isEmpty() ? null : stack.removeLast();
    }
}
