package codingtest.leetcode.contest;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q3 {
    private static int MODULO = (int) Math.pow(10, 9) + 7;
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        long temp[] = new long[n];
        for(int i = 0 ; i < n ; i++) {
            temp[i] = nums[i];
        }

        int[] top2 = findTop2(temp);

        for(int i = 0 ; i < k ; i++) {
            temp[top2[0]] = temp[top2[0]] * multiplier % MODULO;
            if(temp[top2[0]] < temp[top2[1]]) {

            } else {
                int t = top2[0];
                top2[0] = top2[1];
                top2[1] = t;
                top2 = findTop2(temp);
            }
        }

        for(int i = 0 ; i < n ; i++) {
            nums[i] = (int) temp[i];
        }

        return nums;
    }


    private int[] findTop2(long[] nums) {
        int[] top2 = new int[]{0,1};
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[top2[0]] > nums[i]) {
                top2[1] = top2[0];
                top2[0] = i;
            } else {
                if(nums[top2[1]] > nums[i]) {
                    top2[1] = i;
                }
            }
        }

        return top2;
    }
}
