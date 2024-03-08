package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution3005Test {
    @Test
    void test1() {
        Solution3005 solution3005 = new Solution3005();
        assertEquals(5, solution3005.maxFrequencyElements(new int[]{1,2,3,4,5}));
    }
}