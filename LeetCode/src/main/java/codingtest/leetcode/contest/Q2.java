package codingtest.leetcode.contest;

import java.util.HashSet;
import java.util.Set;

public class Q2 {
    public int countPairs(int[] nums) {
        int n = nums.length;
        int result = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = i+1 ; j < n ; j++) {
                if(isEqual(nums[i], nums[j])) {
                    result++;
                }
            }
        }

        return result;
    }

    private boolean isEqual(int a, int b) {
        if(a==b) return true;

        char[] aStr = Integer.toString(a).toCharArray();
        for(int i = 0 ; i < aStr.length ; i++) {
            for(int j = i+1 ; j < aStr.length ; j ++) {
                char temp = aStr[i];
                aStr[i] = aStr[j];
                aStr[j] = temp;
                int t = Integer.parseInt(new String(aStr));
                if(t == b) {
                    return true;
                } else {
                    aStr = Integer.toString(a).toCharArray();
                }
            }
        }

        aStr = Integer.toString(b).toCharArray();
        for(int i = 0 ; i < aStr.length ; i++) {
            for(int j = i+1 ; j < aStr.length ; j ++) {
                char temp = aStr[i];
                aStr[i] = aStr[j];
                aStr[j] = temp;
                int t = Integer.parseInt(new String(aStr));
                if(t == a) {
                    return true;
                } else {
                    aStr = Integer.toString(b).toCharArray();
                }
            }
        }

        return false;
    }
}
