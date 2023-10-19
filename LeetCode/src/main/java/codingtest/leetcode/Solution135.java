package codingtest.leetcode;

import java.util.Arrays;

public class Solution135 {
    public int candy(int[] ratings) {
        int[] values = new int[ratings.length];
        Arrays.fill(values, 1);

        for (int i = 0; i < ratings.length-1; i++) {
            if(ratings[i] < ratings[i+1]) {
                values[i+1] = values[i]+1;
            }
        }

        for (int i = ratings.length -1 ; i > 0 ; i--) {
            if(ratings[i] < ratings[i-1] && values[i-1] <= values[i]) {
                values[i-1] = values[i]+1;
            }
        }

        return Arrays.stream(values).sum();
    }
}
