package codingtest.leetcode;

import java.util.*;

public class Solution1751 {
    public int maxValue(int[][] events, int k) {
        List<Integer> starts = new ArrayList();
        Map<Integer, Event> map = new HashMap();
        for(int i = 0 ; i < events.length ; i++) {
            starts.add(events[i][0]);
            map.put(events[i][0], new Event(events[i]));
        }

        Collections.sort(starts);

        int max = 0;



        for(int start = 0 ; start < starts.size() ; start++) {
            int curr = 0;
            int count = 1;

            Event event = map.get(starts.get(start));
            curr += event.value;
            for(int start2 = start +1 ; start2 < starts.size() ; start2++) {
                if(k == count) {
                    break;
                }
                if(event.end >= starts.get(start2)) {
                    continue;
                } else {
                    event = map.get(starts.get(start2));
                    curr += event.value;
                    count ++;
                }
            }
            max = Math.max(curr, max);
        }

        return max;
    }

    public class Event{
        int start;
        int end;
        int value;
        float avg;
        public Event(int[] arr) {
            this.start = arr[0];
            this.end = arr[1];
            this.value = arr[2];
            this.avg = (float) this.value / (this.end - this.start +1);
        }
    }
}
