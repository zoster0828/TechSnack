package codingtest.leetcode.weekly354;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution6972Test {

    @Test
    void test1() {
        Solution6972 solution6972 = new Solution6972();
        assertEquals(2, solution6972.minimumIndex(Arrays.asList(1,2,2,2)));
        assertEquals(-1, solution6972.minimumIndex(Arrays.asList(3,3,3,3,7,2,2)));
        assertEquals(-1, solution6972.minimumIndex(Arrays.asList(9,5,5,1,1,1,1,8,1)));
    }
}