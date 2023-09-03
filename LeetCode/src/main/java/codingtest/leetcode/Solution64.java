package codingtest.leetcode;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        int x = grid[0].length;
        int y = grid.length;
        int dp[][] = new int[y][x];
        dp[0][0] = grid[0][0];
        for(int i = 1 ; i < x ; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1 ; i <y ; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int i = 1 ; i < x ; i++) {
            for(int j = 1 ; j < y ; j++) {
                dp[j][i] = (dp[j-1][i] > dp[j][i-1] ? dp[j][i-1] : dp[j-1][i]) + grid[j][i];
            }
        }

        return dp[y-1][x-1];
    }
}
