package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution34Test {
    @Test
    void test0() {
        Solution34 solution34 = new Solution34();
        assertArrayEquals(new int[]{2,2}, solution34.searchRange(new int[]{0,1,2,3,4,4,4}, 2));
    }
    @Test
    void test1() {
        Solution34 solution34 = new Solution34();
        assertArrayEquals(new int[]{2,2}, solution34.searchRange(new int[]{1,2,3}, 3));
    }
    @Test
    void test2() {
        Solution34 solution34 = new Solution34();
        assertArrayEquals(new int[]{3,4}, solution34.searchRange(new int[]{5,7,7,8,8,10}, 8));
    }
    @Test
    void test3() {
        Solution34 solution34 = new Solution34();
        assertArrayEquals(new int[]{-1,-1}, solution34.searchRange(new int[]{5,7,7,8,8,10}, 6));
    }
    @Test
    void test4() {
        Solution34 solution34 = new Solution34();
        assertArrayEquals(new int[]{-1,-1}, solution34.searchRange(new int[]{}, 0));
    }
}