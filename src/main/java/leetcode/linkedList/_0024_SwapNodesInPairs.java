package leetcode.linkedList;

import leetcode.dataStructures.ListNode;

public class _0024_SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode nummy = new ListNode(0), prev = nummy, cur = head, next = head.next;
        nummy.next = head;
        while(cur != null && next != null){
            cur.next = next.next;
            next.next = cur;
            prev.next = next;
            prev = cur;
            cur = cur.next;
            next = cur != null ? cur.next : null;
        }
        return nummy.next;
    }
}
