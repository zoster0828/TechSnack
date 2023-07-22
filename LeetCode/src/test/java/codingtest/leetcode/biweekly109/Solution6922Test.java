package codingtest.leetcode.biweekly109;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution6922Test {
    @Test
    void test1() {
        Solution6922 solution = new Solution6922();
        assertEquals(1, solution.numberOfWays(10, 2));
        assertEquals(2, solution.numberOfWays(4, 1));
    }

}