package leetcode.tree;

import leetcode.dataStructures.TreeNode;
import org.junit.Test;

public class _0298_BinaryTreeLongestConsecutiveSequence {
    private int res = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, 0);
        return res;
    }

    private void dfs(TreeNode root, int val, int currentLongest) {
        if (root == null) return;
        if (root.val == val + 1)
            ++currentLongest;
        else
            currentLongest = 1;
        res = Math.max(res, currentLongest);
        dfs(root.left, root.val, currentLongest);
        dfs(root.right, root.val, currentLongest);
    }

    public int longestConsecutive2(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int len) {
        res = Math.max(res, len);
        if (root.left != null){
            if (root.left.val == root.val + 1)
                dfs(root.left, len + 1);
            else
                dfs(root.left, 1);
        }

        if (root.right != null){
            if (root.right.val == root.val + 1)
                dfs(root.right, len + 1);
            else
                dfs(root.right, 1);
        }
    }

    public int longestConsecutive3(TreeNode root) {
        return helper(root, null, 0);
    }

    private int helper(TreeNode root, TreeNode p, int res) {
        if (root == null) return res;
        if (p != null && p.val == root.val - 1)
            res++;
        else
            res = 1;

        return Math.max(res, Math.max(helper(root.left, root, res), helper(root.right, root, res)));
    }

    @Test
    public void test() {
        _0298_BinaryTreeLongestConsecutiveSequence solution = new _0298_BinaryTreeLongestConsecutiveSequence();

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        root.right = node1;
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(5);
        node3.right = node4;

        /*    1
         *     \
         *      3
         *     / \
         *    2   4
         *         \
         *          5
         *
         */
        int len = solution.longestConsecutive(root);
        //System.out.println(len);
        System.out.println(solution.longestConsecutive3(root));
    }
}
