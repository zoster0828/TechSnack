package codingtest.leetcode;

import codingtest.Solution;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertEquals(1958, solution.solution(15958));
        assertEquals(-589, solution.solution(-5859));
        assertEquals(0, solution.solution(-5000));

    }
}