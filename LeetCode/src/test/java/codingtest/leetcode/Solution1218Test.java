package codingtest.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class Solution1218Test {
    @Test
    void test1() {
//        Solution1218 solution = new Solution1218();
//        assertEquals(2, solution.longestSubsequence(new int[]{3,0,-3,4,-4,7,6},3 ));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(10);
        priorityQueue.add(5);
        while(priorityQueue.size() != 0) {
            Integer poll = priorityQueue.poll();
            System.out.println(poll);
        }
    }
}