package leetcode.tree;

import leetcode.dataStructures.TreeNode;

/*
 * Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L).
 * You might need to change the root of the tree,
 * so the result should return the new root of the trimmed binary search tree.
 */
public class _0669_TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null)
            return null;
        if(root.val > R)
            return trimBST(root.left, L, R);
        if(root.val < L)
            return trimBST(root.right, L, R);
        TreeNode cur = root.left, prev = root;
        while(cur != null && cur.val >= L){
            prev = cur;
            cur = cur.left;
        }
        prev.left = trimBST(cur == null ? null : cur.right, L, R);

        cur = root.right; prev = root;
        while(cur != null && cur.val <= R){
            prev = cur;
            cur = cur.right;
        }
        prev.right = trimBST(cur == null ? null : cur.left, L, R);
        return root;
    }

    public TreeNode solutionUsingRecursion(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val > R) return solutionUsingRecursion(root.left, L, R);
        if (root.val < L) return solutionUsingRecursion(root.right, L, R);

        root.left = solutionUsingRecursion(root.left, L, R);
        root.right = solutionUsingRecursion(root.right, L, R);
        return root;
    }
}
