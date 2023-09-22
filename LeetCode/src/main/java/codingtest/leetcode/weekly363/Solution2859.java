package codingtest.leetcode.weekly363;

import java.util.List;

public class Solution2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int result = 0;
        for(int i = 0 ; i < nums.size() ; i ++){
            String value = Integer.toBinaryString(i);
            char[] chars = value.toCharArray();
            int count = 0 ;
            for(int l = 0 ; l < chars.length ; l++) {
                if(chars[l] == '1') {
                    count++;
                }
            }

            if(count == k) {
                result+=nums.get(i);
            }
        }

        return result;
    }
}
