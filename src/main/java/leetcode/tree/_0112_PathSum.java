package leetcode.tree;

import leetcode.dataStructures.TreeNode;

import java.util.Stack;

public class _0112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && sum == root.val)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    //see no.129.  the solution is the same.
    public boolean solutionUsingStack(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        int amt = 0;
        TreeNode curr = root, prev = null;
        while(curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                amt += curr.val;
                curr = curr.left;
            }

            curr = stack.peek();
            if(curr.left == null && curr.right == null && amt == sum) return true;
            if(curr.right != null && prev != curr.right){
                curr = curr.right;
            } else {
                prev = curr;
                stack.pop();
                amt -= curr.val;
                curr = null;
            }
        }
        return false;
    }
}
