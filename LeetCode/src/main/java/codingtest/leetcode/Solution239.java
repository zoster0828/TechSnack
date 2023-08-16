package codingtest.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Value> queue = new PriorityQueue();
        for (int i = 0; i < k; i++) {
            queue.add(new Value(nums[i], i));
        }

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i++) {
            queue.add(new Value(nums[i+k-1], i+k-1));
            Value value = null;
            while(true) {
                value = queue.poll();
                if (value.position < i || value.position >= i + k) {
                    continue;
                }
                break;
            }
            result[i] = value.value;
            queue.add(value);
        }

        return result;
    }

    public static class Value implements Comparable<Value>{
        int value;
        int position;

        public Value(int value, int position) {
            this.value = value;
            this.position = position;
        }

        @Override
        public int compareTo(Value o) {
            return o.value >= this.value ? 1 : -1;
        }
    }
}
