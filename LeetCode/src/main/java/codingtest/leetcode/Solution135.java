package codingtest.leetcode;

import java.util.Arrays;

public class Solution135 {
    public int candy(int[] ratings) {
        int[] values = new int[ratings.length];
        int current = 1;
        int prev = ratings[0];
        values[0] = 1;
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i < ratings.length ; i++) {
            if(ratings[i] > prev) {
                current++;
            } else {
                current--;
            }
            if(current < min) {
                min = current;
            }
            prev = ratings[i];
            values[i] = current;
        }

        for(int i = 0 ; i < values.length ; i++) {
            if(values[i] < 1) {
                if(i + 1 == values.length || values[i+1] > values[i]) {
                    plus(values, i);
                }
            }
        }

        return Arrays.stream(values).sum();
    }

    private void plus(int[] values, int start) {
        int diff = 1 - values[start];
        int prev = Integer.MIN_VALUE;
        values[start] = 1;

        for(int i = start -1 ; i >= 0 ; i-- ) {
            if(values[i] >= prev) {
                values[i] += diff;
                prev = values[i];
            } else {
                break;
            }
        }

        prev = Integer.MAX_VALUE;
        for(int i = start+1 ; i < values.length ; i++ ) {
            if(values[i] < prev) {
                values[i] += diff;
                prev = values[i];
            } else {
                break;
            }
        }
    }

}
