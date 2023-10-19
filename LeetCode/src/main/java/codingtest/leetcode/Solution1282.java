package codingtest.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int num = groupSizes[i];
            List<Integer> list = map.get(num);
            if(list == null) {
                map.put(num, generateList(i));
                continue;
            }

            if(list.size() < num) {
                list.add(i);
            } else {
                result.add(list);
                map.put(num, generateList(i));
            }
        }

        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            result.add(integerListEntry.getValue());
        }

        return result;
    }

    private List<Integer> generateList(int i) {
        List<Integer> temp = new ArrayList<>();
        temp.add(i);
        return temp;
    }
}
