package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1359Test {
    @Test
    void test1() {
        Solution1359 solution1359 = new Solution1359();
        assertEquals(729647433, solution1359.countOrders(8));
        assertEquals(681080400, solution1359.countOrders(7));
        assertEquals(1, solution1359.countOrders(1));
        assertEquals(6, solution1359.countOrders(2));
        assertEquals(90, solution1359.countOrders(3));

    }

}