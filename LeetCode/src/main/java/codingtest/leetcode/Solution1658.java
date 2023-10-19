package codingtest.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1658 {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0; // sum of all item in array
        for(int num : nums) totalSum += num;

        int maxLength = -1; //max length of subarray whose sum == totalSum - x
        int currSum = 0;

        int i = 0, j = 0;
        // Using sliding window techinque
        while(j < nums.length){
            currSum += nums[j];
            // If currSum > totalSum - x
            while(i <= j && currSum > totalSum - x)
                currSum -= nums[i++];
            // found expected subarray
            if(currSum == totalSum - x)
                maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }

        if(maxLength == -1) return -1;
        else return nums.length - maxLength;
    }
}
