package codingtest.leetcode.Biweekly108;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution6913Test {
    @Test
    void test1() {
        Solution6913 solution = new Solution6913();
        assertEquals(4, solution.alternatingSubarray(new int[]{2,3,4,3,4}));
        assertEquals(2,solution.alternatingSubarray(new int[]{4,5,6}));
        assertEquals(3,solution.alternatingSubarray(new int[]{13,14,15,14}));
        assertEquals(-1,solution.alternatingSubarray(new int[]{14,30,29,49,3,23,44,21,26,52}));
        assertEquals(3,solution.alternatingSubarray(new int[]{9,13,10,11,10,14,5,5}));

    }
}