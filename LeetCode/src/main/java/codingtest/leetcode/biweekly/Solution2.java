package codingtest.leetcode.biweekly;

import java.util.List;

public class Solution2 {
    public int minLengthAfterRemovals(List<Integer> nums) {
        boolean[] removed = new boolean[nums.size()];
        Integer prev = null;
        Integer prevNum = null;
        for (int i = 0; i < nums.size(); i++) {
            if(removed[i]) {
                continue;
            }
            if(prev == null ){
                prev = nums.get(i);
                prevNum = i;
                continue;
            }

            if(nums.get(i) > prev) {
                removed[i] = true;
                removed[prevNum] = true;
                prev = null;
                prevNum = null;
                i=0;
            }
        }

        int result = 0;
        for (boolean b : removed) {
            if(!b) {
                result++;
            }
        }
        return result;
    }
}
