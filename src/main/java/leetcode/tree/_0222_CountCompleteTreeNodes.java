package leetcode.tree;

import leetcode.dataStructures.TreeNode;

/*
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Example:
 *
 * Input:
 *      1
 *    /  \
 *   2    3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 */
public class _0222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int nodes = 0, h = height(root);
        TreeNode curr = root;
        while (curr != null) {
            if (height(curr.right) == h - 1) {
                nodes += 1 << h - 1;
                curr = curr.right;
            } else {
                nodes += 1 << h - 2;
                curr = curr.left;
            }
            h--;
        }
        return nodes;
    }

    private int height(TreeNode root) {
        return root == null ? 0 : 1 + height(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        _0222_CountCompleteTreeNodes instance = new _0222_CountCompleteTreeNodes();
        int nodes = instance.countNodes(root);
        System.out.println(nodes);
    }
}
