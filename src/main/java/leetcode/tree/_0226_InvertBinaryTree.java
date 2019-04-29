package leetcode.tree;

import leetcode.dataStructures.TreeNode;

import java.util.Stack;

/*
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class _0226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode solutionUsingIteration(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }
        return root;
    }
}
