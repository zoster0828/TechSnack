package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1870Test {

    @Test
    void test1() {
        Solution1870 solution1870 = new Solution1870();
        assertEquals(10000000, solution1870.minSpeedOnTime(new int[]{1,1,100000}, 2.01));
        assertEquals(3, solution1870.minSpeedOnTime(new int[]{1,3,2}, 2.7));
        assertEquals(1, solution1870.minSpeedOnTime(new int[]{1,3,2}, 6));
    }
}