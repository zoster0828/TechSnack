package codingtest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;

        return getAllSubArray(0, nums);
    }

    public List<List<Integer>> getAllSubArray(int k, int[] nums) {
        List<List<Integer>> result = new ArrayList();
        for(int i = k ; i < nums.length ; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0 ; j < temp.size() ; j++) {
                temp.add(nums[i]);
            }
            result.add(temp);
        }

        return getAllSubArray(k+1, nums);
    }
}
