package codingtest.leetcode.weekly355;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution6955Test {
    @Test
    void test1() {
        Solution6955 solution = new Solution6955();
        assertEquals(3, solution.maxIncreasingGroups(Arrays.asList(1,2,5)));
        assertEquals(3, solution.maxIncreasingGroups(Arrays.asList(1,2,5)));
        assertEquals(3, solution.maxIncreasingGroups(Arrays.asList(1,2,5)));
    }

}