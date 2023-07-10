package codingtest.leetcode.Biweekly108;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution6923Test {

    @Test
    void test() {
        Solution6923 solution = new Solution6923();
        assertEquals(2, solution.minimumBeautifulSubstrings("1011"));
        assertEquals(3, solution.minimumBeautifulSubstrings("111"));
        assertEquals(-1, solution.minimumBeautifulSubstrings("0"));
        assertEquals(4, solution.minimumBeautifulSubstrings("100111000110111"));
        assertEquals(4, solution.minimumBeautifulSubstrings("10110111111011"));
        assertEquals(6, solution.minimumBeautifulSubstrings("101101111101"));
    }
}