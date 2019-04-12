package leetcode.tree.binarySearchTree;

import leetcode.dataStructures.TreeNode;

import java.util.Stack;

/*
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 *
 * Input: [1,3,null,null,2]
 *
 *    1
 *   /
 *  3
 *   \
 *    2
 *
 * Output: [3,1,null,null,2]
 *
 *    3
 *   /
 *  1
 *   \
 *    2
 *
 * see no.98
 * inorder traversal the BST, the first time if current node's value <= prev node's,
 * record the prev node as first node, the current node as second node.
 * the next time if if current node's value <= prev node's,
 * record only the current node as second node.
 */
public class _0099_RecoverBinarySearchTree {
    public void solutionUsingInOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode curr = root;
        TreeNode first = null, second = null;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if(curr.val <= prev.val) {
                    if(first == null) first = prev;
                    if(first != null) second = curr;
                }
                prev = curr;
                curr = curr.right;
            }
        }
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}
