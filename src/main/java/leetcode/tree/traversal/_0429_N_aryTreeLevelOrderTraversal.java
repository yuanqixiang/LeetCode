package leetcode.tree.traversal;

import leetcode.dataStructures.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0429_N_aryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int size;
        while((size = queue.size()) != 0){
            List<Integer> temp = new LinkedList<>();
            for(int i = 0 ; i < size; ++i){
                Node node = queue.poll();
                temp.add(node.val);
                if(node.children != null)
                    queue.addAll(node.children);
            }
            result.add(temp);
        }
        return result;
    }
}
