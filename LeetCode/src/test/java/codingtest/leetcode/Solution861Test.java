package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution861Test {
    @Test
    void test1() {
        Solution861 solution861 = new Solution861();
        int result = 0;
        result = solution861.matrixScore(new int[][]{{0,0,1,1},{1,0,1,0},{1,1,0,0}});
        assertEquals(39, result);
        result = solution861.matrixScore(new int[][]{{0,1},{0,1},{0,1},{0,0}});
        assertEquals(11, result);

    }
}