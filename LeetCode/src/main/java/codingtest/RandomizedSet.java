package codingtest;

import java.util.*;

class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int po = map.get(val);
            int last = list.get(list.size() - 1);
            list.set(po, last);
            map.put(po, last);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }else {
            return false;
        }
    }

    public int getRandom() {
        int po = new Random().nextInt(list.size());
        return list.get(po);
    }
}