package codingtest.leetcode.biweekly109;

public class Solution6931 {
    public long maxScore(int[] nums, int x) {
        long dp[] = new long[2];

        dp[nums[0]%2]=nums[0];
        dp[(nums[0]%2)^1]=Long.MIN_VALUE;
        for(int i = 1;i<nums.length;i++){
            dp[nums[i]%2]=Math.max(dp[nums[i]%2]+nums[i],dp[(nums[i]%2)^1]+nums[i]-x);
        }
        return Math.max(dp[0],dp[1]);
    }
}
