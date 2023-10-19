package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2742Test {

    @Test
    void test1() {
        Solution2742 solution2742 = new Solution2742();
        assertEquals(63, solution2742.paintWalls(new int[]{42,8,28,35,21,13,21,35}, new int[]{2,1,1,1,2,1,1,2}));
        assertEquals(12, solution2742.paintWalls(new int[]{8,7,5,15}, new int[]{1,1,2,1}));
        assertEquals(3, solution2742.paintWalls(new int[]{1,2,3,2}, new int[]{1,2,3,2}));
        assertEquals(4, solution2742.paintWalls(new int[]{2,3,4,2}, new int[]{1,1,1,1}));
    }
}