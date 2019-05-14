package leetcode.linkedList;

import leetcode.dataStructures.ListNode;

public class _0019_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nummy = new ListNode(0), cur = head, prev = nummy, p = head;
        nummy.next = head;
        while(n-- > 1){
            cur = cur.next;
        }
        while(cur.next != null){
            cur = cur.next;
            prev = p;
            p = p.next;
        }
        prev.next = p.next;
        return nummy.next;
    }
}
