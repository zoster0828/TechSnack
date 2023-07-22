package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution146Test {

    @Test
    void test1() {
        Solution146 solution = new Solution146(2);
        solution.put(1,1);
        solution.put(2,2);
        assertEquals(1, solution.get(1));
        solution.put(3,3);
        assertEquals(-1, solution.get(2));
        solution.put(4,4);
        assertEquals(-1, solution.get(1));
        assertEquals(3, solution.get(3));
        assertEquals(4, solution.get(4));
    }


    @Test
    void test2() {
        Solution146 solution = new Solution146(10);
        for(int i = 0 ; i < 10 ; i ++) {
            solution.put(1+i, 1);
            solution.put(2+i, 2);
            solution.get(1);
            solution.put(3+i, 3);
            solution.get(2);
            solution.put(4+i, 4);
            solution.get(1);
            solution.get(3);
            solution.get(4);
        }
    }
}