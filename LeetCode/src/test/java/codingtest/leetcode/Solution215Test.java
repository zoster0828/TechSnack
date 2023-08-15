package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution215Test {
    @Test
    void test1() {
        Solution215 solution215 = new Solution215();
        assertEquals(5,solution215.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }

}