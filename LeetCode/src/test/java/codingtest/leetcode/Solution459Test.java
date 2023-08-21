package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution459Test {
    @Test
    void test1() {
        Solution459 solution459 = new Solution459();
        assertTrue(solution459.repeatedSubstringPattern("ababab"));
        assertTrue(solution459.repeatedSubstringPattern("abab"));
    }
}