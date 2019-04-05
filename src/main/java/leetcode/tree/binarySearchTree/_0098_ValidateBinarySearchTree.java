package leetcode.tree.binarySearchTree;

import leetcode.dataStructures.TreeNode;

public class _0098_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        boolean left;
        if(root.left == null)
            left = true;
        else {
            left = root.left.val < root.val;
            TreeNode cur = root.left;
            while(cur != null && cur.right != null){
                cur = cur.right;
            }
            left = left && cur.val < root.val;
        }

        boolean right;
        if(root.right == null)
            right = true;
        else {
            right = root.right.val > root.val;
            TreeNode cur = root.right;
            while(cur != null && cur.left != null){
                cur = cur.left;
            }
            right = right && cur.val > root.val;
        }
        return left && right && isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean solutionUsingRecursion(TreeNode root){
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && min >= root.val) return false;
        if (max != null && max <= root.val) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
