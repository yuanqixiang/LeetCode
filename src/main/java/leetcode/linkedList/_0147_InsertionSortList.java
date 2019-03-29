package leetcode.linkedList;

import leetcode.dataStructures.ListNode;

public class _0147_InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode nummy = new ListNode(0), prev = nummy, cur = head;
        while(cur != null){
            prev = nummy;
            while(prev.next != null && prev.next.val < cur.val)
                prev = prev.next;

            ListNode next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = next;
        }
        return nummy.next;
    }
}
