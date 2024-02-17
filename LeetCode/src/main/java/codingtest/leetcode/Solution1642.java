package codingtest.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        if(ladders > heights.length) return heights.length -1;
        int used = 0;
        List<Integer> max = new ArrayList<>();
        for(int i = 1 ; i < heights.length ; i++) {
            if(heights[i] > heights[i-1]) {
                used += heights[i] - heights[i-1];
                addMax(max, heights[i] - heights[i-1], ladders);

                if(used > bricks) {
                    if(ladders > 0) {
                        ladders --;
                        int top = getMax(max);
                        used -= top;
                    } else {
                        return i-1;
                    }
                }
            }


        }

        return heights.length-1;
    }

    private int getMax(List<Integer> max) {
        int value = max.get(max.size()-1);
        max.remove(max.size()-1);
        return value;
    }

    private void addMax(List<Integer> max, int value, int ladders) {
        int insertPos = Collections.binarySearch(max, value);
        if (insertPos < 0) {
            insertPos = -(insertPos + 1);
        }

        max.add(insertPos, value);

        while (max.size() > ladders) {
            max.remove(0);
        }
    }
}
