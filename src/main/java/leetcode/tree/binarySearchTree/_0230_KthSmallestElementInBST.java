package leetcode.tree.binarySearchTree;

import leetcode.dataStructures.TreeNode;

import java.util.Stack;

/*
 * inorder traversal
 */
public class _0230_KthSmallestElementInBST {
    private int count = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        //helper(root, k);
        solutionUsingStack(root, k);
        return res;
    }

    private void helper(TreeNode root, int k){
        if(root == null)
            return;
        if(root.left != null)
            helper(root.left, k);
        ++count;
        if(count == k)
            res = root.val;
        helper(root.right, k);
    }

    public void solutionUsingStack(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        Integer inorder = Integer.MIN_VALUE;
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                ++count;
                if(count == k)
                    res = curr.val;
                curr = curr.right;
            }
        }
    }
}
