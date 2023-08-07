package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution74Test {
    @Test
    void test1() {
        Solution74 solution74 = new Solution74();
        assertTrue(solution74.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 5));
        assertTrue(solution74.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        assertFalse(solution74.searchMatrix(new int[][]{{1,3,5}}, 13));
        assertFalse(solution74.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
        assertTrue(solution74.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
    }

}