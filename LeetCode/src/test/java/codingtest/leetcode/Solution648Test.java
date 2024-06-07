package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution648Test {
    @Test
    void test1() {
        Solution648 solution648 = new Solution648();
        solution648.replaceWords(Arrays.asList("a", "aa", "aaa"), "a ab aaa");
    }
}