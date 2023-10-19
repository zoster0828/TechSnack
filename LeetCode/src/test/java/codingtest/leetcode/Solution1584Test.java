package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1584Test {
    @Test
    void test() {
        Solution1584 solution1584 = new Solution1584();
        assertEquals(53, solution1584.minCostConnectPoints(new int[][]{{2,-3},{-17,-8},{13,8},{-17,-15}}));
        assertEquals(20, solution1584.minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
        assertEquals(4, solution1584.minCostConnectPoints(new int[][]{{0,0},{1,1},{1,0},{-1,1}}));

    }
}