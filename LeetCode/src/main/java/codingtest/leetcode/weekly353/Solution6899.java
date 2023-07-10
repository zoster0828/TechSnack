package codingtest.leetcode.weekly353;

public class Solution6899 {
    public int maximumJumps(int[] nums, int target) {
        int curr = nums[0];
        int count = 0;
        for(int i = 1 ; i < nums.length ; i ++) {
            int diff = nums[i] - curr;
            if(diff <= target && diff >= -target) {
                curr = nums[i];
                count ++;
            }
        }

        if(curr == nums[nums.length-1]) {
            return count;
        } else {
            int diff = nums[nums.length-1] - curr;
            if(diff <= target && diff >= -target) {
                return count +1;
            }
            return -1;
        }
    }
}
