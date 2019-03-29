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
}
