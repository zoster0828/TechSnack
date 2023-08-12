package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution518Test {
    @Test
    void test1() {
        Solution518 solution518 = new Solution518();
        assertEquals(12701, solution518.change(500, new int[]{1,2,5}));
        assertEquals(1, solution518.change(10, new int[]{5}));
        assertEquals(4, solution518.change(5, new int[]{1,2,5}));
        assertEquals(1, solution518.change(5, new int[]{2,5}));
    }

}