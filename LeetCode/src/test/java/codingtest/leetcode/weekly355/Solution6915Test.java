package codingtest.leetcode.weekly355;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution6915Test {
    @Test
    void test1() {
        Solution6915 solution6915 = new Solution6915();
        assertEquals(21, solution6915.maxArrayValue(new int[]{2,3,7,9,3}));
        assertEquals(11, solution6915.maxArrayValue(new int[]{5,3,3}));
    }
}