package codingtest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1493 {
    public int longestSubarray(int[] nums) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int zerosCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zerosCount++;
            }

            while (zerosCount > 1) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left);
            right++;
        }

        if (maxLength == nums.length)
            maxLength--;

        return maxLength;
    }
}
