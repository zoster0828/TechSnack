package codingtest.leetcode;

public class Solution3005 {
    public int maxFrequencyElements(int[] nums) {
        int max = 0;
        int[] num = new int[101];
        for(int i : nums) {
            num[i]++;
            max = Math.max(num[i], max);
        }

        int result = 0;
        for(int i = 0 ; i < num.length ; i++) {
            if(num[i] == max) {
                result += max;
            }
        }

        return result;
    }
}
