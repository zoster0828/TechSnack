package codingtest.leetcode.weekly410;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q2Test {
    @Test
    void test1() {

        Q2 q2 = new Q2();
        assertEquals(7, q2.countGoodNodes(new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}}));
        assertEquals(12, q2.countGoodNodes(new int[][]{{0,1},{1,2},{1,3},{1,4},{0,5},{5,6},{6,7},{7,8},{0,9},{9,10},{9,12},{10,11}}));
    }
}