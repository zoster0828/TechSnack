package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution33Test {
    @Test
    void test1() {
        Solution33 solution33 = new Solution33();
        assertEquals(4, solution33.search(new int[]{4,5,6,7,0,1,2}, 0));
        assertEquals(-1, solution33.search(new int[]{4,5,6,7,0,1,2}, 3));
        assertEquals(-1, solution33.search(new int[]{1}, 0));
    }
}