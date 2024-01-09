package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution125Test {

    @Test
    void test1() {
        Solution125 solution125 = new Solution125();
        assertTrue(solution125.isPalindrome(".,"));
        assertFalse(solution125.isPalindrome("0P"));
        assertTrue(solution125.isPalindrome("A man, a plan, a canal: Panama"));
    }
}