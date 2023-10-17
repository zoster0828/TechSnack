package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1361Test {

    @Test
    void test1() {
        Solution1361 solution1361 = new Solution1361();
        assertFalse(solution1361.validateBinaryTreeNodes(2, new int[]{1,0}, new int[]{-1,-1}));
        assertTrue(solution1361.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,-1,-1,-1}));
        assertFalse(solution1361.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,3,-1,-1}));
    }
}