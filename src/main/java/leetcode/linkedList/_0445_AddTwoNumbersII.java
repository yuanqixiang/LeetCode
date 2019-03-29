package leetcode.linkedList;

import leetcode.dataStructures.ListNode;

import java.util.Stack;

public class _0445_AddTwoNumbersII {

    public ListNode solutionUsingReverse(ListNode l1, ListNode l2){
        ListNode p = reverse(l1), q = reverse(l2);
        int flag = 0, pval = 0, qval = 0;
        ListNode nummy = new ListNode(0), next = nummy.next;

        while(p != null || q != null){
            pval = p != null ? p.val : 0;
            qval = q != null ? q.val : 0;
            int sum = flag + pval + qval;
            flag = sum / 10;
            next = nummy.next;
            nummy.next = new ListNode(sum % 10);
            nummy.next.next = next;
            p = p != null ? p.next : null;
            q = q != null ? q.next : null;
        }

        if(flag != 0){
            next = nummy.next;
            nummy.next = new ListNode(flag);
            nummy.next.next = next;
        }

        return nummy.next;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null, cur = head, next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode solutionUsingStack(ListNode l1, ListNode l2){
        Stack<Integer> s1 = convert(l1), s2 = convert(l2);
        ListNode nummy = new ListNode(0), next = null;
        int flag = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            next = nummy.next;
            int m = !s1.isEmpty() ? s1.pop() : 0;
            int n = !s2.isEmpty() ? s2.pop() : 0;
            int sum = m + n + flag;
            nummy.next = new ListNode(sum % 10);
            nummy.next.next = next;
            flag = sum / 10;
        }

        if(flag != 0){
            next = nummy.next;
            nummy.next = new ListNode(flag);
            nummy.next.next = next;
        }
        return nummy.next;
    }

    private Stack<Integer> convert(ListNode head){
        Stack<Integer> res = new Stack<Integer>();
        while(head != null){
            res.push(head.val);
            head = head.next;
        }
        return res;
    }
}
