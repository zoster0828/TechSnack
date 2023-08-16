package codingtest.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Value> queue = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            queue.add(new Value(nums[i], i));
        }

        int[] result = new int[nums.length - k +1];

        for (int i = 0; i < result.length; i++) {
            List<Value> popped = new ArrayList<>();
            while(true) {
                Value value = queue.poll();
                popped.add(value);
                if(i <= value.position && i+k > value.position) {
                    result[i] = value.value;
                    break;
                }
            }
            for (Value value : popped) {
                queue.add(value);
            }
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
