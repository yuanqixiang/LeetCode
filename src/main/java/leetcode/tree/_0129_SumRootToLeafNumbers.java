package leetcode.tree;

import leetcode.dataStructures.TreeNode;

import java.util.Stack;

/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Input: [1,2,3]
 *     1
 *    / \
 *   2   3
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 */
public class _0129_SumRootToLeafNumbers {
    private int sum = 0;
    public int solutionUsingRecursion(TreeNode root) {
        if(root == null) return sum;
        helper(root , 0);
        return sum;
    }

    private void helper(TreeNode root, int temp) {
        temp += root.val;
        if(root.left == null && root.right == null){
            sum += temp;
            return;
        }

        if(root.left != null)
            helper(root.left, temp * 10);
        if(root.right != null)
            helper(root.right, temp * 10);
    }

    public int solutionUsingStack(TreeNode root) {
        int current = 0, total = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, last = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                current *= 10;
                current += curr.val;
                curr = curr.left;
            }
            curr = stack.peek();
            if(curr.right != null && last != curr.right)
                curr = curr.right;
            else {
                last = curr;
                if (curr.right == null && curr.left == null)
                    total += current;
                stack.pop();
                current /= 10;
                curr = null;
            }
        }
        return total;
    }
}
