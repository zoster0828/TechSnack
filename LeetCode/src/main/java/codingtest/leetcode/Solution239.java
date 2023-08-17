package codingtest.leetcode;

import java.util.*;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];

        int[] result = new int[n - k + 1];
        int resultIdx = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                List<Integer> temp = new ArrayList<>();
                while(!deque.isEmpty()){
                    int num = deque.poll();
                    temp.add(num);
                    System.out.print(num);
                }
                System.out.println();
                for (Integer integer : temp) {
                    deque.addLast(integer);
                }
                result[resultIdx++] = nums[deque.peekFirst()];
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
