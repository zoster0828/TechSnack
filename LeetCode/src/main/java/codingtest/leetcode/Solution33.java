package codingtest.leetcode;

public class Solution33 {
    public int search(int[] nums, int target) {
        int pivot = 0;
        int prev = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i ++) {
            if(nums[i] < prev) {
                pivot = i;
                break;
            } else {
                prev = nums[i];
            }
        }

        int left = 0;
        int right = nums.length-1;

        return circularBinarySearch(nums, left, right, target, pivot);
    }

    public int circularBinarySearch(int[] nums, int left, int right, int target, int pivot){

        while(left <= right) {
            int mid = left + ((right - left) / 2);
            int value = nums[(mid+pivot)%nums.length];
            if(value == target) {
                return (mid+pivot)%nums.length;
            }

            if(value < target) {
                return circularBinarySearch(nums, left + ((right - left) / 2)+1, right, target, pivot);
            } else {
                return circularBinarySearch(nums, left, left + ((right - left) / 2)-1, target, pivot);
            }
        }
        return -1;
    }
}
