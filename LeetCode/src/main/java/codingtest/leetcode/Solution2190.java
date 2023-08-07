package codingtest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution2190 {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> countMap = new HashMap();
        for(int i = 0 ; i < nums.length -1 ; i++) {
            if(nums[i] == key) {
                countMap.put(nums[i+1], countMap.getOrDefault(nums[i+1], 0) + 1);
            }
        }

        int max = 0;
        int result = 0;
        for(Integer num : countMap.keySet()) {
            if(countMap.get(num) > max) {
                result = num;
                max = countMap.get(num);
            }
        }

        return result;
    }
}
