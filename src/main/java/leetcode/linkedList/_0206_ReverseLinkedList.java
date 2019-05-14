package leetcode.linkedList;

import leetcode.dataStructures.ListNode;
import org.junit.Test;

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

    private String print(ListNode head) {
        if (head == null) return "";
        ListNode curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.val).append(" --> ");
            curr = curr.next;
        }
        sb.replace(sb.length() - 5, sb.length(), "");
        return sb.toString();
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println("original list: " + print(head));
        ListNode newList = reverseListUsingRecursion(head);
        String list = print(newList);
        System.out.println("reversed list: " + list);
    }
}
