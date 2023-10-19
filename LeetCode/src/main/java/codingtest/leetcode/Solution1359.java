package codingtest.leetcode;

public class Solution1359 {
    int MOD = 1000000007;
    public int countOrders(int n) {
        long all = 1;
        for(int i = 1 ; i <= n ; i++) {
            all *= i;
            all *= (2*i-1);
            all %= MOD;
        }

        return (int)all;
    }
}
