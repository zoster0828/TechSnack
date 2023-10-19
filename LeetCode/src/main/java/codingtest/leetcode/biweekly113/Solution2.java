package codingtest.leetcode.biweekly113;

import java.util.List;

public class Solution2 {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int left = 0 , right = nums.size()-1;
        int ok = 0;
        while(right > left) {
            if(nums.get(left) < nums.get(right)) {
                left ++;
                right--;
                ok++;
            } else {
                ok--;
                if(ok >= 0) {
                    left ++;
                    right--;
                    continue;
                }else {
                    break;
                }
            }

        }
        if(left == 0) return right+1;
        if(left == right) {
            return 1;
        }
        return left-right-1;
    }
}
