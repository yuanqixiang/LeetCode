package leetcode.tree;

import leetcode.dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class _0113_PathSumII {
    public List<List<Integer>> solutionUsingRecursion(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        helper(root, sum, new LinkedList<Integer>(), res);
        return res;
    }

    private void helper(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res) {
        if(root == null) return;
        temp.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new LinkedList<>(temp));
            return;
        }
        if(root.left != null){
            helper(root.left, sum - root.val, temp, res);
            temp.remove(temp.size() - 1);
        }
        if(root.right != null){
            helper(root.right, sum - root.val, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> solutionUsingIteration (TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, last = null;
        int amt = 0;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null){
                stack.push(curr);
                temp.add(curr.val);
                amt += curr.val;
                curr = curr.left;
            }
            curr = stack.peek();
            if(curr.right != null && last != curr.right)
                curr = curr.right;
            else {
                if(curr.left == null && curr.right == null && amt == sum)
                    res.add(new LinkedList<Integer>(temp));

                last = curr;
                stack.pop();
                temp.remove(temp.size()-1);
                amt -= curr.val;
                curr = null;
            }
        }
        return res;
    }
}
