package leetcode.tree.binarySearchTree;

import leetcode.dataStructures.TreeNode;

import java.util.Stack;

public class _1008_ConstructBinarySearchTreeFromPreOrderTraversal {
    public TreeNode bstFromPreOrder(int[] preOrder) {
        return helper(preOrder, 0, preOrder.length - 1);
    }

    private TreeNode helper(int[] preOrder, int begin, int end){
        if(end < begin) return null;
        int rootVal = preOrder[begin];
        TreeNode root = new TreeNode(rootVal);
        if(end == begin) return root;
        int i = begin + 1;
        for(; i <= end; ++i)
            if(preOrder[i] > rootVal)
                break;
        root.left = helper(preOrder, begin + 1, i - 1);
        root.right = helper(preOrder, i, end);
        return root;
    }

    private int index = 0;
    //with bound parameter, see no.98
    public TreeNode solution2(int[] preOrder){
        return build(preOrder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preOrder, int bound){
        if(index >= preOrder.length || preOrder[index] >= bound)
            return null;
        TreeNode curr = new TreeNode(preOrder[index++]);
        curr.left = build(preOrder,curr.val);
        curr.right = build(preOrder,bound);
        return curr;
    }

    //see no.654
    public TreeNode solutionUsingStack(int[] preOrder){
        TreeNode dummy = new TreeNode(Integer.MAX_VALUE);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(dummy);
        for(int a : preOrder){
            TreeNode curr = new TreeNode(a);
            TreeNode p = null;
            while (stack.peek().val < a){
                p = stack.pop();
            }
            if(p != null)
                p.right = curr;
            else
                stack.peek().left = curr;
            stack.push(curr);
        }
        return dummy.left;
    }
}
