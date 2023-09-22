package codingtest.leetcode.weekly363;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution2861Test {
    @Test
    void test() {
        Solution2861 solution2861 = new Solution2861();
        assertEquals(2, solution2861.maxNumberOfAlloys(3,2,15, Arrays.asList(Arrays.asList(1,1,1), Arrays.asList(1,1,10)), Arrays.asList(0,0,0), Arrays.asList(1,2,3)));
        assertEquals(5, solution2861.maxNumberOfAlloys(3,2,15, Arrays.asList(Arrays.asList(1,1,1), Arrays.asList(1,1,10)), Arrays.asList(0,0,100), Arrays.asList(1,2,3)));
        assertEquals(2, solution2861.maxNumberOfAlloys(2,3,10, Arrays.asList(Arrays.asList(2,1), Arrays.asList(1,2), Arrays.asList(1,1)), Arrays.asList(1,1), Arrays.asList(5,5)));
    }

}