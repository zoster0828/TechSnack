package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2616Test {
    @Test
    void test1() {
        Solution2616 solution2616 = new Solution2616();
        assertEquals(2,solution2616.minimizeMax(new int[]{1,1,0,3}, 2));
        assertEquals(1,solution2616.minimizeMax(new int[]{3,4,2,3,2,1,2}, 3));
    }
}