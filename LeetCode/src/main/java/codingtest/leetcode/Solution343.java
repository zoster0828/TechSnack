package codingtest.leetcode;

public class Solution343 {
    public int integerBreak(int n) {
        int max = Integer.MIN_VALUE;

        for(int candidate = 2 ; candidate <= n ; candidate++) {
            int quotient = n / candidate;
            int remainder = n % candidate;

            int result = 1;
            for(int times = 0 ; times < candidate ; times++) {
                result = result * (quotient+(remainder-- > 0 ? 1 : 0));
            }

            if(max < result) {
                max = result;
            }
        }

        return max;
    }
}
