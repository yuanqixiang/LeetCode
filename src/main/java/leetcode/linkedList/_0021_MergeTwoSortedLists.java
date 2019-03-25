package leetcode.linkedList;

import leetcode.dataStructures.ListNode;

public class _0021_MergeTwoSortedLists {

    public ListNode solutionUsingRecursion(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = solutionUsingRecursion(l1.next, l2);
            return l1;
        } else {
            l2.next = solutionUsingRecursion(l1, l2.next);
            return l2;
        }
    }

    public ListNode solutionUsingIteration(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode nummy = new ListNode(0), cur = nummy, p1 = l1, p2 = l2;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if(p1 != null) cur.next = p1;
        if(p2 != null) cur.next = p2;
        return nummy.next;
    }
}
