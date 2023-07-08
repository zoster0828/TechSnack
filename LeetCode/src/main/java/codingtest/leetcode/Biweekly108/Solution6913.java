package codingtest.leetcode.Biweekly108;

public class Solution6913 {
    public int alternatingSubarray(int[] nums) {
        int max = -1;
        int left = 0;
        int right = 1;
        while(left < nums.length -1  && right < nums.length) {
            if(left != right && isThat(left, right, nums)){
                max = Math.max(max, right-left + 1);
                right++;
            }else {
                if(left == right) {
                    right++;
                }else {
                    left++;
                }
            }
        }

        return max;
    }

    boolean isThat(int start, int end, int[] nums) {
        int first = nums[start];
        int second = nums[start+1];
        int diff = second - first;
        if(diff != 1) {
            return false;
        }
        for(int i = start; i <= end  ; i+=2) {
            if(first != nums[i]) {
                return false;
            }
            if(i+1 <= end && second != nums[i+1]) {
                return false;
            }
        }
        return true;
    }
}
