package leetcode.linkedList;

import leetcode.dataStructures.ListNode;

import java.util.Stack;

public class _0023_MergeKSortedLists {

    public ListNode solutionUsingStack(ListNode[] lists){
        int len = lists.length;
        if(len == 0) return null;
        if(len == 1) return lists[0];
        Stack<ListNode> s = new Stack<>();
        for(ListNode node : lists)
            s.push(node);
        while((len = s.size()) > 1){
            ListNode l1 = s.pop();
            ListNode l2 = s.pop();
            s.push(mergeUsingRecursion(l1, l2));
        }
        return s.pop();
    }

    private ListNode mergeUsingRecursion(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val){
            l1.next = mergeUsingRecursion(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeUsingRecursion(l1, l2.next);
            return l2;
        }
    }

    public ListNode solutionUsingMergeSort(ListNode[] lists){
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int start, int end){
        if(start == end) {
            return lists[start];
        } else if(start < end) {
            int mid = start + (end - start) / 2;
            ListNode l1 = partition(lists, start, mid);
            ListNode l2 = partition(lists, mid + 1, end);
            return mergeUsingIteration(l1, l2);
        } else {
            return null;
        }
    }

    private ListNode mergeUsingIteration(ListNode l1, ListNode l2){
        ListNode l = new ListNode(0), cur = l;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next= l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if(l1 != null)
            cur.next = l1;
        if(l2 != null)
            cur.next = l2;
        return l.next;
    }
}
