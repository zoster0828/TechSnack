package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1232Test {
    Solution1232 solution = new Solution1232();
    @Test
    void test1() {        
        solution.checkStraightLine(new int [][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}});
    }
    @Test
    void test2() {
        solution.checkStraightLine(new int [][]{{0,0},{0,1},{0,-1}});
    }

    @Test
    void test3() {
        solution.checkStraightLine(new int [][]{{1,1},{2,2},{0,2}});
    }
}