package codingtest.leetcode.biweekly;

import codingtest.leetcode.biweekly113.Solution3;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Solution3Test {
    @Test
    void test() {
        Solution3 solution3 = new Solution3();
        boolean xor = solution3.XOR(Arrays.asList(1, 3), Arrays.asList(1, 3),0);
        System.out.println(xor);
    }

}