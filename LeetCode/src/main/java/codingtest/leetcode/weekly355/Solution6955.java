package codingtest.leetcode.weekly355;

import java.util.*;

public class Solution6955 {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        int n = usageLimits.size();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < usageLimits.size(); i++) {
            if(usageLimits.get(i) < n) {
                set.add(usageLimits.get(i));
            }
        }
        return 0;
    }
}
