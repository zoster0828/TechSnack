package codingtest.leetcode;

import codingtest.ListNode;

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode resultHead = null;
        ListNode smallTail = null;
        ListNode big = null;
        ListNode bigHead = null;
        ListNode iterationNode = head;
        while(iterationNode != null) {
            if(iterationNode.val < x) {
                if(resultHead == null) {
                    resultHead = new ListNode(iterationNode.val);
                    smallTail = resultHead;
                    iterationNode = iterationNode.next;
                    continue;
                }

                smallTail.next = new ListNode(iterationNode.val);
                smallTail = smallTail.next;
                iterationNode = iterationNode.next;
            } else {
                if(big == null) {
                    bigHead = new ListNode(iterationNode.val);
                    big = bigHead;
                    iterationNode = iterationNode.next;
                    continue;
                }

                big.next = new ListNode(iterationNode.val);
                big = big.next;
                iterationNode = iterationNode.next;
            }


        }

        if(smallTail == null) {
            return bigHead;
        }

        smallTail.next = bigHead;

        return resultHead;
    }
}
