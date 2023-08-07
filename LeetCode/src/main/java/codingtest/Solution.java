package codingtest;

import codingtest.ListNode;

import java.util.*;

public class Solution {

    public int minimumSeconds(List<Integer> nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.computeIfAbsent(nums.get(i), t -> new ArrayList<>()).add(i);
        }
        int min = Integer.MAX_VALUE;
        for (ArrayList<Integer> list : map.values()) {
            int max = list.get(0) - list.get(list.size() - 1) + nums.size();
            for (int i = 1; i < list.size(); i++) {
                max = Math.max(max, list.get(i) - list.get(i - 1));
            }
            min = Math.min(min, max / 2);
        }
        return min;
    }
}