package codingtest.leetcode;

import codingtest.ListNode;

import java.util.Stack;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }

        ListNode currentNode = head;
        ListNode tailNode = null;
        for(int i = 1 ; i < left ; i++) {
            tailNode = currentNode;
            currentNode = tailNode.next;
        }

        Stack<ListNode> stack = new Stack();

        for(int i = 0 ; i < right - left+1 ; i++) {
            stack.add(currentNode);
            currentNode = currentNode.next;
        }


        ListNode reverseTail = stack.pop();
        ListNode reverseHead = reverseTail;
        while(!stack.isEmpty()) {
            ListNode nextNode = stack.pop();
            reverseTail.next = nextNode;
            reverseTail = nextNode;
        }

        reverseTail.next = currentNode;
        if(tailNode != null) {
            tailNode.next = reverseHead;
        }

        return left == 1 ? reverseHead : head;
    }
}
