package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Solution1751Test {
    @Test
    void test1() {
        Solution1751 solution = new Solution1751();
        assertEquals(7, solution.maxValue(new int[][]{{1,2,4}, {3,4,3}, {2,3,1}}, 2));

        assertEquals(7, solution.maxValue(new int[][]{{1,2,4}, {3,4,3}, {2,3,1}}, 2));

        Map<Integer, Integer> map = new HashMap();
        int max = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            max = Math.max(integerIntegerEntry.getValue(), max);
        }

    }
}