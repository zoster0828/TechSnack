package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution63Test {

    @Test
    void test1() {
        Solution63 solution63 = new Solution63();
        assertEquals(0, solution63.uniquePathsWithObstacles(new int[][]{{1,0}}));
        assertEquals(2, solution63.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        assertEquals(1, solution63.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
        assertEquals(7, solution63.uniquePathsWithObstacles(new int[][]{{0,0,0,0},{0,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0}}));
    }

}