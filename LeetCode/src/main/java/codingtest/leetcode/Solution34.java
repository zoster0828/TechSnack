package codingtest.leetcode;

import java.util.Arrays;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {return new int[]{-1,-1};}
        int po = Arrays.binarySearch(nums, target);
        if(po < 0) {
            return new int[]{-1,-1};
        }

        int start = -1;
        int end = -1;
        for(int i = po ; i < nums.length ; i++) {
            if(nums[i] == target) {
                end = i;
            } else {
                break;
            }
        }

        for(int i = po ; i >= 0 ; i--) {
            if(nums[i] == target) {
                start = i;
            } else {
                break;
            }
        }

        return new int[]{start, end};
    }

//    private int findFirst(int[] nums, int po, int target, int prev) {
//        if(nums[po] > target) {
//            if(po == po/2 ) {
//                return -1;
//            }
//            return findFirst(nums, po/2, target, po);
//        } else if(nums[po] < target) {
//            if(po == po + ((nums.length - po)/2)) {
//                return -1;
//            }
//            return findFirst(nums, po + ((nums.length - po)/2), target, po);
//        } else {
//            return po;
//        }
//    }
}
