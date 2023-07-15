package codingtest.leetcode;

import java.util.Arrays;

public class Solution1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int max = 0;

        for(int i = 0 ; i < arr.length ; i ++) {
            int curr = 1;
            int po = i;
            for(int j = i+1 ; j < arr.length ; j++) {
                if(difference == (arr[j] - arr[po])) {
                    curr++;
                    po = j;
                }
            }
            max = Math.max(curr,max);
        }

        return max;
    }
}
