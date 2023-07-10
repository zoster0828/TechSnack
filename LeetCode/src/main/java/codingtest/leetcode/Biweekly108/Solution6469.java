package codingtest.leetcode.Biweekly108;

import java.util.*;

public class Solution6469 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int i = 0 ; i < moveFrom.length ; i++) {
            int from = moveFrom[i];
            int to = moveTo[i];
            map.remove(from);
            map.put(to, map.getOrDefault(to, 0)+ 1);
        }

        ArrayList<Integer> result = new ArrayList<>(map.keySet());
        Collections.sort(result);
        return result;
    }
}
