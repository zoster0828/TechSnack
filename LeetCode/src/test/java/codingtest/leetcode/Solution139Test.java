package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class Solution139Test {

    @Test
    void test1() {
        Solution139 solution139 = new Solution139();
        assertTrue(solution139.wordBreak("leetcode", Arrays.asList("leet","code")));
        assertTrue(solution139.wordBreak("cars", Arrays.asList("car","ca","rs")));
        assertTrue(solution139.wordBreak("cbca", Arrays.asList("bc","ca")));
    }
}