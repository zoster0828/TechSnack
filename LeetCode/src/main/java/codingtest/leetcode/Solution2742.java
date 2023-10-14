package codingtest.leetcode;

import java.util.*;

public class Solution2742 {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        PriorityQueue<Value> priorityQueue = new PriorityQueue<>();
        Map<Integer, PriorityQueue<Value>> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            Value value = new Value(cost[i], time[i], i);
            priorityQueue.add(value);
            PriorityQueue<Value> temp = map.getOrDefault(time[i] , new PriorityQueue<Value>());
            temp.add(value);
            map.put(time[i], temp);
        }

        int sum = 0;
        int timeDuration = 0;
        Set<Integer> used = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            Value value = priorityQueue.peek();
            if(value.time > n - timeDuration) {
                PriorityQueue<Value> priorityQueue1 = map.get(n - timeDuration);
                while(priorityQueue1 != null && !priorityQueue1.isEmpty()) {
                    Value temp = priorityQueue1.poll();
                    if(used.contains(temp.index)) {
                        continue;
                    }
                    if(temp.cost < value.cost) {
                        sum += temp.cost;
                        break;
                    }
                }
                if(timeDuration >= --n) {
                    break;
                }
            }

            sum += value.cost;
            timeDuration += value.time;
            used.add(value.index);
            priorityQueue.poll();
            if(timeDuration >= --n) {
                break;
            }
        }

        return sum;
    }

    public class Value implements Comparable<Value>{
        float point;
        int cost;
        int time;
        int index;

        public Value(int cost, int time, int index) {
            this.point = (float) cost /time;
            this.cost = cost;
            this.time = time;
            this.index = index;
        }

        @Override
        public int compareTo(Value o) {
            if(o.point == this.point) {
                return 0;
            }
            return this.point > o.point ? 1 : -1;
        }
    }
}
