package codingtest.leetcode;

import codingtest.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution92Test {
    @Test
    void test1() {
        Solution92 solution92  = new Solution92();
        solution92.reverseBetween(ListNode.generator(1,2,3,4,5), 1,4);
        solution92.reverseBetween(ListNode.generator(3,5), 1,2);
    }

}