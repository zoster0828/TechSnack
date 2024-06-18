package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution633Test {

    @Test
    void test1() {
        Solution633 solution633 = new Solution633();

        assertTrue(solution633.judgeSquareSum(2));
        assertTrue(solution633.judgeSquareSum(5));
        assertFalse(solution633.judgeSquareSum(2147482647));
        assertTrue(solution633.judgeSquareSum(0));
        assertTrue(solution633.judgeSquareSum(4));
        assertTrue(solution633.judgeSquareSum(1000));
    }

}