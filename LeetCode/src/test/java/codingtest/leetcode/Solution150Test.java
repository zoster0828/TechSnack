package codingtest.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution150Test {
    @Test
    void test1() {
        Solution150 solution150 = new Solution150();
        solution150.evalRPN(new String[]{"2","1","+","3","*"});
        solution150.evalRPN(new String[]{"4","13","5","/","+"});
    }
}