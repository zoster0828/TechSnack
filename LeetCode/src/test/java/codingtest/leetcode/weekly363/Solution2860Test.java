package codingtest.leetcode.weekly363;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution2860Test {
    @Test
    void test1() {
        Solution2860 solution2860 = new Solution2860();
        assertEquals(2, solution2860.countWays(Arrays.asList(1,1)));
        assertEquals(3, solution2860.countWays(Arrays.asList(6,0,3,3,6,7,2,7)));
    }

}