package codingtest.leetcode.biweekly109;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution6926Test {

    @Test
    void test1() {
        Solution6926 solution = new Solution6926();
        assertEquals("lEOtcede",solution.sortVowels("lEetcOde"));
        assertEquals("lYmpH",solution.sortVowels("lYmpH"));
    }
}