package codingtest.leetcode.weekly355;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution6915 {
    public long maxArrayValue(int[] nums) {
        return calc(nums);
    }

    public int calc(int[] nums) {
        int[] result = new int[nums.length];
        boolean next = false;
        for (int i = 0, j = 0; i < nums.length - 1; ) {
            if(nums[i] == 0 && nums[i+1] == 0) break;
            if(nums[i] <= nums[i+1]) {
                result[j] = nums[i] + nums[i+1];
                i+=2;
                j++;
                next = true;
                if(i == nums.length-1) {
                    result[j] = nums[i];
                }
            } else {
                result[j] = nums[i];
                i++;
                j++;
            }
        }

        if(next) {
            return calc(result);
        } else {
            return result[0];
        }
    }
}
