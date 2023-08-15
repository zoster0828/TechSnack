package codingtest.leetcode;

import java.util.Arrays;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {

        int top[] = new int[k];
        for(int i = 0 ; i < top.length ; i++) {
            top[i] = nums[i];
        }
        Arrays.sort(top);

        for(int i = top.length ; i < nums.length ; i++) {
            replace(top, nums[i]);
        }

        return top[0];
    }

    public void replace(int[] top, int num) {
        if(top[0] <= num) {
            top[0] = num;
        }

        for(int i = 0 ; i< top.length -1; i ++) {
            if(top[i] > top[i+1]) {
                int temp = top[i+1];
                top[i+1] = top[i];
                top[i] = temp;
            } else {
                break;
            }
        }
    }
}
