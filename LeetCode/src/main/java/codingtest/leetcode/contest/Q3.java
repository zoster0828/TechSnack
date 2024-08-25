package codingtest.leetcode.contest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q3 {
    PriorityQueue<Num> queue = new PriorityQueue<>((o1, o2) -> {
        if(o1.val == o2.val) {
            return o1.po - o2.po;
        } else {
            return Long.compare(o1.val, o2.val);
        }
    });
    private static int MODULO = (int) Math.pow(10, 9) + 7;
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i = 0 ; i < nums.length ; i++) {
            queue.add(new Num(i, nums[i]));
        }

        for(int i = 0 ; i < k ; i++) {
            Num candid = queue.poll();
            candid.val = ((candid.val * multiplier) % MODULO);
            queue.add(candid);
        }

        int[] result = new int[nums.length];
        while(!queue.isEmpty()) {
            Num temp = queue.poll();
            result[temp.po] = temp.val.intValue();
        }

        return result;
    }

    class Num{
        int po;
        Long val;
        public Num(int po, int val) {
            this.po = po;
            this.val = (long) val;
        }
    }
}
