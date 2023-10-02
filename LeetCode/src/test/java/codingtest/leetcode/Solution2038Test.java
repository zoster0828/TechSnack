package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Solution2038Test {
    @Test
    void test1() {
        Solution2038 solution2038 = new Solution2038();
        assertFalse(solution2038.winnerOfGame("AAAABBBB"));
        assertTrue(solution2038.winnerOfGame("AAABABB"));
        assertFalse(solution2038.winnerOfGame("AA"));
        assertFalse(solution2038.winnerOfGame("ABBBBBBBAAA"));
    }

}