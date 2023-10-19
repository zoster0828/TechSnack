package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1658Test {

    @Test
    void test1() {
        Solution1658 solution1658 = new Solution1658();
        assertEquals(2, solution1658.minOperations(new int[]{1,1,4,2,3},5));
        assertEquals(-1, solution1658.minOperations(new int[]{5,6,7,8,9},4));
        assertEquals(5, solution1658.minOperations(new int[]{3,2,20,1,1,3},10));
    }

}