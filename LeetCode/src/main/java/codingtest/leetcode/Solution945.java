package codingtest.leetcode;

import java.util.Arrays;

public class Solution945 {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        int count  = 0;
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] <= prev) {
                int diff = prev - nums[i] + 1;
                prev = prev+1;
                count+= diff;
            } else {
                prev = nums[i];
            }
        }

        return count;
    }
}
