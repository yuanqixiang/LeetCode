package leetcode.tree.treeDepth;

import leetcode.dataStructures.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepthUsingIteration(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0;
        if(root == null) return result;
        queue.offer(root);
        int size;
        while((size = queue.size()) > 0){
            ++result;
            for(int i = 0; i < size; ++i){
                TreeNode curr = queue.poll();
                if(curr.left != null)
                    queue.add(curr.left);
                if(curr.right != null)
                    queue.add(curr.right);
            }
        }
        return result;
    }
}
