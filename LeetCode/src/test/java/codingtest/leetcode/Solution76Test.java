package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution76Test {

    @Test
    void init() {
        Solution76 solution76 = new Solution76();
        String s = solution76.minWindow("ADOBECODEBANC", "ABC");

        System.out.println(s);
    }
}