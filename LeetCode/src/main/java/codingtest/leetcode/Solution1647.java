package codingtest.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1647 {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap();
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < chars.length ; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0)+1);
        }

        Set<Integer> set = new HashSet();
        int result = 0;
        for(Integer integer : map.values()) {
            while(integer != 0 && set.contains(integer)) {
                integer-=1;
                result++;
            }
            set.add(integer);
        }

        return result;
    }
}
