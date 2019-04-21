package leetcode.tree.traversal;

import leetcode.dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *
 *  Example:
 *
 *  Input: [1,2,3,null,5,null,4]
 *  Output: [1, 3, 4]
 *  Explanation:
 *
 *     1            <---
 *   /   \
 *  2     3         <---
 *   \     \
 *    5     4       <---
 */
public class _0199_BinaryTreeRightSideView {
    public List<Integer> solutionUsingQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        queue.offer(root);
        int size;
        while(!queue.isEmpty()){
            size = queue.size();
            while(size-- > 0){
                TreeNode curr = queue.poll();
                if(size == 0)
                    result.add(curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
        }
        return result;
    }

    public List<Integer> solutionUsingRecursion(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result, int level) {
        if(root == null) return;
        if(result.size() == level) result.add(root.val);
        helper(root.right, result, level + 1);
        helper(root.left, result, level + 1);
    }
}
