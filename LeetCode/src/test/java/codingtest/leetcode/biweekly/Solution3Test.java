package codingtest.leetcode.biweekly;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution3Test {
    @Test
    void test() {
        Solution3 solution3 = new Solution3();
        boolean xor = solution3.XOR(Arrays.asList(1, 3), Arrays.asList(1, 3),0);
        System.out.println(xor);
    }

}