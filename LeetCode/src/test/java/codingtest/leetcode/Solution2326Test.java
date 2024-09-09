package codingtest.leetcode;

import codingtest.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2326Test {

    @Test
    void test1() {
        Solution2326 solution2326 = new Solution2326();
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(5, listNode1);
        ListNode listNode3 = new ListNode(5, listNode2);
        ListNode listNode4 = new ListNode(2, listNode3);
        ListNode listNode5 = new ListNode(4, listNode4);
        ListNode listNode6 = new ListNode(9, listNode5);
        ListNode listNode7 = new ListNode(7, listNode6);
        ListNode listNode8 = new ListNode(1, listNode7);
        ListNode listNode9 = new ListNode(8, listNode8);
        ListNode listNode10 = new ListNode(6, listNode9);
        ListNode listNode11 = new ListNode(2, listNode10);
        ListNode listNode12 = new ListNode(0, listNode11);
        ListNode listNode13 = new ListNode(3, listNode12);
        solution2326.spiralMatrix(3,5, listNode13);
    }
}