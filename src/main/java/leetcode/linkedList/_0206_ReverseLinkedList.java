package leetcode.linkedList;

import leetcode.dataStructures.ListNode;

public class _0206_ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head, next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseListUsingRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newList = reverseListUsingRecursion(head.next);
        ListNode t1 = head.next;
        t1.next = head;
        head.next = null;
        return newList;
    }
}
