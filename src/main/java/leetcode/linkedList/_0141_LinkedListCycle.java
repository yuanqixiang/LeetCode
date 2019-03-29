package leetcode.linkedList;

import leetcode.dataStructures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class _0141_LinkedListCycle {

    public boolean solutionUsingTwoPointers(ListNode head){
        if(head == null || head.next == null)
            return false;
        ListNode fast = head.next, slow = head;
        while(fast != slow){
            if(fast == null || fast.next == null)
                return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public boolean solutionUsingSet(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head))
                return true;
            else
                set.add(head);
            head = head.next;
        }
        return false;
    }
}
