package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution502Test {
    @Test
    void test1() {
        Solution502 solution502 = new Solution502();
        assertEquals(6, solution502.findMaximizedCapital(10, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
        assertEquals(4, solution502.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        assertEquals(6, solution502.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
    }
}