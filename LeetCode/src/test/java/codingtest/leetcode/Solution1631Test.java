package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1631Test {
    @Test
    void test1() {
        Solution1631 solution1631 = new Solution1631();
        assertEquals(2, solution1631.minimumEffortPath(new int[][]{{1,2,2},{3,8,2},{5,3,5}}));
        assertEquals(1, solution1631.minimumEffortPath(new int[][]{{1,2,3},{3,8,4},{5,3,5}}));
        assertEquals(0, solution1631.minimumEffortPath(new int[][]{{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}}));
    }

}