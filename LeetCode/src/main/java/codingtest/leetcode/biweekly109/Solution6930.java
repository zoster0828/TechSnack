package codingtest.leetcode.biweekly109;

public class Solution6930 {
    public boolean isGood(int[] nums) {
        int result[] = new int[nums.length+10000];
        for(int i = 0 ; i < nums.length ; i++) {
            result[nums[i]] += 1;
        }

        for(int i = 1 ; i < nums.length; i++) {
            if(result[i] != 1) {
                return false;
            }
        }

        if(result[nums.length] != 2) {
            return false;
        }

        return true;
    }
}
