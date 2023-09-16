package codingtest.leetcode.biweekly113;

import java.util.List;

public class Solution1 {
    public int minimumRightShifts(List<Integer> nums) {
        int count = 0;
        while(true) {
            if(isIncrease(nums)) {
                break;
            } else {
                count++;
                shift(nums);
            }

            if(count > nums.size()) {
                return -1;
            }
        }
        return count;
    }

    private void shift(List<Integer> nums) {
        int num = nums.get(nums.size()-1);
        nums.remove(nums.size()-1);
        nums.add(0,num);
    }

    private boolean isIncrease(List<Integer> nums) {
        int prev = Integer.MIN_VALUE;
        for (Integer num : nums) {
            if(num > prev) {
                prev = num;
            }
            else {
                return false;
            }
        }

        return true;
    }
}
