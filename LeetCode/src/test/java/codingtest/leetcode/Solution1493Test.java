package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

class Solution1493Test {

    @Test
    void test1() {
        Solution1493 solution = new Solution1493();
        System.out.println(solution.longestSubarray(new int[]{0,0,1,1,1,1,0,0,1,1,1,1,0,1,1,1,0}));
    }
}