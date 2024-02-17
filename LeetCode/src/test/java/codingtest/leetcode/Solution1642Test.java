package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1642Test {

    @Test
    void test1() {
        Solution1642 solution1642 = new Solution1642();
        assertEquals(4, solution1642.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));
        assertEquals(7, solution1642.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
        assertEquals(7, solution1642.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2));
    }

}