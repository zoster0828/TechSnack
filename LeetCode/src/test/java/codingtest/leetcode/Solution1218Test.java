package codingtest.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution1218Test {
    @Test
    void test1() {
        Solution1218 solution = new Solution1218();
        assertEquals(2, solution.longestSubsequence(new int[]{3,0,-3,4,-4,7,6},3 ));
    }
}