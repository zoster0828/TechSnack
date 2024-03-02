package codingtest.leetcode;

public class Solution2815 {
    public int maxSum(int[] nums) {
        int max = -1;
        for(int i = 0 ; i < nums.length-1 ; i++) {
            for(int j = 1 ; j < nums.length ; j++) {
                int a = getMaxNum(nums[i]);
                int b = getMaxNum(nums[j]);

                if(a==b) {
                    max = Math.max(nums[i]+nums[j], max);
                }
            }
        }

        return max;
    }

    int getMaxNum(int a) {
        int max = 0;
        while(true) {
            max = Math.max(max, a%10);

            if(a < 10) {
                break;
            }

            a /= 10;
        }

        return max;
    }
}
