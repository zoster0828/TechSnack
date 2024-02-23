package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution787Test {

    @Test
    void test1() {
        Solution787 solution787 = new Solution787();
        assertEquals(6, solution787.findCheapestPrice(4, new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}}, 0, 3, 1));
        System.out.println(solution787.findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0,2,1));
    }

}