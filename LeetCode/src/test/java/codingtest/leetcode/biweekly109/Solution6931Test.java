package codingtest.leetcode.biweekly109;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution6931Test {
    @Test
    void test1() {
        Solution6931 solution = new Solution6931();
        assertEquals(13, solution.maxScore(new int[]{2,3,6,1,9,2}, 5));
        assertEquals(20, solution.maxScore(new int[]{2,4,6,8}, 3));
        assertEquals(886, solution.maxScore(new int[]{9,58,17,54,91,90,32,6,13,67,24,80,8,56,29,66,85,38,45,13,20,73,16,98,28,56,23,2,47,85,11,97,72,2,28,52,33}, 90));

    }

}