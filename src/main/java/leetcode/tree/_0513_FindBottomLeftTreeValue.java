package leetcode.tree;

import leetcode.dataStructures.TreeNode;

import java.util.LinkedList;

/*
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output: 1
 *
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output: 7
 *
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 *
 */
public class _0513_FindBottomLeftTreeValue {
    /*
     * level traversal,and from right to left.
     */
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.push(root);
        TreeNode leftMost = root;
        while (!list.isEmpty()) {
            TreeNode curr = list.removeFirst();
            if (curr.right != null) {
                leftMost = curr.right;
                list.add(curr.right);
            }
            if (curr.left != null) {
                leftMost = curr.left;
                list.add(curr.left);
            }
        }
        return leftMost.val;
    }
}
