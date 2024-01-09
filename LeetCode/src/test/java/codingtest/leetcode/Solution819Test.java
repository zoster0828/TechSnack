package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution819Test {
    @Test
    void test1() {
        Solution819 solution819 = new Solution819();
        assertEquals("the", solution819.mostCommonWord( "abc abc? abcd the jeff!", new String[]{"abc","abcd","jeff"}));
        assertEquals("b", solution819.mostCommonWord( "a, a, a, a, b,b,b,c, c", new String[]{"a"}));
        assertEquals("ball", solution819.mostCommonWord( "Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
}