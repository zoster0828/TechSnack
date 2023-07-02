package codingtest.leetcode.WeeklyContest352;

public class Solution6909 {
        public int longestAlternatingSubarray(int[] nums, int threshold) {
            int max = 0;
            int continuity = 0;
            for(int i = 0 ; i < nums.length ; i++) {
                if(nums[i] > threshold) {
                    continuity = 0;
                    continue;
                }

                if(nums[i] % 2 == 0 && continuity == 0) {
                    continuity = 1;
                    if(continuity > max) max = continuity;
                    continue;
                }

                if(nums[i] % 2 != continuity % 2) {
                    continuity = 0;
                    if(nums[i] %2 == 0) {
                        continuity = 1;
                        if(continuity > max) max = continuity;
                        continue;
                    }
                }

                if(continuity != 0) {
                    continuity++;
                    if(continuity > max) max = continuity;
                }

            }

            return max;
        }
}
