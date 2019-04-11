package leetcode.tree.traversal;

import leetcode.dataStructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15, 7],
 *   [9, 20],
 *   [3]
 * ]
 *
 */
public class _0107_BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> solutionUsingRecursion(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelOrderBottom0(root, 0, result);
        return result;
    }

    private void levelOrderBottom0(TreeNode root, int level, List<List<Integer>> result){
        if(root == null)
            return;
        if(result.size() == level)
            result.add(0, new ArrayList<Integer>());

        result.get(result.size() - level - 1).add(root.val);
        levelOrderBottom0(root.left, level + 1, result);
        levelOrderBottom0(root.right, level + 1, result);
    }

    public List<List<Integer>> solutionUsingIteration(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        queue.offer(root);
        int size;
        while((size = queue.size()) > 0){
            List<Integer> temp = new LinkedList<>();
            for(int i = 0; i < size; ++i){
                TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.offer(curr.left);
                if(curr.right != null)
                    queue.offer(curr.right);

                temp.add(curr.val);
            }
            result.add(0, temp);
        }
        return result;
    }
}
