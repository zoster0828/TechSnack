package codingtest.leetcode.weekly354;

import java.util.List;

public class Solution6972 {
        public int minimumIndex(List<Integer> nums) {
            int curr = -1;
            int okay = 0;
            for(int i = 0 ; i < nums.size() ; i++) {
                if(nums.get(i) == curr) {
                    okay++;
                } else {
                    if(okay < 0) {
                        curr = nums.get(i);
                        okay = 0;
                    }else {
                        okay--;
                    }
                }

                if(okay > 1) {
                    int valid = validArray(nums.subList(i+1, nums.size()));
                    if(valid == -1) {

                    } else {
                        if(valid == curr){
                            return i;
                        }
                    }
                }
            }

            return -1;
        }
        int validArray(List<Integer> nums) {
            int curr = -1;
            int okay = 0;
            for(int i = 0 ; i < nums.size() ; i++) {
                if(nums.get(i) == curr) {
                    okay++;
                } else {
                    if(okay < 0) {
                        curr = nums.get(i);
                        okay = 0;
                    } else {
                        okay--;
                    }
                }
            }
            if(okay > 1) {
                return curr;
            } else {
                return -1;
            }
        }
}
