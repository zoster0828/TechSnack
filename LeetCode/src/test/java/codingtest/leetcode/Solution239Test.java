package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class Solution239Test {

    @Test
    void test1() {
        Solution239 solution239 = new Solution239();
        int[] actual1 = solution239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        int[] results1 = new int[]{3,3,5,5,6,7};
        for (int i = 0; i < actual1.length; i++) {
            assertEquals(actual1[i], results1[i]);
        }

        int[] actual2 = solution239.maxSlidingWindow(new int[]{1,-1}, 1);
        int[] results2 = new int[]{1,-1};
        for (int i = 0; i < actual2.length; i++) {
            assertEquals(actual2[i], results2[i]);
        }
    }
}