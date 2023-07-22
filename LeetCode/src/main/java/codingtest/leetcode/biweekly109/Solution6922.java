package codingtest.leetcode.biweekly109;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution6922 {
    public int numberOfWays(int n, int x) {
        int MOD = 1000000007;

        // Create an array to store the number of ways for each sum from 1 to n
        int[] dp = new int[n + 1];
        dp[0] = 1; // There is one way to make sum 0, by not selecting any number

        for (int i = 1; i <= n; i++) {
            Set<Integer> usedPowers = new HashSet<>();
            for (int j = 1; j <= Math.pow(i, 1.0 / x); j++) {
                int power = (int) Math.pow(j, x);
                if (!usedPowers.contains(power)) {
                    dp[i] += dp[i - power];
                    usedPowers.add(power);
                }
            }
        }

        return dp[n] % MOD;
    }
}
