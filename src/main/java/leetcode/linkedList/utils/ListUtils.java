package leetcode.linkedList.utils;

import leetcode.dataStructures.ListNode;

public class ListUtils {
    private static final String JOINT_STRING = " --> ";
    private static final String EMPTY_STRING = "";

    public static String printList(ListNode head) {
        if (head == null) return EMPTY_STRING;
        ListNode curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.val).append(JOINT_STRING);
            curr = curr.next;
        }
        sb.replace(sb.length() - JOINT_STRING.length(), sb.length(), EMPTY_STRING);
        return sb.toString();
    }
}
