package leetcode.tree.traversal;

import leetcode.dataStructures.TreeNode;

import java.util.HashMap;

/*
 * see no.105、no.106
 */
public class _0889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < post.length; ++i)
            map.put(post[i], i);
        return helper(pre, post, 0, pre.length - 1, 0, post.length - 1, map);
    }

    TreeNode helper(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd, HashMap<Integer, Integer> map){
        if(preStart > preEnd)
            return null;
        if(preStart == preEnd)
            return new TreeNode(pre[preStart]);
        TreeNode root = new TreeNode(pre[preStart]);
        int leftVal = pre[preStart + 1];
        int index = map.get(leftVal);
        root.left = helper(pre, post, preStart + 1, preStart + 1 + index - postStart, postStart, index, map);
        root.right = helper(pre, post, preStart + 2 + index - postStart, preEnd, index + 1, postEnd - 1, map);
        return root;
    }
}
