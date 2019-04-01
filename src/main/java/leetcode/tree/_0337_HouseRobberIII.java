package leetcode.tree;

import leetcode.dataStructures.TreeNode;

/*
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 */
public class _0337_HouseRobberIII {

    public int solutionUsingRecursion(TreeNode root) {
        if(root == null)
            return 0;
        int val = 0;
        if(root.left != null)
            val += solutionUsingRecursion(root.left.left) + solutionUsingRecursion(root.left.right);
        if(root.right != null)
            val += solutionUsingRecursion(root.right.left) + solutionUsingRecursion(root.right.right);
        return Math.max(val + root.val, solutionUsingRecursion(root.left) + solutionUsingRecursion(root.right));
    }

    public int solutionUsingDFS(TreeNode root){
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    //num[0] is the max value while rob this node, num[1] is max value while not rob this value.
    private int[] dfs(TreeNode root){
        int[] res = new int[2];
        if(root == null)
            return res;
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}
