package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution1897Test {

    @Test
    void test1() {
        Solution1897 solution1897 = new Solution1897();
        assertEquals(true, solution1897.makeEqual(new String[]{"abc","aabc","bc"}));
        assertEquals(false, solution1897.makeEqual(new String[]{"ab","a"}));
        assertEquals(true, solution1897.makeEqual(new String[]{"b"}));
        assertEquals(true, solution1897.makeEqual(new String[]{"a","a","a"}));
        assertEquals(false, solution1897.makeEqual(new String[]{"a","b"}));
    }

}