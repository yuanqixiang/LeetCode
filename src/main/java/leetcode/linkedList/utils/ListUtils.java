package leetcode.linkedList.utils;

import leetcode.dataStructures.ListNode;

public class ListUtils {
    public static String printList(ListNode head) {
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
}
