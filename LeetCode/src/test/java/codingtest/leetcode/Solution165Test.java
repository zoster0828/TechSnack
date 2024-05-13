package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution165Test {

    @Test
    void test1() {
        Solution165 solution165 = new Solution165();
        assertEquals(1, solution165.compareVersion("1.0.1", "1"));
        assertEquals(0, solution165.compareVersion("1.0", "1.0.0"));
        assertEquals(0, solution165.compareVersion("1.01", "1.001"));
        assertEquals(-1, solution165.compareVersion("7.5.2.4", "7.5.3"));
    }

}