package leetcode.tree;

import leetcode.dataStructures.TreeNode;

public class _0235_LowestCommonAncestorOfBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode solutionUsingIteration(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (true) {
            if(curr.val > p.val && curr.val > q.val)
                curr = curr.left;
            if(curr.val < p.val && curr.val < q.val)
                curr = curr.right;
            else break;
        }

        return curr;
    }
}
