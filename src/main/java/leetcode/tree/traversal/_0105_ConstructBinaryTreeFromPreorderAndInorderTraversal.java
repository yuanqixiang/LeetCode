package leetcode.tree.traversal;

import leetcode.dataStructures.TreeNode;

import java.util.HashMap;

public class _0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i)
            hm.put(inorder[i], i);
        return buildTree0(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, hm);
    }

    private TreeNode buildTree0(int[] preorder, int[] inorder, int preorderBegin, int preorderEnd, int inorderBegin, int inorderEnd, HashMap<Integer, Integer> hm){
        if(preorderEnd < preorderBegin)
            return null;
        int rootVal = preorder[preorderBegin];
        TreeNode root = new TreeNode(rootVal);
        if(preorderBegin == preorderEnd)
            return root;
        int rootIndex = hm.get(rootVal);
        root.left = buildTree0(preorder, inorder, preorderBegin + 1, preorderBegin + rootIndex - inorderBegin, inorderBegin, rootIndex - 1, hm);
        root.right = buildTree0(preorder, inorder, preorderBegin + rootIndex - inorderBegin + 1, preorderEnd, rootIndex + 1, inorderEnd, hm);
        return root;
    }
}
