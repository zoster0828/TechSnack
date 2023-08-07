package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2141Test {
    @Test
    void test1() {
        Solution2141 solution2141 = new Solution2141();
        assertEquals(4, solution2141.maxRunTime(2, new int[]{3,3,3}));
        assertEquals(8, solution2141.maxRunTime(3, new int[]{10,10,3,5}));
    }

}