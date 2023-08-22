package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution168Test {
    @Test
    void test1() {
        Solution168 solution168 = new Solution168();
        assertEquals("A", solution168.convertToTitle(1));
        assertEquals("AB", solution168.convertToTitle(28));
        assertEquals("ZY", solution168.convertToTitle(701));
    }
}