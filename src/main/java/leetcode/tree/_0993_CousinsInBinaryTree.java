package leetcode.tree;

import leetcode.dataStructures.TreeNode;

/*
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 *
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 *
 * We are given the root of a binary tree with unique values,
 * and the values x and y of two different nodes in the tree.
 *
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 */
public class _0993_CousinsInBinaryTree {
    private int depthX;
    private int depthY;
    private TreeNode parentX;
    private TreeNode parentY;

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || root.val == x || root.val == y)
            return false;
        dfs(root, x, y, 0, null);
        return depthX == depthY && parentX != parentY;

    }

    private void dfs(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null)
            return;
        if(root.val == x){
            depthX = depth;
            parentX = parent;
        }
        if(root.val == y){
            depthY = depth;
            parentY = parent;
        }
        dfs(root.left, x, y, depth + 1, root);
        dfs(root.right, x, y, depth + 1, root);
    }
}
