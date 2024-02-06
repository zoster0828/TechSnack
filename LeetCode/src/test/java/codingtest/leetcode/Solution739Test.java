package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution739Test {

    @Test
    void test1() {
        Solution739 solution739 = new Solution739();
        assertEquals(new int[]{1,1,4,2,1,1,0,0}, solution739.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }

}