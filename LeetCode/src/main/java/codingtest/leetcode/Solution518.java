package codingtest.leetcode;

public class Solution518 {
    public int change(int amount, int[] coins) {
        if(amount == 0) return 1;
        if(coins.length ==1 && amount % coins[0] == 0) {
            return 1;
        }

        int dp[] = new int[amount+1];
        dp[0] = 0;
        int n = coins.length;
        for(int i = 0 ; i < n ; i++) {
            int num = coins[i];
            while(num <= amount) {
                dp[num] += 1;
                num += coins[i];
            }
        }

        int prev = coins[0];
        for(int i = 1 ; i < dp.length ; i++) {
            dp[i] = dp[i] + dp[i-1];
        }

        return dp[amount];
    }
}
