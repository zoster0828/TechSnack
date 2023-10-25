package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution779Test {
    @Test
    void test1() {
        Solution779 solution779 = new Solution779();
        assertEquals(1,solution779.kthGrammar(4,8));
        assertEquals(1,solution779.kthGrammar(30,417219134));
        assertEquals(1,solution779.kthGrammar(2,2));
        assertEquals(1,solution779.kthGrammar(4,5));
        assertEquals(0,solution779.kthGrammar(3,4));
        assertEquals(1,solution779.kthGrammar(3,3));
        assertEquals(0,solution779.kthGrammar(2,1));
        assertEquals(0,solution779.kthGrammar(1,1));
        assertEquals(0,solution779.kthGrammar(30,264193044));
    }
}