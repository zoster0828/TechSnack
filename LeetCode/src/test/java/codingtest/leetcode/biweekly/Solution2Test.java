package codingtest.leetcode.biweekly;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution2Test {
    @Test
    void test1() {
        Solution2 solution2 = new Solution2();
        assertEquals(0, solution2.minLengthAfterRemovals(Arrays.asList(1,4,4,9,9,9)));
        assertEquals(1, solution2.minLengthAfterRemovals(Arrays.asList(2,3,4,4,4)));
        assertEquals(0, solution2.minLengthAfterRemovals(Arrays.asList(1,1,2,2)));
        assertEquals(1, solution2.minLengthAfterRemovals(Arrays.asList(1,2,2)));
        assertEquals(0, solution2.minLengthAfterRemovals(Arrays.asList(1, 3, 4, 9)));
    }

}