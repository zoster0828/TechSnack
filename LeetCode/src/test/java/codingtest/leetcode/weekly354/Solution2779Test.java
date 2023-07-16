package codingtest.leetcode.weekly354;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2779Test {

    @Test
    void test1() {
        Solution2779 solution = new Solution2779();
        assertEquals(3, solution.maximumBeauty(new int[]{48,93,96,19}, 24));
        assertEquals(3, solution.maximumBeauty(new int[]{13,46,71}, 29));
        assertEquals(2, solution.maximumBeauty(new int[]{5,57,46}, 15));
        assertEquals(3, solution.maximumBeauty(new int[]{4,6,1,2}, 2));
        assertEquals(4, solution.maximumBeauty(new int[]{1,1,1,1}, 10));
    }
}