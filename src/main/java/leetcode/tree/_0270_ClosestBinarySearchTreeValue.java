package leetcode.tree;

import leetcode.dataStructures.TreeNode;

/*
 * Given a non-empty binary search tree and a target value,
 * find the value in the BST that is closest to the target.
 *
 * Note:
 *
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 *
 */
public class _0270_ClosestBinarySearchTreeValue {
    private TreeNode res;
    private void find(TreeNode root, double target) {
        if (Math.abs(root.val - target) < Math.abs(res.val - target)) res = root;
        if (root.val < target && root.right != null) find(root.right, target);
        if (root.val > target && root.left != null) find(root.left, target);
    }

    // return TreeNode.
    public TreeNode closestValue(TreeNode root, double target) {
        if(root == null) return null;
        res = root;
        find(root, target);
        return res;
    }

    //return int value.
    public int closestValue2(TreeNode root, double target) {
        if (root.val == target) return root.val;
        if (root.val < target) {
            if (root.right == null) return root.val;
            int right = closestValue2(root.right, target);
            if (Math.abs(root.val - target) <= Math.abs(right - target)) return root.val;
            return right;
        } else {
            if (root.left == null) return root.val;
            int left = closestValue2(root.left, target);
            if (Math.abs(root.val - target) <= Math.abs(left - target)) return root.val;
            return left;
        }
    }
}
