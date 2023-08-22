package codingtest.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution146 {
    private int capacity;
    private Map<Integer, Value> map;
    private int time;
    private Queue<Key> queue;

    public Solution146(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap();
        this.time = 0;
        this.queue = new LinkedList();
    }

    public int get(int key) {
        time++;
        Value value = map.get(key);
        if(value == null) {
            return -1;
        }
        add(key, value.getValue(), time);
        int result = map.get(key).getValue();
        return result;
    }

    public void put(int key, int value) {
        time++;
        if(map.containsKey(key)) {
            add(key, value, time);
        } else {
            if(capacity == map.size()) {
                evict();
            }
        }

        add(key, value, time);
    }

    public void evict() {
        Key key = queue.poll();
        Value value = map.get(key.getKey());
        if(value == null) {
            evict();
            return;
        }
        try {
            if (key.getTime() == value.getTime())
                map.remove(key.getKey());
            else {
                evict();
            }
        }catch (Exception e) {
            System.out.println();
        }
    }

    private void add(int key, int value, int time) {
        map.put(key, new Value(value, time));
        queue.add(new Key(key, time));
    }

    class Value{
        private int value;
        private int time;
        public Value(int value, int time) {
            this.value = value;
            this.time = time;
        }

        public void update(int time) {
            this.time = time;
        }

        public int getValue() {
            return this.value;
        }

        public int getTime() {
            return this.time;
        }
    }

    class Key{
        private int key;
        private int time;
        public Key(int key, int time) {
            this.key = key;
            this.time = time;
        }

        public void update(int time) {
            this.time = time;
        }

        public int getKey() {
            return this.key;
        }

        public int getTime() {
            return this.time;
        }
    }
}
