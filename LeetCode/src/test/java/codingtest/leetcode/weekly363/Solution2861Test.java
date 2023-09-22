package codingtest.leetcode.weekly363;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution2861Test {
    @Test
    void test() {
        Solution2861 solution2861 = new Solution2861();
        assertEquals(1, solution2861.maxNumberOfAlloys(9,3,90, Arrays.asList(Arrays.asList(10,9,1,3,3,5,5,10,7), Arrays.asList(2,6,4,9,9,1,9,6,7), Arrays.asList(1,4,7,6,7,7,10,6,6)), Arrays.asList(3,10,10,8,10,5,7,1,2), Arrays.asList(9,8,10,9,9,3,9,5,8)));
        assertEquals(2, solution2861.maxNumberOfAlloys(3,2,15, Arrays.asList(Arrays.asList(1,1,1), Arrays.asList(1,1,10)), Arrays.asList(0,0,0), Arrays.asList(1,2,3)));
        assertEquals(5, solution2861.maxNumberOfAlloys(3,2,15, Arrays.asList(Arrays.asList(1,1,1), Arrays.asList(1,1,10)), Arrays.asList(0,0,100), Arrays.asList(1,2,3)));
        assertEquals(2, solution2861.maxNumberOfAlloys(2,3,10, Arrays.asList(Arrays.asList(2,1), Arrays.asList(1,2), Arrays.asList(1,1)), Arrays.asList(1,1), Arrays.asList(5,5)));
    }

}