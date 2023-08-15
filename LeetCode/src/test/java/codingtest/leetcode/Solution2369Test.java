package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2369Test {
    @Test
    void test1() {
        Solution2369 solution2369 = new Solution2369();
        assertEquals(true, solution2369.validPartition(new int[]{4,4,4,5,6}));
        assertEquals(false, solution2369.validPartition(new int[]{1,1,1,2}));
    }

}