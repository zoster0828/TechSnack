package codingtest.leetcode;

import codingtest.ListNode;

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = null;
        ListNode smallTail = null;
        ListNode big = null;
        ListNode bigHead = null;
        ListNode start = head;
        while(start != null) {
            if(start.val < x) {
                if(small == null) {
                    small = new ListNode(start.val);
                    smallTail = small;
                    start = start.next;
                    continue;
                }

                smallTail.next = new ListNode(start.val);
                smallTail = smallTail.next;
                start = start.next;
            } else {
                if(big == null) {
                    bigHead = new ListNode(start.val);
                    big = bigHead;
                    start = start.next;
                    continue;
                }

                big.next = new ListNode(start.val);
                big = big.next;
                start = start.next;
            }


        }

        if(smallTail == null) {
            return bigHead;
        }
        smallTail.next = bigHead;

        return small;
    }
}
