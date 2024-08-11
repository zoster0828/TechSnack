package codingtest.leetcode.weekly410;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2 {
    public int countGoodNodes(int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap();

        for(int edge[] : edges) {
            int key = edge[0];
            List<Integer> list = map.getOrDefault(key, new ArrayList());
            list.add(edge[1]);
            map.put(key, list);
            map.put(edge[1], new ArrayList());
        }

        int count = 0;
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            int size = -1;
            for (Integer integer : integerListEntry.getValue()) {
                if(size == -1) {
                    size = map.get(integer).size();
                }

                if(size != map.get(integer).size()) {
                    size = -2;
                    break;
                }
            }

            if(size != -2) count++;
        }

        return count;
    }
}
