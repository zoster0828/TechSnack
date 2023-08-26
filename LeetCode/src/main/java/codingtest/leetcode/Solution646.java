package codingtest.leetcode;

import java.util.*;

public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int cur = Integer.MIN_VALUE, ans = 0;

        for (int[] pair : pairs) {
            if (cur < pair[0]) {
                cur = pair[1];
                ans++;
            }
        }

        return ans;
    }
}
