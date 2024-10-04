package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution2491Test {
    @Test
    void test1() {
        Solution2491 solution2491 = new Solution2491();
        solution2491.dividePlayers(new int[]{14,16,17,10,6,12,9,20});
        solution2491.dividePlayers(new int[]{14,20,12,17,7,6});
        solution2491.dividePlayers(new int[]{3,2,5,1,3,4});
    }

}