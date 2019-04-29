package leetcode.tree;

import leetcode.dataStructures.TreeNode;

import java.util.*;

public class _0236_LowestCommonAncestorOfBinaryTree {
    public TreeNode solutionUsingRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = solutionUsingRecursion(root.left, p, q);
        TreeNode right = solutionUsingRecursion(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    public TreeNode solutionUsingIteration(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode curr = stack.pop();
            if(curr.left != null) {
                parent.put(curr.left, curr);
                stack.push(curr.left);
            }

            if(curr.right != null) {
                parent.put(curr.right, curr);
                stack.push(curr.right);
            }
        }

        Set<TreeNode> ancestors = new TreeSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}
