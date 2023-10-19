package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2483Test {

    @Test
    void test1() {
        Solution2483 solution2483 = new Solution2483();
        assertEquals(2, solution2483.bestClosingTime("YYNY"));
        assertEquals(4, solution2483.bestClosingTime("YYYY"));
        assertEquals(0, solution2483.bestClosingTime("NNNNN"));
    }
}