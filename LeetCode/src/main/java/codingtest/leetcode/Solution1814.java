package codingtest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1814 {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0 ; i  < nums.length ; i++) {
            int key = diff(nums[i]);
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result += pairs(entry.getValue());
        }

        return result;
    }

    int pairs(int num) {
        return ((num * num) - num) / 2;
    }

    int diff(int num) {
        int rev = rev(num);

        return Math.abs(num-rev);
    }

    int rev(int num) {
        int result = 0;
        while(num != 0) {
            int v = num % 10;
            result *= 10;
            result += v;
            num /= 10;
        }

        return result;
    }
}
