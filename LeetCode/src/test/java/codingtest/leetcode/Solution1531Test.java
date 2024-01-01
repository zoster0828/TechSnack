package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1531Test {
    @Test
    void test1() {
        Solution1531 solution1531 = new Solution1531();
        assertEquals(4, solution1531.getLengthOfOptimalCompression("aaabcccd", 2));
    }
}