package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution646Test {
    @Test
    void test1() {
        Solution646 solution646 = new Solution646();
        assertEquals(2, solution646.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

}