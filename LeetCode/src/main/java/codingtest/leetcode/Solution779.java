package codingtest.leetcode;

public class Solution779 {
    public int kthGrammar(int n, int k) {
        boolean areValuesSame = true;

        n = (int) Math.pow(2, n - 1);

        while (n != 1) {
            n /= 2;
            if (k > n) {
                k -= n;
                areValuesSame = !areValuesSame;
            }
        }

        // Return 0 if the flag indicates that the values are the same; otherwise, return 1.
        return (areValuesSame ? 0 : 1);
    }
}

