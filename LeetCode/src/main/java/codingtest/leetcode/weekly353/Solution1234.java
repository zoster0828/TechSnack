package codingtest.leetcode.weekly353;

public class Solution1234 {
    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int resultIdx = 0;
        int prev = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums1.length ; i++) {
            if(Math.min(nums1[i], nums2[i]) >= prev){
                result[resultIdx] = Math.min(nums1[i], nums2[i]);
                prev = result[resultIdx];
                resultIdx++;
            } else if(Math.max(nums1[i], nums2[i]) >= prev) {
                result[resultIdx] = Math.max(nums1[i], nums2[i]);
                prev = result[resultIdx];
                resultIdx++;
            } else {}
        }

        int count = 0;
        for(int num : result) {
            if(num != 0) {
                count ++;
            } else {
                break;
            }
        }
        return count;
    }
}
