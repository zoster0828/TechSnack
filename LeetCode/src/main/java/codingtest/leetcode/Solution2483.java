package codingtest.leetcode;

public class Solution2483 {
    public int bestClosingTime(String customers) {
        char[] chars = customers.toCharArray();
        int plus = 0;
        int minus = 0;
        for (char aChar : chars) {
            if(aChar=='Y') {
                plus++;
            } else {
            }
        }

        int min = plus;
        int po = 0;
        int[] values = new int[chars.length+1];
        values[0] = plus;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='Y') {
                plus--;
            } else {
                minus++;
            }
            values[i+1] = plus+minus;

            if(values[i+1] < min) {
                min = values[i+1];
                po = i+1;
            }
        }

        return po;
    }
}
