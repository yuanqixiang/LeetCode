package leetcode.tree.treeDepth;

import leetcode.dataStructures.TreeNode;

/*
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 */
public class _0111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null)
            return 1;
        if(root.left != null && root.right != null)
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        return 1 + minDepth(root.left != null ? root.left : root.right);
    }

    private int minD = Integer.MAX_VALUE;
    public int minDepth2(TreeNode root) {
        if(root == null)
            return 0;
        minDepth0(root, 1);
        return minD;
    }

    private void minDepth0(TreeNode root, int depth) {
        if(root == null) return;
        if(root.left == null && root.right == null){
            minD = Math.min(depth, minD);
            return;
        }

        minDepth0(root.left, depth + 1);
        minDepth0(root.right, depth + 1);
    }
}
