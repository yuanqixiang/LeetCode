package leetcode.linkedList;

import leetcode.dataStructures.ListNode;
import leetcode.dataStructures.TreeNode;

/*
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Given the sorted linked list: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *      0
 *     / \
 *   -3   9
 *   /   /
 * -10  5
 *
 */
public class _0109_ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        ListNode f = head, ff = f, l = f;
        while(l != null && l.next != null){
            ff = f;
            f = f.next;
            l = l.next.next;
        }
        ff.next = null;

        TreeNode root = new TreeNode(f.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(f.next);
        return root;
    }
}
