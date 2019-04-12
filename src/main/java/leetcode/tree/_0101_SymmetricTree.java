package leetcode.tree;

import leetcode.dataStructures.TreeNode;

public class _0101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric0(root, root);
    }

    private boolean isSymmetric0(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        if(p != null && q != null){
            return p.val == q.val && isSymmetric0(p.left, q.right) && isSymmetric0(p.right, q.left);
        }
        return false;
    }
}
