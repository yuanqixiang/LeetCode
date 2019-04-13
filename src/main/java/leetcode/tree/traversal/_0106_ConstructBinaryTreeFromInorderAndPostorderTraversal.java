package leetcode.tree.traversal;

import leetcode.dataStructures.TreeNode;

import java.util.HashMap;

public class _0106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i)
            hm.put(inorder[i], i);
        return buildTree0(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, hm);
    }

    private TreeNode buildTree0(int[] inorder, int[] postorder, int inorderBegin, int inorderEnd, int postorderBegin, int postorderEnd, HashMap<Integer, Integer> hm){
        if(postorderEnd < postorderBegin)
            return null;
        int rootVal = postorder[postorderEnd];
        TreeNode root = new TreeNode(rootVal);
        if(postorderBegin == postorderEnd)
            return root;
        int rootIndex = hm.get(rootVal);
        root.left = buildTree0(inorder, postorder, inorderBegin, rootIndex - 1, postorderBegin, postorderBegin +  rootIndex - inorderBegin - 1, hm);
        root.right = buildTree0(inorder, postorder, rootIndex + 1, inorderEnd, postorderBegin + rootIndex - inorderBegin, postorderEnd - 1, hm);
        return root;
    }
}
