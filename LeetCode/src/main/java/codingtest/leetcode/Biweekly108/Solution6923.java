package codingtest.leetcode.Biweekly108;

import java.util.ArrayList;
import java.util.List;

public class Solution6923 {
    public int minimumBeautifulSubstrings(String s) {
        return partition(s, 0);
    }

    private int partition(String s, int start) {
        if (start == s.length()) {
            return 0;
        }

        int minSubstrings = Integer.MAX_VALUE;
        long num = 0;

        for (int i = start; i < s.length(); i++) {
            num = num * 2 + (s.charAt(i) - '0');

            if (s.charAt(start) == '0') {
                break; // Skip subarrays with leading zeros
            }

            if (num > 0 && isPowerOfFive(num)) {
                int remainingSubstrings = partition(s, i + 1);

                if (remainingSubstrings != -1) {
                    minSubstrings = Math.min(minSubstrings, 1 + remainingSubstrings);
                }
            }
        }

        return minSubstrings == Integer.MAX_VALUE ? -1 : minSubstrings;
    }

    private boolean isPowerOfFive(long num) {
        while (num > 1) {
            if (num % 5 != 0) {
                return false;
            }
            num /= 5;
        }
        return num == 1;
    }
}
