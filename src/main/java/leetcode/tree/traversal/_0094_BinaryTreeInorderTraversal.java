package leetcode.tree.traversal;

import leetcode.dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0094_BinaryTreeInorderTraversal {
    public List<Integer> solutionUsingRecursion(TreeNode root){
        List<Integer> res = new LinkedList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res){
        if(root == null)
            return;
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }

    public List<Integer> solutionUsingIteration(TreeNode root){
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            //因为是中序，所以遇到左儿子不为空，就push进stack，
            if (curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                //当左儿子（curr）为空时，stack最上面的那个node是最近一个父节点，pop出来，加入list。
                curr = stack.pop();
                res.add(curr.val);
                //然后对curr的右儿子继续执行while循环。
                curr = curr.right;
            }

        }
        return res;
    }
}
