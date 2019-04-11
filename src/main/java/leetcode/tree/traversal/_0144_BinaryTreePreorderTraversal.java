package leetcode.tree.traversal;

import leetcode.dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0144_BinaryTreePreorderTraversal {
    public List<Integer> solutionUsingRecursion(TreeNode root){
        List<Integer> res = new LinkedList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res){
        if(root == null)
            return;
        res.add(root.val);
        inorderTraversal(root.left, res);
        inorderTraversal(root.right, res);
    }

    public List<Integer> solutionUsingIteration(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if(curr.right != null)
                stack.push(curr.right);
            if(curr.left != null)
                stack.push(curr.left);
        }
        return res;
    }

    public List<Integer> solutionUsingIteration2(TreeNode root){
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            //因为是前序，所以遇到左儿子不为空，加入list，然后push进stack，
            if (curr != null){
                stack.push(curr);
                res.add(curr.val);
                curr = curr.left;
            } else {
                //当左儿子（curr）为空时，stack最上面的那个node是最近一个父节点，pop出来，因为已经加入list，所以丢弃。
                curr = stack.pop();
                //然后对curr的右儿子继续执行while循环。
                curr = curr.right;
            }
        }
        return res;
    }
}
