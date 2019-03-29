package leetcode.linkedList;

import leetcode.dataStructures.ListNode;
/*
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class _0876_MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode f = head, l = head;
        while(l != null && l.next != null){
            f = f.next;
            l = l.next.next;
        }
        return f;
    }
}
