package leetcode.tree.traversal;

import leetcode.dataStructures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> solutionUsingRecursion(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelOrder0(root, 0, result);
        return result;
    }

    private void levelOrder0(TreeNode root, int level, List<List<Integer>> result){
        if(root == null)
            return;
        if(result.size() == level)
            result.add(new ArrayList<Integer>());

        result.get(level).add(root.val);
        levelOrder0(root.left, level + 1, result);
        levelOrder0(root.right, level + 1, result);
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
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);

                temp.add(curr.val);
            }
            result.add(temp);
        }
        return result;
    }
}
