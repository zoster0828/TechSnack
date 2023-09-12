package codingtest.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1647 {
    public int minDeletions(String s) {
        int[] nums = new int[26];
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < chars.length ; i++) {
            nums[chars[i]-'a']++;
        }

        Set<Integer> set = new HashSet();
        int result = 0;
        for (int num : nums) {
            while(num != 0 && set.contains(num)) {
                num-=1;
                result++;
            }
            set.add(num);
        }

        return result;
    }
}
