package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution135Test {
    @Test
    void test1() {
        Solution135 solution135 = new Solution135();
        assertEquals(5, solution135.candy(new int[]{1,0,2}));
        assertEquals(7, solution135.candy(new int[]{1,3,2,1}));
        assertEquals(7, solution135.candy(new int[]{1,3,2,2,1}));
        assertEquals(4, solution135.candy(new int[]{1,2,2}));
    }

}