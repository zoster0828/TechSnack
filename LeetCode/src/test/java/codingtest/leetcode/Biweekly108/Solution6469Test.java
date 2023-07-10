package codingtest.leetcode.Biweekly108;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Solution6469Test {

    @Test
    void test1() {
        Solution6469 solution = new Solution6469();
        List<Integer> integers = solution.relocateMarbles(new int[]{1, 6, 7, 8}, new int[]{1, 7, 2}, new int[]{2, 9, 5});
        integers = solution.relocateMarbles(new int[]{1,1,3,3}, new int[]{1,3}, new int[]{2,2});
        for (Integer integer : integers) {
            System.out.print(integer+", ");
        }
    }
}