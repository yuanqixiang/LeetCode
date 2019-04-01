package leetcode.tree;

import leetcode.dataStructures.TreeNode;

import java.util.Stack;

/*
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 */
public class _0173_BinarySearchTreeIterator {

    class BSTIterator{
        Stack<TreeNode> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode temp = stack.pop();
            pushAll(temp.right);
            return temp.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushAll(TreeNode root){
            TreeNode cur = root;
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        }
    }

}
