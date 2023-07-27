package codingtest.leetcode.weekly355;

import codingtest.leetcode.biweekly109.Solution6926;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class
Solution6921Test {
    @Test
    void test() {
        Solution6921 solution6921 = new Solution6921();
        solution6921.splitWordsBySeparator(Arrays.asList("one.two.three","four.five","six"), '.');
    }

}