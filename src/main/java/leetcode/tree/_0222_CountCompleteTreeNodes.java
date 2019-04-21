package leetcode.tree;

import leetcode.dataStructures.TreeNode;

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
