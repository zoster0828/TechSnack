package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1337Test {

    @Test
    void test() {
        Solution1337 solution1337 = new Solution1337();
        assertEquals(new int[]{2,0,3}, solution1337.kWeakestRows(new int[][]{
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        }, 3));
    }
}