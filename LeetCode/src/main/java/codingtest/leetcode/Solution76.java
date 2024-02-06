package codingtest.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution76 {
    public String minWindow(String s, String t) {
        Map<Integer, List<Integer>> map = generateMap(s);

        char[] charArray = t.toCharArray();
        int min = Integer.MAX_VALUE;
        int start =  0;
        int end = s.length() - 1;
        while(true) {
            for (char c : charArray) {
                List<Integer> integers = map.get(getPo(c));
                for (Integer integer : integers) {
                    start = Math.min(start, integer);
                    end = Math.max(end, integer);
                }
            }

            if(min == end-start) {
                return s.substring(start, end);
            } else {
                min = end-start;
            }
        }

    }

    private Map<Integer, List<Integer>> generateMap(String s) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < chars.length; i ++) {
            List<Integer> orDefault = result.getOrDefault(getPo(chars[i]), new ArrayList<>());
            orDefault.add(i);
            result.put(getPo(chars[i]), orDefault);
        }

        return result;
    }

    private int getPo(char c) {
        if(c-'A'< 26) {
            return c-'A';
        } else {
            return  c-'a'+26;
        }
    }
}
