package leetcode.tree.treeDepth;

import leetcode.dataStructures.Node;

public class _0559_MaximumDepthOfN_aryTree {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int size = root.children.size();
        int max = 0;
        if(size > 0)
            for(int i = 0; i < size; ++i){
                max = Math.max(max, maxDepth(root.children.get(i)));
            }
        return max + 1;
    }
}
