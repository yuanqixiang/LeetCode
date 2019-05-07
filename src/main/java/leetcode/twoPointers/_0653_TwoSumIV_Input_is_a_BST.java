package leetcode.twoPointers;

import leetcode.dataStructures.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 */
public class _0653_TwoSumIV_Input_is_a_BST {
    public boolean solutionUsingInOrder(TreeNode root, int k) {
        if(root == null)
            return false;
        List<Integer> list = new LinkedList<>();
        inorder(root, list);
        for(int i = 0, j = list.size() - 1; i < j;){
            if(list.get(i) + list.get(j) == k)
                return true;
            if(list.get(i) + list.get(j) < k)
                ++i;
            else
                --j;
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root.left != null)
            inorder(root.left, list);
        list.add(root.val);
        if(root.right != null)
            inorder(root.right, list);
    }

    public boolean solutionUsingSet(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode root, Set<Integer> set, int k) {
        if(root == null) return false;
        if(set.contains(k - root.val))
            return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
}
