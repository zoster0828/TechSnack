package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution239Test {

    @Test
    void test1() {
        Solution239 solution239 = new Solution239();
        assertEquals(new int[]{3,3,5,5,6,7}, solution239.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }

}