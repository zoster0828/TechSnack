package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class Solution2402Test {

    @Test
    void test1() {
        Solution2402 solution2402 = new Solution2402();

        assertEquals(1, solution2402.mostBooked(3, new int[][]{{1,20},{2,10},{3,5},{4,9},{6,8}}));
        assertEquals(0, solution2402.mostBooked(4, new int[][]{{48,49},{22,30},{13,31},{31,46},{37,46},{32,36},{25,36},{49,50},{24,34},{6,41}}));
        assertEquals(0, solution2402.mostBooked(4, new int[][]{{18,19},{3,12},{17,19},{2,13},{7,10}}));
        assertEquals(1, solution2402.mostBooked(3, new int[][]{{1,20},{2,10},{3,5},{4,9},{6,8}}));
        assertEquals(0, solution2402.mostBooked(2, new int[][]{{0,10},{1,5},{2,7},{3,4}}));
    }
}