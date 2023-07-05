package codingtest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1493 {
    public int longestSubarray(int[] nums) {
        List<Position> result = new ArrayList();
        boolean start = false;
        boolean initial = false;
        Position position = null;
        for(int i = 0 ; i < nums.length ; i++) {
            if(!initial) {
                if(nums[i] == 0) {
                    if(result.size() == 0) {
                        result.add(Position.MIN());
                    }
                    continue;
                } else {
                    initial = true;
                }
            }

            if(nums[i] == 0) {
                if(position != null) {
                    position.end(i-1);
                } else {
                    position = Position.MIN();
                    result.add(position);
                }
                start = false;
                position = null;
            }

            if(nums[i] != 0) {
                if(!start) {
                    start = true;
                    position = new Position(i);
                    result.add(position);
                } else {
                    position.end(i);
                }
            }
        }

        if(result.size() == 1) {
            int max = result.get(0).getLength();
            return max == 0 ? max : max -1;
        }

        int max = 0;
        for(int i = 0 ; i < result.size() - 1 ; i++) {
            Position first = result.get(i);
            Position second = result.get(i+1);
            if(first.getLength() + second.getLength() > max) {
                max = first.getLength() + second.getLength();
            }
        }

        return max;
    }

    static class Position{
        int start;
        int end;
        public Position(int start) {
            this.start = start;
            this.end = start;
        }
        void end(int end) {
            this.end = end;
        }

        int getLength() {
            if(start == -1) {
                return 0;
            }
            return end - start + 1;
        }
        static Position MIN() {
            Position position = new Position(-1);
            return position;
        }
    }
}
