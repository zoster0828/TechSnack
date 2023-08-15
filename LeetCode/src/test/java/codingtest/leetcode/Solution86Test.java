package codingtest.leetcode;

import codingtest.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution86Test {

    @Test
    void test1() {
        Solution86 solution86 = new Solution86();
        ListNode partition1 = solution86.partition(createNodes(new int[]{1, 4, 3, 2, 5, 2}), 3);
        ListNode partition2 = solution86.partition(createNodes(new int[]{2,1}), 2);
        System.out.println();
    }

    private ListNode createNodes(int[] ints) {
        ListNode head = new ListNode(ints[0]);
        ListNode temp = head;
        for (int i = 1; i < ints.length; i++) {
            temp.next = new ListNode(ints[i]);
            temp = temp.next;
        }
        return head;
    }
}