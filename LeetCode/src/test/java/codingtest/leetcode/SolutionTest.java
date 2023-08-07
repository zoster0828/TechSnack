package codingtest.leetcode;

import codingtest.Solution;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        Solution solution = new Solution();
        assertEquals(1, solution.minimumSeconds(Arrays.asList(8,8,9,10,9)));
        assertEquals(1, solution.minimumSeconds(Arrays.asList(19,20,7,7,20)));
        assertEquals(1, solution.minimumSeconds(Arrays.asList(14,14,6,11)));
        assertEquals(2, solution.minimumSeconds(Arrays.asList(3,19,8,12)));
        assertEquals(1, solution.minimumSeconds(Arrays.asList(1,2,1,2)));
        assertEquals(2, solution.minimumSeconds(Arrays.asList(2,1,3,3,2)));
        assertEquals(0, solution.minimumSeconds(Arrays.asList(5,5,5,5)));
    }

}