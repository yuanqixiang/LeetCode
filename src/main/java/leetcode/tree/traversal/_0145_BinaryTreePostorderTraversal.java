package leetcode.tree.traversal;

import leetcode.dataStructures.TreeNode;

import java.util.*;

public class _0145_BinaryTreePostorderTraversal {
    public List<Integer> solutionUsingRecursion(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if(root != null){
            res.addAll(solutionUsingRecursion(root.left));
            res.addAll(solutionUsingRecursion(root.right));
            res.add(root.val);
        }
        return res;
    }

    //preOrder是父-左-右，如果变为父-右-左，然后再反转，就是左-右-父。
    //所以就将144题的push顺序改变一下，先push左儿子，再push右儿子。
    public List<Integer> solutionUsingIteration(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if(curr.left != null)
                stack.push(curr.left);
            if(curr.right != null)
                stack.push(curr.right);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> postrderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }
}
