package codingtest.leetcode.WeeklyContest352;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution6916 {
    public boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        return isPrime;
    }

    public List<List<Integer>> findPrimePairs(int n) {
        boolean[] isPrime = sieveOfEratosthenes(n);

        List<List<Integer>> pairs = new ArrayList<>();
        for (int x = 2; x <= n / 2; x++) {
            int y = n - x;
            if (isPrime[x] && isPrime[y]) {
                pairs.add(Arrays.asList(x,y));
            }
        }

        return pairs;
    }
}
