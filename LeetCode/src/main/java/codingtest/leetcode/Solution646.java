package codingtest.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparing(f -> f[1]));
        for (int[] pair : pairs) {
            priorityQueue.add(pair);
        }
        int resultLength = 0;
        int prev = Integer.MIN_VALUE;
        while(!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            if(poll[0] > prev) {
                prev = poll[1];
                resultLength++;
            }
        }

        return resultLength;
    }
}
