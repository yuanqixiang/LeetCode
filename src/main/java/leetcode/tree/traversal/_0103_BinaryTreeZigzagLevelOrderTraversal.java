package leetcode.tree.traversal;

import leetcode.dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> solution(TreeNode root){
        List<List<Integer>> result = new LinkedList<>();
        zigzagLevelOrder0(root, 0, result);
        return result;
    }

    private void zigzagLevelOrder0(TreeNode root, int level, List<List<Integer>> result){
        if(root == null)
            return;
        if(result.size() == level)
            result.add(new LinkedList<>());
        if((level & 0x01) > 0)
            ((LinkedList)result.get(level)).addFirst(root.val);
        else
            result.get(level).add(root.val);

        zigzagLevelOrder0(root.left, level + 1, result);
        zigzagLevelOrder0(root.right, level + 1, result);
    }

    public List<List<Integer>> solutionUsingIteration(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        queue.offer(root);
        boolean order = true;
        int size;
        while((size = queue.size()) > 0){
            List<Integer> temp = new LinkedList<>();
            for(int i = 0; i < size; ++i){
                TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);

                if(order)
                    temp.add(curr.val);
                else
                    temp.add(0, curr.val);
            }
            order = !order;
            result.add(temp);
        }
        return result;
    }
 }
